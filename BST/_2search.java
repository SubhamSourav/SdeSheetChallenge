class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class _2search {
    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
        while (root != null) {
            if (root.data == x)
                return true;
            root = x < root.data ? root.left : root.right;
        }
        return false;
    }
}