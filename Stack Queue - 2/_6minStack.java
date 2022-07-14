import java.util.*;

public class _6minStack {

    static class MinStack {

        Stack<Long> st;
        Long mini;

        MinStack() {
            st = new Stack<>();
            mini = Long.MAX_VALUE;
        }

        void push(int num) {
            Long val = Long.valueOf(num);
            if (st.isEmpty()) {
                mini = val;
                st.push(val);
            } else {
                if (val < mini) {
                    st.push(2 * val - mini);
                    mini = val;
                } else {
                    st.push(val);
                }
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if (st.isEmpty())
                return -1;
            else {
                Long val = st.pop();
                if (val < mini) {
                    Long Temp = mini;
                    mini = 2 * mini - val;
                    return Temp.intValue();
                } else
                    return val.intValue();
            }
        }

        int top() {
            if (st.isEmpty())
                return -1;
            Long val = st.peek();
            if (val < mini)
                return mini.intValue();
            else
                return val.intValue();
        }

        int getMin() {
            if (st.isEmpty())
                return -1;
            return mini.intValue();
        }
    }
}