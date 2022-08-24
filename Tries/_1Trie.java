class Node {
    Node[] links;
    boolean flag;

    Node() {
        links = new Node[26];
        flag = false;
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

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

public class _1Trie {
    static Node root;

    _1Trie() {
        root = new Node();
    }
    // Inserts a word into the trie

    public static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    // Returns if the word is in the trie
    public static boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    // Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return true;
    }
}