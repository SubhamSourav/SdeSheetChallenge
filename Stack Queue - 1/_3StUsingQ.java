import java.util.*;
import java.util.Queue;

public class _3StUsingQ {

    Queue<Integer> q;

    public _3StUsingQ() {
        q = new LinkedList<>();
    }
    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty() ? true : false;
    }

    public void push(int element) {
        q.add(element);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (isEmpty())
            return -1;
        return q.remove();
    }

    public int top() {
        if (isEmpty())
            return -1;
        return q.peek();
    }
}
