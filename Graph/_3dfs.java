import java.util.ArrayList;

public class _3dfs {

    static void dfs(int i, ArrayList<ArrayList<Integer>> edges, boolean[] vis, ArrayList<Integer> pans) {
        vis[i] = true;
        pans.add(i);

        for (int ele : edges.get(i)) {
            if (!vis[ele]) {
                dfs(ele, edges, vis, pans);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList());
        }

        for (int i = 0; i < e; i++) {
            list.get(edges.get(i).get(1)).add(edges.get(i).get(0));
            list.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }

        boolean[] vis = new boolean[v + 1];
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                ArrayList<Integer> pans = new ArrayList<>();
                dfs(i, list, vis, pans);
                if (pans.size() != 0)
                    ans.add(pans);
            }
        }

        return ans;

    }
}