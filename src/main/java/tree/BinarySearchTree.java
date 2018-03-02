package tree;

import linked_list.LinkedList;

public class BinarySearchTree<Key extends Comparable<Key>,Value> implements Tree<Key,Value> {

    private Node root;

    public BinarySearchTree(){ }

    public void insert(Key key,Value value){
            this.root = insertRecursion(root, key, value);
    }

    @Override
    @Deprecated
    public synchronized Node insertRecursion(Node node, Key key, Value value) {
        if(node == null){
            node=new Node<>(key,value);
            return node;
        }
        if(node.getKey().compareTo(key) < 0){
            node.right = insertRecursion(node.right,key,value);
        }
        if(node.getKey().compareTo(key) > 0){
            node.left = insertRecursion(node.left,key,value);
        }
        node = rebalance(node);
        return node;
    }

    private int balanceValue(Node left, Node right){
        return height(left)-height(right);
    }

    public Node contains(Key key){
        return search(root,key);
    }

    @Override
    @Deprecated
    public synchronized Node search(Node node, Key key) {
        if(node.getKey().equals(key)){
            return node;
        }
        if(node.getKey().compareTo(key) == -1){
            return search(node.right,key);
        }
        if(node.getKey().compareTo(key) == 1){
            return search(node.left,key);
        }
        return null;
    }

    @Override
    @Deprecated
    public synchronized Node delete(Node node, Key key) {
        if(root.getKey().compareTo(key) < 0){
            root.right = delete(root.right,key);
        }
        if(root.getKey().compareTo(key)>0){
            root.left = delete(root.left,key);
        }
        if(root.getKey().equals(key)){
            if(root.left == null && root.right == null){
                root = null;
            }
            else if(root.left == null){
                root = root.right;
            }
            else if(root.right == null){
                root = root.left;
            }
            else{
                Node right = root.right;
                Node left = root.left;
                root = null;
                root = left;
                root.right = right;
            }
        }
        return root;
    }

    public void delete(Key key){
        this.root = delete(this.root,key);
    }

    public void print(){
        inorderTraversal(this.root);
    }

    @Override
    public void inorderTraversal(Node root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.println(root.getKey());
            inorderTraversal(root.right);
        }
    }

    public int treeHeight(){
        return height(root);
    }

    @Override
    public int height(Node root){
        if(root == null){
            return -1;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

    private Node min(Node root){
        Node cuurent = root;
        while(cuurent.left != null){
            cuurent = cuurent.left;
        }
        return cuurent;
    }

    public Node minTree(){
        return min(root);
    }

    private Node max(Node root){
        Node cuurent = root;
        while(cuurent.right != null){
            cuurent = cuurent.right;
        }
        return cuurent;
    }

    public Node maxTree(){
        return max(root);
    }

    private Node leftRotate(Node node){
        Node newRoot = node.right;
        node.right = node.right.left;
        newRoot.left = node;
        newRoot.height = height(newRoot);
        return newRoot;
    }

    private Node rightRotate(Node node){
        Node newRoot = node.left;
        node.left = node.left.right;
        newRoot.right = node;
        newRoot.height = height(newRoot);
        return newRoot;
    }

    private Node rebalance(Node node){
        int div = balanceValue(node.left,node.right);
        if(div > 1){
            if(height(node.left.left)>=height(node.left.right)){
                node = rightRotate(node);
            }
            else{
                node = leftRotate(node.left);
                node = rightRotate(node);
            }
        }
        if(div < -1){
            if(height(node.right.right)>=height(node.right.left)){
                node = leftRotate(node);
            }
            else{
                node = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        return node;
    }

    /**
     * a and b must be leaves of three
     * time complexity O(logn)
     * @param a
     * @param b
     * @return lowest common ancestor
     */
    private Key lowestCommonAncestor(Node root,Node a,Node b){
        LinkedList first = new LinkedList();
        LinkedList second = new LinkedList();
        Node current = root;
        while(current.getKey() != a.getKey()){
            first.push((Number)current.getKey());
            current = current.getKey().compareTo(a.getKey())<0 ? current.right : current.left;
        }
        while(root.getKey() != b.getKey()){
            second.push((Number)root.getKey());
            root = root.getKey().compareTo(b.getKey())<0 ? root.right : root.left;
        }
        linked_list.Node head1 = first.getHead();
        linked_list.Node head2 = second.getHead();
        Number ans = null;
        while(head1 != null && head2 != null){
            if(head1.getData().equals(head2.getData())){
                ans = head1.getData();
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return (Key)ans;
    }

    public Key LCA(Key a,Key b){
        return lowestCommonAncestor(root,contains(a),contains(b));
    }

}
