import starterPackage.DebitCard;

public class YoungsCard extends DebitCard {
    public YoungsCard(int primaryBalance) {
        super(primaryBalance);
    }

    public void payYoungs(int amount, boolean useBonus){
        int writeOFF =super.useBonus(amount, useBonus, 0.01);
        super.pay(writeOFF);
        infoBalance();
    }

    @Override
    public synchronized void topUp(int amount){
        super.topUp(amount);
        infoBalance();
    }

    @Override
    public void infoBalance(){
        super.infoBalance();
        System.out.println("Бонусные баллы: "+super.getBonus());
    }
}
