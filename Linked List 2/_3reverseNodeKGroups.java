class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
};

public class _3reverseNodeKGroups {

    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {

        if (head == null || head.next == null)
            return head;

        Node prev = null, curr = head;

        int i = 0;
        while (i < n && curr != null) {
            if (b[i] == 0) {
                i++;
                continue;
            }
            Node first = prev, second = curr, next = curr.next;

            for (int j = 0; j < b[i] && curr != null; j++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null)
                    next = next.next;
            }

            if (first != null)
                first.next = prev;
            else
                head = prev;

            second.next = curr;
            prev = second;
            i++;
        }
        return head;
    }
}
