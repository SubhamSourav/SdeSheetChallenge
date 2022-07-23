import java.util.ArrayList;

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

public class _4thKthlar {

    static TreeNode<Integer> find(TreeNode root, int[] cnt) {
        if (root == null)
            return null;

        TreeNode right = find(root.right, cnt);
        if (right != null)
            return right;

        cnt[0]--;
        if (cnt[0] == 0)
            return root;

        return find(root.left, cnt);
    }

    public static int KthLargestNumber(TreeNode<Integer> root, int k) {
        int[] cnt = { k };
        TreeNode<Integer> ans = find(root, cnt);
        return ans != null ? ans.data : -1;
    }
}