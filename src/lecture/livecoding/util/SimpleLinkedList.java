package lecture.livecoding.util;

public class SimpleLinkedList<T> implements ILinkedList<T> {

    private class Node<T> {

        private final T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getElement() {
            return element;
        }
    }

    private int size = 0;
    private Node<T> head;

    @Override
    public void add(T element) {
        if (head == null) {
            this.head = new Node<T>(element, null);
        } else {
            Node<T> current = new Node<T>(element, head);
            this.head = current;
        }
        size += 1;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
