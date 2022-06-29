import java.util.ArrayList;

public class _5missingAndRepeatingNo {
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int xor = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            xor = xor ^ arr.get(i);
        }

        for (int i = 1; i <= n; i++) {
            xor = xor ^ i;
        }

        int x = 0, y = 0, setbit = xor & ~(xor - 1);

        for (int i = 0; i < arr.size(); i++) {
            if ((arr.get(i) & setbit) == setbit) {
                x = x ^ arr.get(i);
            } else
                y = y ^ arr.get(i);
        }

        for (int i = 1; i <= n; i++) {
            if ((i & setbit) == setbit)
                x = x ^ i;
            else
                y = y ^ i;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == x)
                return new int[] { y, x };
            if (arr.get(i) == y)
                return new int[] { x, y };
        }

        return new int[] { -1, -1 };
    }
}