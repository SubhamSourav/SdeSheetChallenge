
public class Stack {

    int top, size;
    int[] arr;

    Stack(int capacity) {
        top = -1;
        size = capacity;
        arr = new int[size];
    }

    void push(int num) {
        if (isFull() == 1)
            return;
        arr[++top] = num;
    }

    int pop() {
        if (isEmpty() == 1)
            return -1;
        return arr[top--];
    }

    int top() {
        if (isEmpty() == 1)
            return -1;
        return arr[top];
    }

    int isEmpty() {
        return top == -1 ? 1 : 0;
    }

    int isFull() {
        return top >= size ? 1 : 0;
    }
}
