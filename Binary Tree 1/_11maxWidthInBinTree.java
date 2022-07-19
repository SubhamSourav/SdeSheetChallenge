import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class _11maxWidthInBinTree {

    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            ans = Math.max(ans, size);
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return ans;

    }
}
