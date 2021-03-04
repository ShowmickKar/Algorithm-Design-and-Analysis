package data_structure.singly_linked_list;

public class Node<E> {

    public E val;
    public Node next;

    public Node(E val) {
        this.val = val;
        next = null;
    }
}