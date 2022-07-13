import java.util.*;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(-1);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() >= arr.get(i)) {
                s.pop();
            }

            if (!s.isEmpty())
                ans.set(i, s.peek());

            s.push(arr.get(i));
        }
        return ans;
    }
}