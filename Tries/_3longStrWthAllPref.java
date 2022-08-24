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

class Trie {
    static Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    boolean ifPrefixExists(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                node = node.get(word.charAt(i));
                if (!node.isEnd())
                    return false;
            }
            // }else return false;
        }
        return true;
    }
}

class Solution {

    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(a[i]);
        }

        String longest = "";

        for (String word : a) {
            if (trie.ifPrefixExists(word)) {
                if (word.length() > longest.length()
                        || word.length() == longest.length() && word.compareTo(longest) < 0) {
                    longest = word;
                }
            }
        }

        return longest.equals("") ? "None" : longest;
    }
}