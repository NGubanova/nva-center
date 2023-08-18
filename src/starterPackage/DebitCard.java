package starterPackage;
public class DebitCard extends BankCard { // производный класс "Дебетовая карта" от класса "Банковская карта"
    public DebitCard(int primaryBalance) {
        super(primaryBalance);
    }
    @Override
    public void topUp(int amount){ // функция "пополнить"
        super.topUp(amount);
    }
    @Override
    public void infoBalance(){ // функция "получить информацию о балансе"
        super.infoBalance();
    }
}
