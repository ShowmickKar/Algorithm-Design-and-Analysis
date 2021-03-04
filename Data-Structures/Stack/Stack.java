package data_structure.stack;

public class Stack<E> implements StackADT<E> {
    private Element<E> top = null;

    @Override
    public void push(E data) {
        if (this.top == null) this.top = new Element<E>(data);
        else {
            this.top.next = new Element<E>(data);
            this.top.next.previous = this.top;
            this.top = this.top.next;
        }
    }

    @Override
    public void pop() {
        try {
            if (this.top == null) throw new RuntimeException("Stack is Empty");
            Element<E> temp = this.top;
            this.top = this.top.previous;
            temp = null;

        } catch(RuntimeException e) {
            System.err.println(e);
        }
    }

    @Override
    public E peek() {
        try {
            return this.top.val;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }


    @Override
    public boolean isEmpty() {
        return this.top == null;
    }
}
