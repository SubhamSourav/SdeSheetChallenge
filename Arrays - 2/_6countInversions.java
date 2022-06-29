public class _6countInversions {
    static long merge(long[] arr, long[] temp, int low, int mid, int high) {
        int i = low, k = low;
        int j = mid + 1;
        int inv = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv += mid + 1 - i;
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= high)
            temp[k++] = arr[j++];

        for (int m = low; m <= high; m++) {
            arr[m] = temp[m];
        }
        return inv;
    }

    static long mergeSort(long[] arr, long[] temp, int low, int high) {
        long inv = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            inv += mergeSort(arr, temp, low, mid);
            inv += mergeSort(arr, temp, mid + 1, high);
            inv += merge(arr, temp, low, mid, high);
        }
        return inv;
    }

    public static long getInversions(long arr[], int n) {

        return mergeSort(arr, new long[n], 0, n - 1);
    }
}
