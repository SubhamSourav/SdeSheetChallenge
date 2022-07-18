import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.data = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

public class _2preorder {
    public static List<Integer> getPreOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> q = new Stack<>();
        q.push(root);
        while (!q.isEmpty()) {
            root = q.pop();
            if (root.right != null)
                q.add(root.right);
            if (root.left != null)
                q.add(root.left);
            ans.add(root.data);
        }

        return ans;
    }

    static void recursive(TreeNode curr, ArrayList<Integer> ans) {
        if (curr == null)
            return;

        ans.add(curr.data);
        recursive(curr.left, ans);
        recursive(curr.right, ans);
    }
}
