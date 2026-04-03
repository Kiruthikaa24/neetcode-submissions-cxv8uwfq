public class Node {
    Node[] links = new Node[26]; // for 'a' to 'z'
    boolean isend = false;
}

class PrefixTree {
    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    // Insert a word into the trie
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);      // get character
            int j = c - 'a';              // find index
            if (node.links[j] == null) {  // if path not exists → create
                node.links[j] = new Node();
            }
            node = node.links[j];
        }
        node.isend = true; // mark end of word
    }

    // Search if word exists in the trie
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int j = c - 'a';
            if (node.links[j] == null) {
                return false; // missing path
            }
            node = node.links[j];
        }
        return node.isend;
    }

    // Check if any word starts with given prefix
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int j = c - 'a';
            if (node.links[j] == null) {
                return false;
            }
            node = node.links[j];
        }
        return true;
    }
}

