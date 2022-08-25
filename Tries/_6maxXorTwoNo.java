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

public class _6maxXorTwoNo {
    public static int maximumXor(int[] A) {
        Trie trie = new Trie();
        for (int ele : A) {
            trie.insert(ele);
        }
        int maxi = 0;
        for (int ele : A) {
            maxi = Math.max(maxi, trie.getMax(ele));
        }
        return maxi;
    }
}