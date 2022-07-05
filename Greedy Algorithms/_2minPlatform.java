import java.util.Arrays;

public class _2minPlatform {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);

        int max = 0, c = 0;

        int i = 0, j = 0;

        while (i < n) {
            if (at[i] <= dt[j]) {
                c++;
                i++;
            } else {
                j++;
                c--;
            }
            max = Math.max(max, c);
        }

        return max;
    }
}
