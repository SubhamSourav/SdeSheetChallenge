
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class _1reverseLL {

    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;

        LinkedListNode<Integer> prev = null, curr = head, next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }

        return prev;

    }
}