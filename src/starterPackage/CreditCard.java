package starterPackage;

public class CreditCard extends BankCard { // производный класс "Кредитная карта" от класса "Банковская карта"

    private int creditMoney; // свойство "кредитные средства"
    private final int limit; // свойство "лимит"

    public CreditCard(int primaryCredit, int primaryBalance, int primaryLimit) {
        super(primaryBalance);
        this.creditMoney = primaryCredit;
        this.limit = primaryLimit;
    }

    private synchronized void payCreditFunds(int amount) { // фунция "оплатить кредитными средствами"
        this.creditMoney -= amount;
    }

    public boolean payProduct(int amount) { // функция "купить продукт"
        boolean paymentState = true;
        if (super.getBalance() > 0) { // проверка на наличие собсвенных средств
            if (super.getBalance() > amount) { // если да, то проверяем хватает ли средств на покупку
                super.pay(amount); // если да, то платим с собсвенных средств
            } else {
                int credit = amount - super.getBalance(); // если нет, то узнаем сколько не хватает на покупку
                if (credit < this.creditMoney) { // проверяем хватит ли кредитных средств на покупку
                    super.pay(super.getBalance()); // если да, то списываем деньги до 0 с собсвенных средств
                    payCreditFunds(credit); // а после остаток с кредитных средств
                } else
                    System.out.println("Нет средств на покупку"); // если денег не хватает на покупку, то отказываем в оплате
                paymentState = false;
            }
        } else if (this.creditMoney > amount) { // если собсвенных средств нет, то проверяем хватит ли кредитных средсв на покупку
            payCreditFunds(amount);
        } else {
            System.out.println("Нет средств на покупку");
            paymentState = false;
        }
        infoBalance();
        return paymentState;
    }

    private synchronized void topUpCreditFunds(int amount) { // функция "пополнить кредитные средства"
        this.creditMoney += amount;
    }

    public void topUpFunds(int amount) { // функция "пополнить средства"
        if (this.creditMoney < this.limit) { // если кредитных средств меньше лимита
            int credit = this.limit - this.creditMoney; // то узнаем на сколько необходимо поплнить до лимита
            if (credit >= amount) { // если кредит больше пополняемой суммы
                topUpCreditFunds(amount); // то закрываем долг по кредитным средствам
            } else {
                topUpCreditFunds(credit); // если нет, то закрываем долг по кредитным средствам
                super.topUp(amount - credit); // оставшиеся деньги начисляем на собсвенные средства
            }
        } else {
            super.topUp(amount); // если кредитных средств столько же, сколько и лимит,
            // то все начисляемые деньги идут в счет собсвенных средсвт
        }
        infoBalance();
    }

    @Override
    public void infoBalance() { // функция "получить информацию о балансе"
        System.out.println("Ваш кредитный лимит: " + this.limit);
        System.out.println("Кредитные средства: " + this.creditMoney);
        super.infoBalance();
    }
}
