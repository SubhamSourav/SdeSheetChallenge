
import java.util.*;

public class Solution {
    public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.size(); i++) {
            if (!q.isEmpty() && q.peek() == i - k)
                q.poll();

            while (!q.isEmpty() && nums.get(q.peekLast()) <= nums.get(i))
                q.pollLast();

            q.add(i);

            if (i >= k - 1) {
                ans.add(nums.get(q.peek()));
            }
        }

        return ans;
    }
}