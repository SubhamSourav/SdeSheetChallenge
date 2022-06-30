import java.util.HashSet;
import java.util.Set;

public class _3longConSeq {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        int c = 0, max = 0;
        Set<Integer> set = new HashSet<>();

        for (int ele : arr) {
            set.add(ele);
        }

        for (int ele : arr) {
            if (!set.contains(ele - 1)) {
                c = 1;
                while (set.contains(ele + 1)) {
                    c++;
                    ele = ele + 1;
                }
                max = Math.max(c, max);
            }
        }
        return max;
    }
}
