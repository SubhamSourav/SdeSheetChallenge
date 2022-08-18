import java.util.*;

class Pair {
    int v, w;

    Pair(int _v, int _w) {
        v = _v;
        w = _w;
    }
}

public class _2dijkstra {
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int s) {
        ArrayList<Integer> dist = new ArrayList<>();
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
            dist.add(Integer.MAX_VALUE);
        }

        for (int i = 0; i < edges; i++) {
            adj.get(vec.get(i).get(0)).add(new Pair(vec.get(i).get(1), vec.get(i).get(2)));
            adj.get(vec.get(i).get(1)).add(new Pair(vec.get(i).get(0), vec.get(i).get(2)));
        }

        dist.set(s, 0);
        pq.add(new Pair(s, 0));

        while (!pq.isEmpty()) {
            Pair node = pq.remove();
            for (Pair p : adj.get(node.v)) {

                if (dist.get(node.v) + p.w < dist.get(p.v)) {
                    dist.set(p.v, dist.get(node.v) + p.w);
                    pq.add(new Pair(p.v, dist.get(p.v)));
                }
            }
        }

        return dist;
    }
}