
import org.junit.Test;
import static org.junit.Assert.*;
import strings.TrieNode;

public class TrieNodeTest {

    @Test
    public void testEquals(){
        TrieNode trieNode = new TrieNode();
        TrieNode trieNode1 = new TrieNode();
        assertEquals(trieNode.hashCode(),trieNode1.hashCode());
    }

    @Test
    public void testNonEquals(){
        TrieNode trieNode = new TrieNode();
        TrieNode trieNode1 = new TrieNode();
        trieNode.isLast = true;
        trieNode1.isLast = true;
        trieNode.hashMap.put('a', new TrieNode());
        assertNotEquals(trieNode.hashCode(), trieNode1.hashCode());
    }

}
