package data_structure.queue;

public interface QueueADT<E> {
    public void enqueue(E data);
    public void dequeue();
    public Element<E> peek() throws InterruptedException;
    public boolean isEmpty();
}
