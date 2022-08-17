import java.util.*;

public class _2bfs {

    static void bfs(List<List<Integer>> list, ArrayList<Integer> ans, boolean[] vis, int node) {
        vis[node] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int temp = q.remove();
            ans.add(temp);
            for (int ele : list.get(temp)) {
                if (!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }

    }

    public static ArrayList<Integer> BFS(int v, int edges[][]) {

        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges[0].length; i++) {
            list.get(edges[0][i]).add(edges[1][i]);
            list.get(edges[1][i]).add(edges[0][i]);
        }

        for (int i = 0; i < v; i++) {
            Collections.sort(list.get(i));
        }

        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                bfs(list, ans, vis, i);
            }
        }

        return ans;

    }
}
