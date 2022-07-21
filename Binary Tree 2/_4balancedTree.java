
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

public class _4balancedTree {

    static int check(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        int lh = check(root.left);
        if (lh == -1)
            return -1;
        int rh = check(root.right);
        if (rh == -1)
            return -1;

        int diff = Math.abs(lh - rh);
        if (diff > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }

    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;
        return check(root) != -1;
    }
}
