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

public class _8serialize_Deser {
    public static String serializeTree(TreeNode<Integer> root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null) {
                sb.append("#,");
                continue;
            }
            sb.append(node.data).append(",");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    public static TreeNode<Integer> deserializeTree(String str) {
        if (str == "")
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = str.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(values[i++]));
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }
            i++;
            if (!values[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
            i++;
        }

        return root;
    }
}
