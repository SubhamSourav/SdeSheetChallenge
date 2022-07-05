import java.util.Arrays;

public class _3jobSequencing {

    public static int jobScheduling(int[][] jobs) {

        Arrays.sort(jobs, (a, b) -> {
            return b[1] - a[1];
        });

        for (int[] is : jobs) {
            System.out.println(Arrays.toString(is));
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] jobs = { { 2, 25 }, { 4, 40 }, { 1, 5 }, { 3, 50 }, { 5, 60 } };

        System.out.println(jobScheduling(jobs));
    }
}
