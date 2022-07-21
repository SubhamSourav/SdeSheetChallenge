
class TreeNode<T> {
    public T data;
    public TreeNode<Integer> left;
    public TreeNode<Integer> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class _3diamOfBT {
    static int maxi;

    static int find(TreeNode<Integer> root, int[] ans) {
        if (root == null)
            return 0;

        int lh = find(root.left, ans);
        int rh = find(root.right, ans);

        ans[0] = Math.max(ans[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int[] ans = new int[1];
        find(root, ans);
        return ans[0];
    }
}