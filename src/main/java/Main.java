import org.omg.CORBA.INTERNAL;
import speedTest.TreeTime;
import tree.BinarySearchTree;
import tree.SegmentTree;
import tree.ThreadSafe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int arr [] = {1,2,3,4};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.printSegmentTree();

    }
}
