import java.util.*;

class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> next;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
        next = null;
    }
};

public class _1connNodeSameLevel {
    public static void connectNodes(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                BinaryTreeNode node = q.remove();
                node.next = i == n ? null : q.peek();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
    }
}