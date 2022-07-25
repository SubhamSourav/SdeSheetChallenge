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

public class _7predSucc {
    private static int pre;
    private static int succ;

    static void find(BinaryTreeNode<Integer> root, int key) {
        if (root == null)
            return;
        find(root.left, key);
        if (root.data < key)
            pre = Math.max(pre, root.data);
        if (root.data > key)
            succ = Math.min(succ, root.data);
        find(root.right, key);
    }

    public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
        ArrayList<Integer> ans = new ArrayList<>();
        pre = Integer.MIN_VALUE;
        succ = Integer.MAX_VALUE;
        find(root, key);
        ans.add(pre == Integer.MIN_VALUE ? -1 : pre);
        ans.add(succ == Integer.MAX_VALUE ? -1 : succ);
        return ans;
    }
}