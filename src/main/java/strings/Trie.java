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
            TrieNode node = current.hashMap.get(word.charAt(i));
            if(node ==  null){
                node = new TrieNode();
                current.hashMap.put(word.charAt(i),node);
            }
            else{
                node.size++;
            }
            current = node;
        }
        current.isLast = true;
    }

    /**
     * time complexity O(|word|)
     * @param word
     * @return
     */
    public int search(String word){
        TrieNode current = this.root;
        for(int i=0;i<word.length();i++){
            if(!current.hashMap.containsKey(word.charAt(i))){
                return 0;
            }
            current = current.hashMap.get(word.charAt(i));
        }
        return current.size;
    }


}
