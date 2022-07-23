
class BinaryTreeNode<Integer> {
    int data;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class _5bstOrNot {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;

        if (root.left != null && root.left.data > root.data)
            return false;
        if (root.right != null && root.right.data < root.data)
            return false;

        return validateBST(root.right) && validateBST(root.left);
    }
}
