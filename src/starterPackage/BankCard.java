package starterPackage;

abstract class BankCard {
    private int balance;
    private int bonus;
    private int writeOffAmount = 1;
    private int accruedBonus = 0;

    public BankCard(int primaryBalance) {
        this.balance = primaryBalance;
    }

    protected synchronized void topUp(int amount){
        if (amount > 0){
            this.balance += amount;
        }
    }

    protected synchronized void pay(int amount){
        if (amount > 0 && amount <= this.balance){
            this.balance -= amount;
        }
    }

    protected void infoBalance() {
        System.out.println("Собственные средства: "+balance);
    }

    protected int getBalance() {
        return balance;
    }

    private void topUpBonus(int amount){
        this.bonus += amount;
    }

    private void spendBonus(int amount){
        this.bonus -= amount;
    }
    protected int getBonus(){
        return bonus;
    }

    protected int useBonus(int amount, boolean useBonus, double percentBonus){
        if (useBonus){
            payWithUseBonus(amount, percentBonus);
        } else {
            payWithoutUseBonus(amount, percentBonus);
        }
        return writeOffAmount;
    }

    private void payWithUseBonus(int amount,double percentBonus){
        if (amount > getBonus()){
            int remainder = getRemainder(amount);
            writeOffAmount = remainder;
            spendBonus(getBonus());
            accruedBonus = (int) Math.round(remainder*percentBonus);
        } else {
            int spentBonus = getBonus() - amount + 1;
            spendBonus(spentBonus);
        }
        topUpBonus(accruedBonus);
    }

    private void payWithoutUseBonus(int amount,double percentBonus){
        writeOffAmount=amount;
        accruedBonus =(int) Math.round(amount*percentBonus);
        topUpBonus(accruedBonus);
    }

    private int getRemainder(int amount){
        return amount-getBonus();
    }
}
