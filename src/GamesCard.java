import starterPackage.CreditCard;

public class GamesCard extends CreditCard {

    public GamesCard(int primaryCredit, int primaryBalance, int primaryLimit) {
        super(primaryCredit, primaryBalance, primaryLimit);
    }

    public void payGames(int amount, String purchaseType, boolean useBonus){
        double percentBonus = switch (purchaseType){ // в зависимости от типа покупоки будет начислено определенное кол-во бонусов
            case ("food"),("entertainment"),("club"),("electStore"),("transport") -> 0.02;
            case ("gameStore") -> 0.05;
            default -> 0.01;
        };
        int writeOFF = super.useBonus(amount, useBonus,percentBonus); // узнаем сумму, которую необходимо списать в зависимости от использования бонусов
        super.payProduct(writeOFF); // оплата покупки
    }
}
