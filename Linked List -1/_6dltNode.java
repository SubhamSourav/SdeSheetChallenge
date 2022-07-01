class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class _6dltNode {
    public static void deleteNode(LinkedListNode<Integer> node) {

        if (node.next == null)
            node = null;

        node.data = node.next.data;
        node.next = node.next.next;

    }
}
