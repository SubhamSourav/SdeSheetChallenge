import java.util.*;

class Node {
    Node[] links;

    Node() {
        links = new Node[2];
    }

    boolean contains(int i) {
        return links[i] != null;
    }

    Node get(int i) {
        return links[i];
    }

    void put(int i) {
        links[i] = new Node();
    }
}

class Trie {
    static Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (!node.contains(bit)) {
                node.put(bit);
            }
            node = node.get(bit);
        }
    }

    int getMax(int num) {
        Node node = root;
        int maxi = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (node.contains(1 - bit)) {
                maxi = maxi | 1 << i;
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxi;
    }
}

public class _7maxXorWthAnEle {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.size();
        Collections.sort(arr);
        for (int i = 0; i < queries.size(); i++) {
            queries.get(i).add(i);
            ans.add(0);
        }
        Collections.sort(queries, (a, b) -> a.get(1) - b.get(1));
        Trie t = new Trie();
        int i = 0;
        for (ArrayList<Integer> q : queries) {
            int no = q.get(0), a = q.get(1), ind = q.get(2);
            while (i < n && arr.get(i) <= a) {
                t.insert(arr.get(i));
                i++;
            }
            if (i != 0)
                ans.set(ind, t.getMax(no));
            else
                ans.set(ind, -1);
        }

        return ans;
    }
}