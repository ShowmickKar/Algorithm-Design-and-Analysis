package data_structure.stack;

public interface StackADT<E> {
    public void push(E data);
    public void pop();
    public E peek();
    public boolean isEmpty();
}
