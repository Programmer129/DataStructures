package speedTest;

import tree.BinarySearchTree;

import java.util.Map;
import java.util.TreeMap;

public class TreeTime {

    private final BinarySearchTree<Integer,Integer> binarySearchTree = new BinarySearchTree<>();
    private final Map<Integer,Integer> map = new TreeMap<>();

    public double BSTvsMAP(){
        long startTime = System.currentTimeMillis();
        binarySearchTree.insert(56,0);
        binarySearchTree.insert(55,0);
        binarySearchTree.insert(1,0);
        binarySearchTree.insert(6,0);
        binarySearchTree.insert(2,0);
        binarySearchTree.insert(100,0);
        long endTime = System.currentTimeMillis();
        return (double)(endTime - startTime)/1000.0;
    }

    public double MAPvsBST(){
        long startTime = System.currentTimeMillis();
        map.put(56,0);
        map.put(55,0);
        map.put(1,0);
        map.put(6,0);
        map.put(2,0);
        map.put(100,0);
        long endTime = System.currentTimeMillis();
        return (double)(endTime - startTime)/1000.0;
    }

}
