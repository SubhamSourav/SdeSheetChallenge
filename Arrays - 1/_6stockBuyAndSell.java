import java.util.ArrayList;

public class _6stockBuyAndSell {

    public static int maximumProfit(ArrayList<Integer> prices) {
        int min = prices.get(0), prof = 0;

        for (int i = 1; i < prices.size(); i++) {
            min = Math.min(min, prices.get(i));
            prof = Math.max(prof, prices.get(i) - min);
        }

        return prof;
    }
}