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

public class _3postOrder {
    public static List<Integer> getPostOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> s = new Stack<>();

        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                TreeNode temp = s.peek().right;
                if (temp == null) {
                    temp = s.pop();
                    ans.add(temp.data);
                    while (!s.isEmpty() && temp == s.peek().right) {
                        temp = s.pop();
                        ans.add(temp.data);
                    }
                } else
                    root = temp;
            }
        }

        return ans;
    }

    static void recursive(TreeNode curr, ArrayList<Integer> ans) {
        if (curr == null)
            return;

        recursive(curr.left, ans);
        recursive(curr.right, ans);
        ans.add(curr.data);
    }
}
