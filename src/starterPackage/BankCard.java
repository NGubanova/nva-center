package starterPackage;

abstract class BankCard {
    private int balance;
    private int bonus;

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

    private void addBonus(int amount){
        this.bonus += amount;
    }

    private void spendBonus(int amount){
        this.bonus -= amount;
    }
    protected int getBonus(){
        return bonus;
    }

    protected int useBonus(int amount, boolean useBonus, double percentBonus){
        int writeOFF=1;
        if (useBonus){
            if (amount > getBonus()){
                int remainder = amount - getBonus();
                writeOFF = remainder;
                spendBonus(getBonus());
                addBonus((int) Math.round(remainder*percentBonus));
            } else {
                int spentBonus = getBonus() - amount+1;
                spendBonus(spentBonus);
            }
        } else {
            writeOFF=amount;
            addBonus((int) Math.round(amount*percentBonus));
        }
        return writeOFF;
    }
}
