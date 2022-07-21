
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class _1maxPathSum {

    static Long find(TreeNode root, Long[] maxi) {
        if (root == null)
            return 0l;

        Long maxl = find(root.left, maxi);
        Long maxr = find(root.right, maxi);
        maxi[0] = Math.max(maxi[0], root.data + maxl + maxr);
        return root.data + Math.max(maxl, maxr);
    }

    public static long findMaxSumPath(TreeNode root) {
        if (root == null || root.left == null || root.right == null)
            return -1;
        Long[] maxi = new Long[1];
        maxi[0] = -1l;
        find(root, maxi);
        return maxi[0];
    }
}