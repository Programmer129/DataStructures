package linked_list;

import stack.Stack;

import java.util.Iterator;

public class LinkedList<T extends Number> implements Iterable<T> {

    private Node head;

    public Node getHead() {
        return head;
    }

    /**
     * insert node after prevNode
     * @param prevNode
     * @param data
     */
    public void insert(Node prevNode,T data){
        if(prevNode==null)
            return;
        if(prevNode.next==null){
            prevNode.next = new Node<>(data);
            return;
        }
        Node next = prevNode.next;
        prevNode.next = new Node<>(data);
        prevNode.next.next = next;
    }

    /**
     * adds data at the end of linked list
     * @param data
     * @return void
     */
    public void push(T data){
        if(this.head==null){
            this.head = new Node<>(data);
            return;
        }
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = new Node<>(data);
    }

    /**
     * adds data at the beginning of linked list
     * @param data
     */
    public void pushFront(T data){
        Node newHead = new Node<>(data);
        newHead.next = this.head;
        this.head = newHead;
    }

    /**
     *print elements of linked list
     */
    public void print(){
        if(head==null)
            return;
        Node current = head;
        do{
            System.out.print(current.getData()+" ");
            current = current.next;
        }while(current!=null);
        System.out.println();
    }

    /**
     *
     * @return size of linked list
     */
    public int size(){
        Node current = head;
        int s=0;
        while(current!=null){
            current = current.next;
            s++;
        }
        return s;
    }

    /**
     *delete element from linked list
     * @param data
     * @return void
     */
    public void deleteWithValue(T data){
        if(head==null){
            return;
        }
        if(head.getData()==data){
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next!=null){
            if(current.next.getData()==data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /**
     *
     * @param data
     * @return null if no such data or Node otherwise
     */
    public Node getNode(T data){
        Node current = head;
        while(current != null){
            if(current.getData().equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * print element in reversed order
     */
    public void printReverse(){
        Node current = this.head;
        Stack stack = new Stack();
        while(current != null){
            stack.push(current.getData());
            current = current.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    public boolean hasCycle() {
        if(this.head == null || this.head.next == null){
            return false;
        }
        Node slow = this.head;
        Node fast = this.head;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     *reversed linked list using recursion
     */
    public void printRecursion(Node n) {
        if(n.next == null){
            System.out.println(n.getData());
            return;
        }
        printRecursion(n.next);
        System.out.println(n.getData());
    }

    /**
     *
     * time complexity O(n)
     * @return middle node of linked list
     */
    public Node middle(){
        int size = this.size();
        size/=2;
        if(size%2==0){
            size--;
        }
        Node current = this.head;
        while(size>0){
            current = current.next;
            size--;
        }
        return current;
    }

    /**
     * time complexity O(n)
     * auxsilary space O(1)
     * @return true if list is palindrome and false otherwise
     */
    public boolean isPalindrome(){
        Node slow = head;
        Node fast = head;
        Node second;
        Node prev_of_slow = head;
        Node midnode = null;
        boolean res = true;
        if (head != null && head.next != null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prev_of_slow = slow;
                slow = slow.next;
            }
            if (fast != null) {
                midnode = slow;
                slow = slow.next;
            }
            second = slow;
            prev_of_slow.next = null;
            second = reverse(second);
            res = areSameLists(head, second);
            second = reverse(second);
            if (midnode != null) {
                prev_of_slow.next = midnode;
                midnode.next = second;
            } else
                prev_of_slow.next = second;
        }
        return res;
    }


    /**
     * check if two lists are equal
     * @param head1
     * @param head2
     * @return
     */
    private boolean areSameLists(Node head1,Node head2){
        Node cur1 = head1;
        Node cur2 = head2;
        while(cur1.next!=null && cur2.next!=null){
            if(cur1.getData().equals(cur2.getData())){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            else{
                return false;
            }
        }
        return cur1.getData().equals(cur2.getData());
    }

    /**
     * reverse linked list
     * @param node
     * @return
     */
    private Node reverse(Node node){
        Node previous = null;
        Node current = node;
        Node next;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this.head);
    }
}
