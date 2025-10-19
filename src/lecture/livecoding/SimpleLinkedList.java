package lecture.livecoding;

public class SimpleLinkedList<T> implements IList<T> {
    /*
    Mostenirea in Java:
        - fiecare clasa mosteneste EXACT o clasa (except Object)
        - orice clasa poate implementa oricate interfete
     */

    private Node head;

    private int size;

    private class Node {
        /*
        Daca clasa Node nu trebuie sa fie vizibila din afara clasei SimpleLinkedList,
        o putem declara interna ("nested class")
         */
        private final T data;
        private final Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    public void add(T elem) {
//        Node newNode = new Node()
        if (head == null) {
            head = new Node(elem, null);
        } else {
            head = new Node(elem, head);
        }
        this.size += 1;
    }

    @Override
    public T get(int index) {
        Node current = head;

        while (index > 0 && current.getNext() != null) {
            current = current.getNext();
            index -= 1;
        }
        return current.getData();
    }

    @Override
    public int size() {
        return this.size;
    }
}
