import java.util.ArrayList;

public class _5removeDuplicatesFromSortedArray {
    public static int removeDuplicates(ArrayList<Integer> arr, int n) {

        int i = 0, j = 1;

        while (j < n) {
            if (arr.get(i) == arr.get(j))
                j++;
            else {
                i++;
                arr.set(i, arr.get(j));
            }
        }

        return i + 1;
    }
}
