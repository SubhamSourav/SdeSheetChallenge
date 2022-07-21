class BinaryTreeNode<Integer> {
    int data;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class _7childSumProp {
    public static void changeTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        int sum = 0;
        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;

        if (sum >= root.data)
            root.data = sum;
        else {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        sum = 0;
        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;
        if (root.right != null || root.left != null)
            root.data = sum;

    }
}