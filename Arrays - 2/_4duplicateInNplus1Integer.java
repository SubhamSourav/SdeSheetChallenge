import java.util.ArrayList;

public class _4duplicateInNplus1Integer {
    public static int findDuplicate(ArrayList<Integer> arr, int n) {

        int slow = arr.get(0);
        int fast = slow;

        do {
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        } while (fast != slow);

        fast = arr.get(0);

        while (slow != fast) {
            slow = arr.get(slow);
            fast = arr.get(fast);
        }

        return slow;

    }
}
