class Node {
    Node[] links;

    Node() {
        links = new Node[26];
    }

    boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch) {
        links[ch - 'a'] = new Node();
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

}

public class _4distinctSubstr {
    public static int distinctSubstring(String word) {
        Node root = new Node();
        int c = 0, n = word.length();

        for (int i = 0; i < n; i++) {
            Node node = root;
            for (int j = i; j < n; j++) {
                if (!node.contains(word.charAt(j))) {
                    c++;
                    node.put(word.charAt(j));
                }
                node = node.get(word.charAt(j));
            }
        }
        return c;
    }
}
