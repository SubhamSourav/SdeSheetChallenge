import java.util.*;

public class _3bellmanFord {
    static int bellmonFord(int v, int e, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[] dist = new int[v + 1];

        Arrays.fill(dist, 1000000000);

        dist[src] = 0;
        for (int i = 0; i < v - 1; i++) {
            for (ArrayList<Integer> list : edges) {
                int a = list.get(0), b = list.get(1), w = list.get(2);
                if (dist[a] != 1000000000) {
                    dist[b] = Math.min(dist[b], dist[a] + w);
                }
            }
        }

        return dist[dest];
    }
}
