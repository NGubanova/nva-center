import starterPackage.DebitCard;

public class YoungsCard extends DebitCard { // Производный класс "Молодежная карта" от класса "Дебетовая карта"
    public YoungsCard(int primaryBalance) {
        super(primaryBalance);
    }

    public void payYoungs(int amount, boolean useBonus){ // функция "покупка"
        int writeOFF =super.useBonus(amount, useBonus, 0.01); // узнаем сумму, которую необходимо списать в зависимости от использования бонусов
        super.pay(writeOFF); // оплата покупки
        infoBalance(); // информация о  балансе
    }

    @Override
    public synchronized void topUp(int amount){ // функция "пополнить баланс"
        super.topUp(amount);
        infoBalance();
    }

    @Override
    public void infoBalance(){ // функция "информация о балансе"
        super.infoBalance();
        System.out.println("Бонусные баллы: "+super.getBonus());
    }
}
