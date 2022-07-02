public class _2detectingACycle {
    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean detectCycle(Node<Integer> head) {
        Node<Integer> f = head, s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;

            if (s == f)
                return true;
        }
        return false;
    }
}
