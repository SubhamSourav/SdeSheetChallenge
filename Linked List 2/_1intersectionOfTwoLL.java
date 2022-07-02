public class _1intersectionOfTwoLL {
    class LinkedListNode<T> {
        public T data;
        public LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
        LinkedListNode<Integer> p1 = firstHead, p2 = secondHead;

        while (p1 != p2) {
            p1 = p1 != null ? p1.next : secondHead;
            p2 = p2 != null ? p2.next : firstHead;
        }

        return p1 == null ? -1 : p1.data;
    }

}