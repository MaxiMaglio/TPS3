package StacksAndQueues;

public class DynamicStack<T> implements StackInterface<T>{
    private Node top;

    public DynamicStack(){
        top = null;
    }

    public void push(T element){
        Node n = new Node(element);
        n.next = top;
        top = n;
    }
    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void pop() throws IsEmptyException {
        top=top.next;
    }

    @Override
    public void stack(T element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void empty() {

    }
}
