
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

public class _5lca {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        if (root == null)
            return -1;
        if (root.data == x)
            return x;
        if (root.data == y)
            return y;

        int left = lowestCommonAncestor(root.left, x, y);
        int right = lowestCommonAncestor(root.right, x, y);

        if (left == -1)
            return right;
        else if (right == -1)
            return left;
        else
            return root.data;
    }
}
