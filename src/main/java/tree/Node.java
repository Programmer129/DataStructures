package tree;

public class Node<Key extends Comparable<Key>,Value> {
    private Value value;
    private Key key;

    public Value getValue() {
       return value;
    }

    public Node(Key key,Value value){
       this.key = key;
       this.value = value;
    }

    public void setValue(Value value) {
       this.value = value;
    }

    public Key getKey() {
       return key;
    }

    public void setKey(Key key) {
       this.key = key;
    }

    public Node<Key,Value> left;
    public Node<Key,Value> right;
    public int height;
    public Color color;
}
