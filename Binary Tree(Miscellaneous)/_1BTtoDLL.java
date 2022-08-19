class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class _1BTtoDLL {

    static BinaryTreeNode<Integer> curr = null;

    static void convert(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        convert(root.left);
        root.left = curr;
        curr.right = root;
        curr = root;
        convert(root.right);
    }

    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(-1);
        curr = a;
        convert(root);
        return a.right;
    }

}
