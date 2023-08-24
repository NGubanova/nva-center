import starterPackage.CreditCard;
import starterPackage.DebitCard;

public class Main {
    public static void main(String[] args) {
        CreditCard card6866 =
                new CreditCard(10000, 0, 10000);

        card6866.topUpFunds(5000);
        card6866.infoBalance();
        card6866.payProduct(5000);
        card6866.infoBalance();
        card6866.payProduct(3000);
        card6866.infoBalance();
        card6866.topUpFunds(2000);
        card6866.infoBalance();
        card6866.topUpFunds(2000);
        card6866.infoBalance();
        System.out.println();

        DebitCard card1299 =
                new DebitCard(7000);
        card1299.topUp(790);
        card1299.infoBalance();
        System.out.println();

        YoungsCard card9999 =
                new YoungsCard(999);
        card9999.pay(500, true);
        card9999.infoBalance();
        card9999.topUp(1000);
        card9999.infoBalance();
        System.out.println();

        AirlinesCard card6666 =
                new AirlinesCard(100000, 0, 200000);
        card6666.pay(37000, "hotel");
        card6666.infoBalance();
        card6666.topUpFunds(200000);
        card6666.infoBalance();
        System.out.println();

        GamesCard card7777 = new GamesCard(260000, 0, 300000);
        card7777.pay(9000, "gameStore", false);
        card7777.infoBalance();
        card7777.topUpFunds(55000);
        card7777.infoBalance();
        card7777.pay(4000, "beauty", false);
        card7777.infoBalance();
    }
}