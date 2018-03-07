package strings;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    public Map<Character,TrieNode> hashMap;
    public boolean isLast;

    public TrieNode() {
        this.hashMap = new HashMap<>();
        this.isLast = false;
    }

}
