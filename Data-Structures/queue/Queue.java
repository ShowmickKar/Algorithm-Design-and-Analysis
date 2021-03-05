package data_structure.queue;

public class Queue<E> implements QueueADT {
    private Element front = null;
    private Element rear = null;

    @Override
    public void enqueue(Object data) {
        if (this.rear == null) this.front = this.rear = new Element<E>((E) data);
        else {
            this.rear.next = new Element<E>((E) data);
            this.rear.next.previous = this.rear;
            this.rear = this.rear.next;
        }
    }

    @Override
    public void dequeue() {
        try {
            if (this.front == null) throw new IndexOutOfBoundsException("Queue is Empty");
            Element<E> temp = this.front;
            this.front = this.front.next;
            temp = null;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Element peek() {
        if (this.front == null) throw new IndexOutOfBoundsException("Queue is Empty");
        return this.front;
    }

    @Override
    public boolean isEmpty() {
        return this.front == null;
    }
}