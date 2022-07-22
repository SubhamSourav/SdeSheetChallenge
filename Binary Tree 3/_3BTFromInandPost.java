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
}

public class _3BTFromInandPost {

    static TreeNode<Integer> buildTree(int[] inorder, int ins, int ine, int[] postorder, int posts, int poste,
            Map<Integer, Integer> idxmap) {
        if (ins > ine || posts > poste)
            return null;

        TreeNode<Integer> root = new TreeNode(postorder[poste]);
        int idx = idxmap.get(root.data);
        int inLeft = idx - ins;

        root.left = buildTree(inorder, ins, idx - 1, postorder, posts, posts + inLeft - 1, idxmap);
        root.right = buildTree(inorder, idx + 1, ine, postorder, posts + inLeft, poste - 1, idxmap);
        return root;
    }

    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        Map<Integer, Integer> idxmap = new HashMap<>();
        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            idxmap.put(inOrder[i], i);
        }
        return buildTree(inOrder, 0, n - 1, postOrder, 0, n - 1, idxmap);
    }
}
