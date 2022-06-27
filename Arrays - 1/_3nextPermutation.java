import java.util.ArrayList;

public class _3nextPermutation {

    static void reverse(ArrayList<Integer> permutation, int i, int j) {
        while (i < j)
            swap(permutation, i++, j--);
    }

    static void swap(ArrayList<Integer> permutation, int i, int j) {
        int temp = permutation.get(i);
        permutation.set(i, permutation.get(j));
        permutation.set(j, temp);
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {

        int n = permutation.size();
        if (n == 1)
            return permutation;

        int i = n - 2;
        while (i >= 0 && permutation.get(i) >= permutation.get(i + 1))
            i--;

        if (i >= 0) {
            int j = n - 1;
            while (permutation.get(j) <= permutation.get(i))
                j--;
            swap(permutation, i, j);
        }
        reverse(permutation, i + 1, n - 1);
        return permutation;
    }

    public static void main(String[] args) {

    }
}
