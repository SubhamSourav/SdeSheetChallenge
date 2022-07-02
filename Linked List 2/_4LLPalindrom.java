
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class _4LLPalindrom {
    static LinkedListNode<Integer> reverse(LinkedListNode<Integer> s) {
        LinkedListNode<Integer> prev = null, node = s, next = node.next;

        while (node != null) {
            node.next = prev;
            prev = node;
            node = next;
            if (next != null)
                next = next.next;
        }

        return prev;
    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return true;

        LinkedListNode<Integer> f = head, s = head;

        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }

        s = reverse(s.next);
        f = head;

        while (s != null) {
            if (!s.data.equals(f.data))
                return false;
            s = s.next;
            f = f.next;
        }

        return true;
    }
}
