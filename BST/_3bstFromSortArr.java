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

public class _3bstFromSortArr {

    static TreeNode<Integer> makeTree(ArrayList<Integer> arr, int low, int high) {
        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode<Integer> root = new TreeNode(arr.get(mid));
        root.left = makeTree(arr, low, mid - 1);
        root.right = makeTree(arr, mid + 1, high);
        return root;
    }

    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        return makeTree(arr, 0, n - 1);
    }
}