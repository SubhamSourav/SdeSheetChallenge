class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class _5Cycle2LL {
    public static Node firstNode(Node head) {
        Node f = head, s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;

            if (s == f) {
                f = head;
                while (true) {
                    if (f == s)
                        return s;
                    s = s.next;
                    f = f.next;
                }
            }
        }

        return null;
    }
}