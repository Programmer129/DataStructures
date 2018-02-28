import org.junit.Assert;
import org.junit.Test;
import tree.BinarySearchTree;

public class BinarySearchTest {

    BinarySearchTree<Integer,Integer> binarySearchTree = new BinarySearchTree<>();

    @Test
    void  deleteTest(){
        binarySearchTree.insert(64,0);
        binarySearchTree.insert(7,0);
        binarySearchTree.insert(43,0);
        binarySearchTree.insert(1,0);
        binarySearchTree.insert(56,0);
        binarySearchTree.insert(23,0);
    }
}
