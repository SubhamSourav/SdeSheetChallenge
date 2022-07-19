public class _4rotatedArr {

    static int pivot(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (m < h && arr[m] > arr[m + 1]) {
                return m;
            } else if (m > l && arr[m] < arr[m - 1]) {
                return m - 1;
            }
            if (arr[l] < arr[m]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    static int BS(int[] arr, int target, int l, int h) {
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] == target)
                return m;
            else if (arr[m] < target)
                l = m + 1;
            else
                h = m - 1;
        }
        return -1;
    }

    public static int search(int nums[], int target) {
        int p = pivot(nums);
        if (p == -1) {
            return BS(nums, target, 0, nums.length - 1);
        }
        if (p != -1 && nums[p] == target) {
            return p;
        }

        if (target >= nums[0]) {
            return BS(nums, target, 0, p - 1);
        } else {
            return BS(nums, target, p + 1, nums.length - 1);
        }
    }
}