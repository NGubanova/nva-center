import starterPackage.CreditCard;

public class GamesCard extends CreditCard {

    public GamesCard(int primaryCredit, int primaryBalance, int primaryLimit) {
        super(primaryCredit, primaryBalance, primaryLimit);
    }

    public void pay(int amount, String purchaseType, boolean useBonus){
        double percentBonus = countBonus(purchaseType);
        int writeOffAmount = super.useBonus(amount, useBonus,percentBonus);
        super.payCreditCard(writeOffAmount);
    }

    private double countBonus( String purchaseType){
        return switch (purchaseType){
            case ("food"),("entertainment"),("club"),("electStore"),("transport") -> 0.02;
            case ("gameStore") -> 0.05;
            default -> 0.01;
        };
    }

    @Override
    public void infoBalance() {
        super.infoBalance();
        System.out.println("Ваши накопленные бонусы: "+ super.getBonus());
    }
}
