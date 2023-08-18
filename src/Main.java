import starterPackage.CreditCard;
import starterPackage.DebitCard;

public class Main {
    public static void main(String[] args) {
        CreditCard card6866 =
                new CreditCard(10000, 0, 10000);

        card6866.topUpFunds(5000);
        card6866.payProduct(5000);
        card6866.payProduct(3000);
        card6866.topUpFunds(2000);
        card6866.topUpFunds(2000);
        System.out.println();

        DebitCard card1299 =
                new DebitCard(7000);
        card1299.topUp(790);
        card1299.infoBalance();
        System.out.println();

        YoungsCard card9999 =
                new YoungsCard(999);
        card9999.payYoungs(500, true);
        card9999.topUp(1000);
        System.out.println();

        AirlinesPremium card6666 =
                new AirlinesPremium(90840, 0, 200000, 178);
        card6666.payAir(37000, "hotel");
        card6666.topUpFunds(180000);
        System.out.println();

        GamesCard card7777 = new GamesCard(260000, 0, 300000);
        card7777.payGames(9000, "gameStore", false);
        card7777.topUpFunds(55000);
        card7777.payGames(4000, "beauty", false);
    }
}