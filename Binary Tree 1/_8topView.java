import java.util.*;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    BinaryTreeNode node;
    int ver;

    Pair(BinaryTreeNode root, int vertical) {
        node = root;
        ver = vertical;
    }
}

public class _8topView {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            BinaryTreeNode node = p.node;
            int ver = p.ver;
            if (!map.containsKey(ver))
                map.put(ver, node.val);
            if (node.left != null)
                q.add(new Pair(node.left, ver - 1));
            if (node.right != null)
                q.add(new Pair(node.right, ver + 1));
        }

        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            ans.add(x.getValue());
        }
        return ans;
    }
}