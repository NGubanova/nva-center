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

    public boolean payProduct(int amount) {
        boolean paymentState = true;
        if (super.getBalance() > 0) {
            if (super.getBalance() > amount) {
                super.pay(amount);
            } else {
                int credit = amount - super.getBalance();
                if (credit < this.creditMoney) {
                    super.pay(super.getBalance());
                    payCreditFunds(credit);
                } else
                    System.out.println("Нет средств на покупку");
                paymentState = false;
            }
        } else if (this.creditMoney > amount) {
            payCreditFunds(amount);
        } else {
            System.out.println("Нет средств на покупку");
            paymentState = false;
        }
        return paymentState;
    }

    private synchronized void topUpCreditFunds(int amount) {
        this.creditMoney += amount;
    }

    public void topUpFunds(int amount) {
        int credit = this.limit - this.creditMoney;
        if (this.creditMoney < this.limit) {
            if (credit >= amount) {
                topUpCreditFunds(amount);
            } else {
                topUpCreditFunds(credit);
                super.topUp(amount - credit);
            }
        } else {
            super.topUp(amount);
        }
    }

    @Override
    public void infoBalance() {
        System.out.println("Ваш кредитный лимит: " + this.limit);
        System.out.println("Кредитные средства: " + this.creditMoney);
        super.infoBalance();
    }
}
