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

public class _6LCA {
    static TreeNode<Integer> LCA(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root.data > q.data) {
            return LCA(root.left, p, q);
        } else if (root.data < p.data) {
            return LCA(root.right, p, q);
        } else {
            return root;
        }
    }

    public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p.data < q.data) {
            return LCA(root, p, q);
        } else {
            return LCA(root, q, p);
        }
    }
}