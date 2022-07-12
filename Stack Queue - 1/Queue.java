public class Queue {

    int front, rear, size;
    int[] arr;

    Queue() {
        front = 0;
        rear = -1;
        size = 5001;
        arr = new int[size];
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return rear < front ? true : false;
    }

    boolean isFull() {
        return rear - front + 1 == size ? true : false;
    }

    void enqueue(int data) {
        if (isFull())
            return;
        rear++;
        arr[rear % size] = data;
    }

    int dequeue() {
        if (isEmpty())
            return -1;
        int ele = arr[front % size];
        front++;
        return ele;
    }

    int front() {
        if (isEmpty())
            return -1;
        return arr[front];
    }
}