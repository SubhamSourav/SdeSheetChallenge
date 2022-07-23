
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

public class _1floor {

    public static int floorInBST(TreeNode<Integer> root, int x) {
        int floor = Integer.MAX_VALUE;

        while (root != null) {
            if (root.data == x)
                return x;
            else if (root.data < x) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}