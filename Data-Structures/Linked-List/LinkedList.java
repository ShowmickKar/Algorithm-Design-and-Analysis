package data_structure.singly_linked_list;

public class LinkedList<E> {
    private Node head;
    private Node tail;
    private int length = 0;

    public LinkedList() {
        head = null;
        tail = head;
    }

    public void insert(E data, int position) {
        try {
            if (position > this.length) throw new IndexOutOfBoundsException();
            if (position == 0) {
                Node dummy = new Node(data);
                dummy.next = head;
                head = dummy;
                this.tail = this.tail.next;
            } else if (position == this.length) {
                this.tail.next = new Node(data);
                this.tail = this.tail.next;
            } else {
                int i = 0;
                for (Node current = head; current.next != null; current = current.next) {
                    if (i + 1 == position) {
                        Node dummy = new Node(data);
                        dummy.next = current.next;
                        current.next = dummy;
                        return;
                    }
                    i++;
                }
            }
            this.length++;

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public void delete(E data) {
        try {
            boolean isPresent = false;
            if (this.head.val == data) {
                isPresent = true;
                this.head = this.head.next;
                if (this.length < 2) this.tail = this.head;
            }
            for (Node current = this.head; current.next != null; current = current.next) {
                if (current.next.val == data) {
                    isPresent = true;
                    if (current.next == this.tail) this.tail = current;
                    current.next = current.next.next;
                    break;
                }
            }
            if (!isPresent) throw new IndexOutOfBoundsException("Value not present in the list");
            this.length--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public void reverse() {
        Node current = this.tail = this.head;
        Node previous = null, after = null;
        while (current != null) {
            after = current.next;
            current.next = previous;
            previous = current;
            current = after;
        }
        this.head = previous;
    }

    public void append(E data) {
        if (this.head == null) {
            this.head = this.tail = new Node(data);
        } else {
            this.tail.next = new Node(data);
            this.tail = this.tail.next;
        }
        this.length++;
    }

    public void show() {
        Node current;
        for (current = this.head; current.next != null; current = current.next) {
            System.out.print(current.val + "-> ");
        }
        System.out.println(current.val);
    }

    public boolean isPresent(E data) {
        for (Node current = this.head; current != null; current = current.next) {
            if (current.val == data) return true;
        }
        return false;
    }

    public int getLength() {
        return this.length;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }
}