import java.util.*;

class Pair {
    int v, w;

    Pair(int _v, int _w) {
        v = _v;
        w = _w;
    }
}

public class _5prims {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : g) {
            adj.get(edge.get(0)).add(new Pair(edge.get(1), edge.get(2)));
            adj.get(edge.get(1)).add(new Pair(edge.get(0), edge.get(2)));
        }

        int[] key = new int[n + 1];
        int[] parent = new int[n + 1];
        boolean[] mst = new boolean[n + 1];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            int mini = Integer.MAX_VALUE;
            int u = 0;
            for (int v = 1; v <= n; v++) {
                if (!mst[v] && key[v] < mini) {
                    u = v;
                    mini = key[v];
                }
            }
            mst[u] = true;
            for (Pair p : adj.get(u)) {
                if (!mst[p.v] && p.w < key[p.v]) {
                    parent[p.v] = u;
                    key[p.v] = p.w;
                }
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList();
            temp.add(parent[i]);
            temp.add(i);
            temp.add(key[i]);
            ans.add(temp);
        }

        return ans;

    }
}
