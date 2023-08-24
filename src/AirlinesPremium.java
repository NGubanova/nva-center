import starterPackage.CreditCard;

public class AirlinesPremium extends CreditCard {
    private int cashback;
    public AirlinesPremium(int primaryCredit, int primaryBalance, int primaryLimit, int primaryCashback) {
        super(primaryCredit, primaryBalance, primaryLimit);
        this.cashback = primaryCashback;
    }

    private synchronized void addCashback(int amount){
        this.cashback +=amount;
    }

    public void payAir(int amount, String purchaseType){
        this.cashback = switch (purchaseType) {
            case ("hotel") -> (int) Math.round(amount * 0.1);
            case ("airTicket") -> (int) Math.round(amount * 0.07);
            case ("booking") -> (int) Math.round(amount * 0.05);
            default -> (int) Math.round(amount * 0.02);
        };
        if (super.payProduct(amount)) addCashback(this.cashback);
        infoBalance();
    }

    @Override
    public void infoBalance() {
        super.infoBalance();
        System.out.println("Накопленный cashback: "+this.cashback);
    }
}
