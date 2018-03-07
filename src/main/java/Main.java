import strings.Trie;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        try(Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            Trie trie = new Trie();
            for(int i=0;i<n;i++){
                String s = in.next();
                String s1 = in.next();
                if(s.equals("add")){
                    trie.insert(s1);
                }
                else{
                    System.out.println(trie.numberOfPrefix(s1));
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
