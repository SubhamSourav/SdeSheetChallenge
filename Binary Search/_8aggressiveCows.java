import java.util.*;

public class _8aggressiveCows {

    static boolean isCompatible(int[] pos, int c, int dist, int n) {
        int lastCow = pos[0];
        c--;
        for (int i = 1; i < n; i++) {
            if (pos[i] - lastCow >= dist) {
                c--;
                if (c == 0)
                    return true;
                lastCow = pos[i];
            }
        }
        return false;
    }

    public static int chessTournament(int[] pos, int n, int c) {
        Arrays.sort(pos);
        int low = 0, high = pos[n - 1] - pos[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCompatible(pos, c, mid, n)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}