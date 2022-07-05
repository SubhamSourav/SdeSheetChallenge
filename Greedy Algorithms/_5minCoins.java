public class _5minCoins {
    public static int findMinimumCoins(int amount) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int c = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (coins[i] <= amount) {
                amount -= coins[i];
                c++;
            }
        }

        return c++;

    }
}
