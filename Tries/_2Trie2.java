class Node {
    Node[] links;
    int cntEndWith, cntPrefix;

    Node() {
        links = new Node[26];
        cntEndWith = 0;
        cntPrefix = 0;
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

    void increaseEnd() {
        cntEndWith++;
    }

    void increasePrefix() {
        cntPrefix++;
    }

    void deleteEnd() {
        cntEndWith--;
    }

    void reducePrefix() {
        cntPrefix--;
    }

    int getEnd() {
        return cntEndWith;
    }

    int getPrefix() {
        return cntPrefix;
    }

}

public class _2Trie2 {
    static Node root;

    public _2Trie2() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else
                return 0;
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else
                return 0;
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.deleteEnd();
    }
}
