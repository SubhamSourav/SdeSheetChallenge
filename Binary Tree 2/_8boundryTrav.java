import java.util.ArrayList;

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

public class _8boundryTrav {

    static void leftBoundry(TreeNode root, ArrayList<Integer> ans) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr))
                ans.add(curr.data);
            curr = curr.left != null ? curr.left : curr.right;
        }
    }

    static void addLeaves(TreeNode root, ArrayList<Integer> ans) {

        if (root == null)
            return;
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }

    static void rightBoundry(TreeNode root, ArrayList<Integer> ans, int size) {
        TreeNode curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr))
                ans.add(size, curr.data);
            curr = curr.right != null ? curr.right : curr.left;
        }
    }

    static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        ans.add(root.data);
        if (isLeaf(root))
            return ans;
        leftBoundry(root, ans);
        addLeaves(root, ans);
        rightBoundry(root, ans, ans.size());
        return ans;
    }
}