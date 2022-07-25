import java.util.*;

class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class _5pairWgivSum {

    static class BSTIterator {

        Stack<BinaryTreeNode> st;
        Boolean reverse;

        BSTIterator(BinaryTreeNode root, Boolean _rev) {
            st = new Stack<>();
            reverse = _rev;
            pushAll(root);
        }

        int next() {
            BinaryTreeNode temp = st.pop();
            if (reverse)
                pushAll(temp.left);
            else
                pushAll(temp.right);
            return temp.data;
        }

        boolean hasNext() {
            return !st.isEmpty();
        }

        void pushAll(BinaryTreeNode root) {
            while (root != null) {
                st.push(root);
                root = reverse ? root.right : root.left;
            }
        }
    }

    public static boolean pairSumBst(BinaryTreeNode root, int k) {
        if (root == null)
            return false;

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int left = l.next(), right = r.next();

        while (left < right) {
            if (left + right == k)
                return true;
            else if (left + right > k)
                right = r.next();
            else
                left = l.next();
        }

        return false;
    }
}
