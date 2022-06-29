public class _3majorityElement1 {
    public static int findMajority(int[] arr, int n) {
        int ele = 0;
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (c == 0) {
                ele = arr[i];
            }
            if (ele == arr[i])
                c++;
            else
                c--;
        }

        c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele)
                c++;
        }

        if (c > n / 2)
            return ele;
        return -1;
    }
}