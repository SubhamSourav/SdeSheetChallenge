import java.util.*;

class graphNode {
    public int data;
    public ArrayList<graphNode> neighbours;

    graphNode() {
        data = 0;
        neighbours = new ArrayList<graphNode>();
    }

    graphNode(int val) {
        data = val;
        neighbours = new ArrayList<graphNode>();
    }

    graphNode(int val, ArrayList<graphNode> neighbours) {
        data = val;
        this.neighbours = neighbours;
    }
}

public class _1graphClone {

    static void dfs(graphNode node, graphNode copy, graphNode[] vis) {
        vis[copy.data] = copy;

        for (graphNode n : node.neighbours) {
            if (vis[n.data] == null) {
                graphNode newNode = new graphNode(n.data);
                copy.neighbours.add(newNode);
                dfs(n, newNode, vis);
            } else {
                copy.neighbours.add(vis[n.data]);
            }
        }
    }

    public static graphNode cloneGraph(graphNode node) {
        if (node == null)
            return null;
        graphNode[] vis = new graphNode[100001];
        graphNode copy = new graphNode(node.data);
        dfs(node, copy, vis);
        return copy;
    }
}