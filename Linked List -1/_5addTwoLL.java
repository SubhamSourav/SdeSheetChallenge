class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}

public class _5addTwoLL {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode dh = new LinkedListNode(-1);
        LinkedListNode temp = dh;
        int c = 0;

        while (head1 != null || head2 != null || c == 1) {

            int sum = 0;

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            sum += c;

            temp.next = new LinkedListNode(sum % 10);
            temp = temp.next;
            c = sum / 10;
        }

        return dh.next;
    }
}
