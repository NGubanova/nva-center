package starterPackage;
public class DebitCard extends BankCard {
    public DebitCard(int primaryBalance) {
        super(primaryBalance);
    }
    @Override
    public void topUp(int amount){
        super.topUp(amount);
    }
    @Override
    public void infoBalance(){
        super.infoBalance();
    }
}
