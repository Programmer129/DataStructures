package tree;

public class ThreadSafe implements Runnable {

    private final BinarySearchTree<Integer,String> binarySearchTree = new BinarySearchTree<>();
    private Integer number;

    public ThreadSafe(Integer number){
        this.number = number;
    }

    @Override
    public void run() {
        binarySearchTree.insert(number,"123");
        binarySearchTree.print();
        binarySearchTree.delete(number);
    }
}
