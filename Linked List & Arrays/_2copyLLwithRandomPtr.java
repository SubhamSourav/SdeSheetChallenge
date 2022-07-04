class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    LinkedListNode<T> random;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class _2copyLLwithRandomPtr {
    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {

        if (head == null)
            return head;

        LinkedListNode<Integer> temp = head;

        while (temp != null) {
            LinkedListNode<Integer> clone = new LinkedListNode<>(temp.data);
            clone.next = temp.next;
            temp.next = clone;
            temp = temp.next.next;
        }

        temp = head;

        while (temp != null) {
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }

        LinkedListNode<Integer> dummyHead = new LinkedListNode<>(-1);
        LinkedListNode<Integer> tempc = dummyHead;
        temp = head;
        LinkedListNode<Integer> next = temp.next.next;

        while (temp != null) {
            tempc.next = temp.next;
            tempc = tempc.next;
            temp.next = next;
            temp = next;
            if (temp != null)
                next = next.next.next;
        }

        return dummyHead.next;

    }
}
