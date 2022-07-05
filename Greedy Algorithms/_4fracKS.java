import java.util.Arrays;

class Pair {
    int weight;
    int value;

    Pair(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

}

public class _4fracKS {
    public static double maximumValue(Pair[] items, int n, int w) {

        Arrays.sort(items, (a, b) -> {
            double ra = (double) a.value / (double) a.weight;
            double rb = (double) b.value / (double) b.weight;
            if (ra > rb)
                return -1;
            else if (ra < rb)
                return 1;
            else
                return 0;
        });

        double ks = 0;
        int i = 0;
        while (w != 0) {
            if (items[i].weight < w) {
                ks += items[i].value;
                w -= items[i].weight;
            } else {
                ks += ((double) items[i].value / (double) items[i].weight) * w;
                w = 0;
            }
            i++;
            if (i == n)
                break;
        }

        return ks;

    }
}
