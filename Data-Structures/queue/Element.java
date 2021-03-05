package data_structure.queue;

public class Element<E> {
    public E val;
    public Element next, previous;

    public Element(E val) {
        this.val = val;
        next = null;
        previous = null;
    }

    public E getValue() {
        return this.val;
    }
}
