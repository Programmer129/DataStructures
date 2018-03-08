package strings;


import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public Map<Character,TrieNode> hashMap;
    public boolean isLast;

    public TrieNode() {
        this.hashMap = new HashMap<>();
        this.isLast = false;
    }

    @Override
    public boolean equals(Object o) {
        return this.isLast == ((TrieNode)o).isLast && this.hashMap.equals(((TrieNode)o).hashMap);
    }

    @Override
    public int hashCode() {
        return hashMap.hashCode() + Boolean.hashCode(isLast);
    }
}
