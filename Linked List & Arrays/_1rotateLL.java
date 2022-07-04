class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

public class _1rotateLL {
    static int length(Node head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }

    public static Node rotate(Node head, int k) {
        if (k == 0 || head.next == null)
            return head;

        int c = length(head);
        if (c == k)
            return head;

        Node f = head, s = head;

        for (int i = 0; i < k % c; i++) {
            f = f.next;
        }

        while (f.next != null) {
            f = f.next;
            s = s.next;
        }

        f.next = head;
        head = s.next;
        s.next = null;

        return head;
    }
}