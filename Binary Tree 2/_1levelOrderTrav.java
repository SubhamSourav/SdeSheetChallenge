import java.util.*;

class BinaryTreeNode<T> {
    T val;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class _1levelOrderTrav {

    public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.remove();
            if (root.left != null)
                q.add(root.left);
            if (root.right != null)
                q.add(root.right);
            ans.add((Integer) root.val);
        }

        return ans;
    }

}