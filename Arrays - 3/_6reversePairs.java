import java.util.ArrayList;
import java.util.Arrays;

public class _6reversePairs {

    static int merge(ArrayList<Integer> arr, int low, int mid, int high) {
        int inv = 0, j = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (j <= high && arr.get(i) > (2 * arr.get(j)))
                j++;
            inv += j - (mid + 1);
        }

        ArrayList<Integer> temp = new ArrayList<>();

        int i = low;
        j = mid + 1;

        while (i <= mid && j <= high) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i++));
            } else {
                temp.add(arr.get(j++));
            }
        }

        while (i <= mid)
            temp.add(arr.get(i++));
        while (j <= high)
            temp.add(arr.get(j++));

        for (int k = low; k <= high; k++) {
            arr.set(k, temp.get(k - low));
        }

        return inv;
    }

    static int mergeSort(ArrayList<Integer> arr, int low, int high) {
        int inv = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            inv += mergeSort(arr, low, mid);
            inv += mergeSort(arr, mid + 1, high);
            inv += merge(arr, low, mid, high);
        }
        return inv;
    }

    public static int reversePairs(ArrayList<Integer> arr) {
        return mergeSort(arr, 0, arr.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(6, 4, 8, 2, 1, 3));
        System.out.println("The Total Reverse Pairs are " + reversePairs(arr));
        System.out.println(arr);
    }
}