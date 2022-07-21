import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class _7zigzagTraversal {
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        Boolean flag = true;
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                BinaryTreeNode<Integer> node = q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                if (flag) {
                    temp.add(node.data);
                } else
                    temp.add(0, node.data);
            }
            flag = !flag;
            for (int ele : temp)
                ans.add(ele);
        }

        return ans;

    }
}
