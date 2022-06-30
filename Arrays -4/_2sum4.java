import java.util.Arrays;

public class _2sum4 {

    public static String fourSum(int[] arr, int target, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int diff = target - arr[i] - arr[j];
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    if (arr[k] + arr[l] > diff) {
                        while (k < l && arr[l] == arr[l - 1])
                            l--;
                        l--;
                    } else if (arr[k] + arr[l] < diff) {
                        while (k < l && arr[k] == arr[k + 1])
                            k++;
                        k++;
                    } else
                        return "Yes";
                }
                while (j < n - 2 && arr[j] == arr[j + 1])
                    j++;
            }
            while (i < n - 3 && arr[i] == arr[i + 1])
                i++;
        }
        return "No";
    }

}