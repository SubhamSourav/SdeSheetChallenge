class Node {
    int data;
    Node next;
    Node child;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}

public class _6flatteningLL {

    static Node merge(Node l1, Node l2) {
        Node temp = new Node(0);
        Node head = temp;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                temp.child = l1;
                temp = temp.child;
                l1 = l1.child;
            } else {
                temp.child = l2;
                temp = temp.child;
                l2 = l2.child;
            }
        }

        if (l1 != null)
            temp.child = l1;
        else
            temp.child = l2;

        return head.child;
    }

    public static Node flattenLinkedList(Node start) {
        if (start == null || start.next == null) {
            return start;
        }

        start.next = flattenLinkedList(start.next);
        start = merge(start, start.next);

        return start;
    }
}
