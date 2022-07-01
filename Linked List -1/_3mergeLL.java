class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class _3mergeLL {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {

        LinkedListNode<Integer> dummyhead = new LinkedListNode(-1);
        LinkedListNode temp = dummyhead;

        while (first != null && second != null) {
            if (first.data < second.data) {
                temp.next = first;
                temp = temp.next;
                first = first.next;
            } else {
                temp.next = second;
                temp = temp.next;
                second = second.next;
            }
        }

        if (first != null)
            temp.next = first;
        if (second != null)
            temp.next = second;

        return dummyhead.next;

    }
}
