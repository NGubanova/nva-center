import starterPackage.CreditCard;

public class AirlinesCard extends CreditCard {
    private int cashback;
    private int receivedCashback;
    public AirlinesCard(int primaryCredit, int primaryBalance, int primaryLimit) {
        super(primaryCredit, primaryBalance, primaryLimit);
    }
    public void pay(int amount, String purchaseType){
        super.payCreditCard(amount) ;
        countCashback(amount, purchaseType);
        topUpCashback(this.receivedCashback);
    }
    private void countCashback(int amount, String purchaseType){
        this.receivedCashback = switch (purchaseType) {
            case ("hotel") -> (int) Math.round(amount * 0.1);
            case ("airTicket") -> (int) Math.round(amount * 0.07);
            case ("booking") -> (int) Math.round(amount * 0.05);
            default -> (int) Math.round(amount * 0.02);
        };
    }
    private synchronized void topUpCashback(int amount){
        this.cashback +=amount;
    }
    @Override
    public void infoBalance() {
        super.infoBalance();
        System.out.println("Накопленный cashback: "+this.cashback);
    }
}
