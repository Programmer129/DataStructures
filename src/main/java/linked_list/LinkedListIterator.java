package linked_list;

import java.util.Iterator;
import java.util.function.Consumer;

class LinkedListIterator<T> implements Iterator<T> {

    private Node head;
    private Node current;

    public LinkedListIterator(Node head) {
        this.head = head;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }

    @Override
    public void forEachRemaining(Consumer<? super T> consumer) {

    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public T next() {
        T data = (T)head.getData();
        current = head;
        head = head.next;
        return data;
    }
}
