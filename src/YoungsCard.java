import starterPackage.DebitCard;

public class YoungsCard extends DebitCard {
    public YoungsCard(int primaryBalance) {
        super(primaryBalance);
    }

    public void pay(int amount, boolean useBonus){
        int writeOffAmount =super.useBonus(amount, useBonus, 0.01);
        super.pay(writeOffAmount);
    }

    @Override
    public synchronized void topUp(int amount){
        super.topUp(amount);
    }

    @Override
    public void infoBalance(){
        super.infoBalance();
        System.out.println("Бонусные баллы: "+super.getBonus());
    }
}
