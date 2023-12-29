import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;

    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public int length(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!current.getChildren().containsKey(ch)) {
                return i;
            }
            current = current.getChildren().get(ch);
        }
        return word.length();
    }

    public boolean find(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            TrieNode nextNode = currentNode.getChildren().get(ch);
            if (nextNode == null) {
                return false;
            }
            currentNode = nextNode;
        }

        return currentNode.isEndOfWord();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("application");
        trie.insert("abc");

        System.out.println(trie.find("app"));
        System.out.println(trie.find("apple"));
        System.out.println(trie.find("abc"));
        System.out.println(trie.find("ant"));
    }
}