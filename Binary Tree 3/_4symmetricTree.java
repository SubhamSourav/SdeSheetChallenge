
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class _4symmetricTree {

    static boolean check(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;

        if (!left.data.equals(right.data))
            return false;

        return check(left.left, right.right) && check(left.right, right.left);
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return root == null || check(root.left, root.right);
    }
}