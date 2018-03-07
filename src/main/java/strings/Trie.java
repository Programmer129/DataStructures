package strings;

public class Trie {

    private TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    /**
     * time complexity O(|word|)
     * @param word
     */
    public void insert(String word){
        TrieNode current = this.root;
        for(int i=0;i<word.length();i++){
            if(!current.hashMap.containsKey(word.charAt(i))){
                current.hashMap.put(word.charAt(i),new TrieNode());
            }
            current = current.hashMap.get(word.charAt(i));
        }
        current.isLast = true;
    }

    /**
     * time complexity O(|word|)
     * @param word
     * @return
     */
    public boolean search(String word){
        TrieNode current = this.root;
        for(int i=0;i<word.length();i++){
            if(!current.hashMap.containsKey(word.charAt(i))){
                return false;
            }
            current = current.hashMap.get(word.charAt(i));
        }
        return true;
    }

    public int numberOfPrefix(String word){
        int answer = 0;
        TrieNode current = this.root;
        for(int i=0;i<word.length();i++){
            if(!current.hashMap.containsKey(word.charAt(i))){
                return answer;
            }
            current = current.hashMap.get(word.charAt(i));
        }
        return current.isLast ? 0 : current.hashMap.size();
    }


}
