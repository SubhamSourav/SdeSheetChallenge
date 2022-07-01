class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class _4removeNthNodefrmBack {
    public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {

        if (head == null || K == 0)
            return head;
        LinkedListNode<Integer> f = head, s = head;

        for (int i = 0; i < K; i++) {
            f = f.next;
        }

        if (f == null)
            return head.next;

        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return head;

    }
}
