import java.util.Stack;

public class _4QusingSt {

    Stack<Integer> ipStack, opStack;

    _4QusingSt() {
        ipStack = new Stack<>();
        opStack = new Stack<>();
    }

    void enQueue(int val) {
        ipStack.add(val);
    }

    int deQueue() {
        if (isEmpty())
            return -1;
        if (!opStack.isEmpty()) {
            return opStack.pop();
        } else {
            while (!ipStack.isEmpty()) {
                opStack.add(ipStack.pop());
            }
            return opStack.pop();
        }
    }

    int peek() {
        if (isEmpty())
            return -1;
        if (!opStack.isEmpty()) {
            return opStack.peek();
        } else {
            while (!ipStack.isEmpty()) {
                opStack.add(ipStack.pop());
            }
            return opStack.peek();
        }
    }

    boolean isEmpty() {
        return ipStack.isEmpty() && opStack.isEmpty() ? true : false;
    }
}
