
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

class NodeValue {
    int maxV, minV, size;

    NodeValue(int a, int b, int c) {
        maxV = a;
        minV = b;
        size = c;
    }
}

public class _7larBst {

    static NodeValue helper(TreeNode<Integer> root) {
        if (root == null)
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if (left.maxV < root.data && root.data < right.minV) {
            return new NodeValue(Math.max(root.data, right.maxV), Math.min(root.data, left.minV),
                    left.size + right.size + 1);
        }

        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.size, right.size));
    }

    public static int largestBST(TreeNode<Integer> root) {
        return helper(root).size;
    }
}
