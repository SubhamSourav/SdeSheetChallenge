import java.util.*;

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

public class _2BTFromInandPre {

    static TreeNode<Integer> buildTree(ArrayList inorder, int ins, int ine, ArrayList preorder, int pres, int pree,
            Map<Integer, Integer> idxmap) {
        if (ins > ine || pres > pree)
            return null;

        TreeNode root = new TreeNode(preorder.get(pres));
        int idx = idxmap.get(preorder.get(pres));
        int inLeft = idx - ins;

        root.left = buildTree(inorder, ins, idx - 1, preorder, pres + 1, pres + inLeft, idxmap);
        root.right = buildTree(inorder, idx + 1, ine, preorder, pres + inLeft + 1, pree, idxmap);
        return root;
    }

    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        Map<Integer, Integer> idxmap = new HashMap<>();
        int n = inorder.size();
        for (int i = 0; i < n; i++) {
            idxmap.put(inorder.get(i), i);
        }
        return buildTree(inorder, 0, n - 1, preorder, 0, n - 1, idxmap);
    }
}