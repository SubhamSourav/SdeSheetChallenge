import java.util.ArrayList;
import java.util.Stack;

public class _8stockSpan {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        s.add(0);
        ans.add(1);
        for (int i = 1; i < price.size(); i++) {
            while (!s.isEmpty() && price.get(i) >= price.get(s.peek())) {
                s.pop();
            }

            if (s.isEmpty()) {
                ans.add(i + 1);
            } else {
                ans.add(i - s.peek());
            }
            s.add(i);
        }
        return ans;
    }
}