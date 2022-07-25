
class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = right = null;
    }

}

public class _4bstFromPre {

    static TreeNode<Integer> traverse(int[] preOrder, int ub, int[] ptr) {
        if (ptr[0] == preOrder.length || preOrder[ptr[0]] > ub)
            return null;
        TreeNode<Integer> root = new TreeNode(preOrder[ptr[0]]);
        ptr[0]++;
        root.left = traverse(preOrder, root.data, ptr);
        root.right = traverse(preOrder, ub, ptr);
        return root;
    }

    public static TreeNode<Integer> preOrderTree(int[] preOrder) {
        return traverse(preOrder, Integer.MAX_VALUE, new int[] { 0 });
    }

}
