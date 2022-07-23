
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

public class _3KthSmall {
    static TreeNode<Integer> find(TreeNode<Integer> root, int[] cnt) {
        if (root == null)
            return null;

        TreeNode left = find(root.left, cnt);
        if (left != null)
            return left;

        cnt[0]--;
        if (cnt[0] == 0)
            return root;

        return find(root.right, cnt);
    }

    public static int kthSmallest(TreeNode<Integer> root, int k) {
        int[] cnt = { k };
        return find(root, cnt).data;
    }

}
