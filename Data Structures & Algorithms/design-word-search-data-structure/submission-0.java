class Node {
    Node[] links = new Node[26];
    boolean isend = false;
}

public class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int j = c - 'a';
            if (node.links[j] == null) {
                node.links[j] = new Node();
            }
            node = node.links[j];
        }
        node.isend = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, Node node) {
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);

            // wildcard '.'
            if (c == '.') {
                for (Node child : node.links) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            }
            // regular character
            else {
                if (node.links[c - 'a'] == null) {
                    return false;
                }
                node = node.links[c - 'a'];
            }
        }
        return node.isend;
    }
}


