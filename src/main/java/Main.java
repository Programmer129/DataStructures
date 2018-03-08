import strings.Trie;
import strings.TrieNode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

//        try(Scanner in = new Scanner(System.in)) {
//            int n = in.nextInt();
//            Trie trie = new Trie();
//            for(int i=0;i<n;i++){
//                String s = in.next();
//                String s1 = in.next();
//                if(s.equals("add")){
//                    trie.insert(s1);
//                }
//                else{
//                    System.out.println(trie.numberOfPrefix(s1));
//                }
//            }
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//        }

        TrieNode trieNode = new TrieNode();
        TrieNode trieNode1 = new TrieNode();
        trieNode.hashMap.put('a',new TrieNode());
        trieNode1.hashMap.put('b',new TrieNode());
        System.out.println(trieNode.equals(trieNode1));
        System.out.println(trieNode.hashCode());
        System.out.println(trieNode1.hashCode());

    }
}
