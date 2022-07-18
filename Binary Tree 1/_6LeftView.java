import java.util.ArrayList;

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

public class _6LeftView {
    static void leftView(TreeNode<Integer> root, int level, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (level == ans.size())
            ans.add(root.data);
        leftView(root.left, level + 1, ans);
        leftView(root.right, level + 1, ans);
    }

    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        leftView(root, 0, ans);
        return ans;
    }
}
