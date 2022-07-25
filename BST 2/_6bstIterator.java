import java.util.*;

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

public class _6bstIterator {

    static class BSTIterator {

        Stack<TreeNode> st;

        BSTIterator(TreeNode<Integer> root) {
            st = new Stack<>();
            pushAll(root);
        }

        int next() {
            TreeNode<Integer> temp = st.pop();
            pushAll(temp.right);
            return temp.data;
        }

        boolean hasNext() {
            return !st.isEmpty();
        }

        void pushAll(TreeNode root) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
        }
    }
}

/*
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator iterator = new BSTIterator(root);
 * while(iterator.hasNext())
 * {
 * print(iterator.next()+" ");
 * }
 */
