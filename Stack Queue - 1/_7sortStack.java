import java.util.Stack;

public class _7sortStack {

    static void insert_correct_position(Stack<Integer> stack, int x) {
        if (stack.size() == 0 || stack.peek() <= x) {
            stack.push(x);
        } else {
            int a = stack.pop();
            insert_correct_position(stack, x);
            stack.push(a);
        }
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.size() > 0) {
            int x = stack.pop();
            sortStack(stack);
            insert_correct_position(stack, x);
        }
    }

}