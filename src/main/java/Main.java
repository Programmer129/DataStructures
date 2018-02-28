import tree.BinarySearchTree;
import tree.ThreadSafe;

public class Main {

    public static void main(String[] args) {

        ThreadSafe threadSafe = new ThreadSafe(50);
        ThreadSafe threadSafe1 = new ThreadSafe(55);
        ThreadSafe threadSafe2 = new ThreadSafe(40);
        Thread t1 = new Thread(threadSafe);
        Thread t2 = new Thread(threadSafe1);
        Thread t3 = new Thread(threadSafe2);
        t1.start();
        t2.start();
        t3.start();
    }
}
