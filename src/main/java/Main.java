import org.omg.CORBA.INTERNAL;
import speedTest.TreeTime;
import tree.BinarySearchTree;
import tree.ThreadSafe;

public class Main {

    public static void main(String[] args) {

//        ThreadSafe threadSafe = new ThreadSafe(50);
//        ThreadSafe threadSafe1 = new ThreadSafe(55);
//        ThreadSafe threadSafe2 = new ThreadSafe(40);
//        Thread t1 = new Thread(threadSafe);
//        Thread t2 = new Thread(threadSafe1);
//        Thread t3 = new Thread(threadSafe2);
//        t1.start();
//        t2.start();
//        t3.start();

//        TreeTime treeTime = new TreeTime();
//        System.out.println("my tree insert time:"+treeTime.BSTvsMAP());
//        System.out.println("java tree insert time:"+treeTime.MAPvsBST());

        BinarySearchTree<Integer,Integer> tree = new BinarySearchTree<>();

        tree.insert(50,0);
        tree.insert(60,0);
        tree.insert(40,0);
        tree.insert(45,0);
//        tree.insert(40,0);
//        tree.insert(30,0);
//        tree.insert(35,0);
//        tree.insert(36,0);

        System.out.println(tree.LCA(45,60));

    }
}
