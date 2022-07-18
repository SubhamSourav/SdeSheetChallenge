import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class pair {
    BinaryTreeNode<Integer> node;
    int flag;

    pair(BinaryTreeNode<Integer> node) {
        this.node = node;
        flag = 1;
    }
}

public class _9allInOneTraversal {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<pair> s = new Stack<>();
        if (root == null)
            return ans;
        s.push(new pair(root));
        while (!s.isEmpty()) {
            pair temp = s.pop();
            if (temp.flag == 1) {
                pre.add(temp.node.data);
                temp.flag++;
                s.push(temp);
                if (temp.node.left != null)
                    s.push(new pair(temp.node.left));
            } else if (temp.flag == 2) {
                in.add(temp.node.data);
                temp.flag++;
                s.push(temp);
                if (temp.node.right != null)
                    s.push(new pair(temp.node.right));
            } else {
                post.add(temp.node.data);
            }
        }

        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
}
