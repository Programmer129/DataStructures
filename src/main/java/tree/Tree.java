package tree;

interface Tree<Key extends Comparable<Key>,Value> {

    Node insertRecursion(Node node,Key key,Value value);

    Node search(Node node,Key key);

    Node delete(Node node,Key key);

    void inorderTraversal(Node node);

    int height(Node node);

}
