
class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class _5flattenBT {
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }
        return root;
    }
}