import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.data = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

public class _1inorder {
    public static List<Integer> iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        while (true) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                if (s.isEmpty())
                    break;
                root = s.pop();
                ans.add(root.data);
                root = root.right;
            }
        }
        return ans;
    }

    static void recursive(TreeNode curr, ArrayList<Integer> ans) {
        if (curr == null)
            return;

        recursive(curr.left, ans);
        ans.add(curr.data);
        recursive(curr.right, ans);
    }
}