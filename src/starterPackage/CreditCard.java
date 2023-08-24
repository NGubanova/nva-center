package starterPackage;

public class CreditCard extends BankCard {

    private int creditMoney;
    private final int limit;

    public CreditCard(int primaryCredit, int primaryBalance, int primaryLimit) {
        super(primaryBalance);
        this.creditMoney = primaryCredit;
        this.limit = primaryLimit;
    }

    private synchronized void payCreditFunds(int amount) {
        this.creditMoney -= amount;
    }

    public void payCreditCard(int amount) {
        if (super.getBalance() > 0) {
            verificationFunds(amount);
        }else if (this.creditMoney > amount) {
            payCreditFunds(amount);}
        else {
            System.out.println("Нет средств на покупку");
        }
    }

    private void verificationFunds(int amount){
        if (super.getBalance() > amount) {
            super.pay(amount);
        } else {
            verificationCreditFunds(amount);
        }
    }

    private void verificationCreditFunds(int amount){
        int credit = amount - super.getBalance();
        if (credit < this.creditMoney) {
            super.pay(super.getBalance());
            payCreditFunds(credit);
        } else
            System.out.println("Нет средств на покупку");
    }

    private synchronized void topUpCreditFunds(int amount) {
        this.creditMoney += amount;
    }

    public void topUpFunds(int amount) {
        if (this.creditMoney < this.limit) {
            verificationAccount(amount);
        } else {
            super.topUp(amount);
        }
    }
    
    private void verificationAccount(int amount){
        int credit = this.limit - this.creditMoney;
        if (credit >= amount) {
            topUpCreditFunds(amount);
        } else {
            topUpCreditFunds(credit);
            super.topUp(amount - credit);
        }
    }

    @Override
    public void infoBalance() {
        System.out.println("Ваш кредитный лимит: " + this.limit);
        System.out.println("Кредитные средства: " + this.creditMoney);
        super.infoBalance();
    }
}
