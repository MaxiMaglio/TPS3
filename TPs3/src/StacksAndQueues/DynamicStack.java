package StacksAndQueues;

import utils.IsEmptyException;

public class DynamicStack<T> implements StackInterface<T>{

    private Node<T> top;
    private int size;

    public DynamicStack(){
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
            return top.data;
        }
        return null;
    }

    @Override
    public void pop() throws IsEmptyException {
        if (isEmpty()) {
          throw new IsEmptyException();
        }
        top=top.next;
        --size;
    }

    @Override
    public void stack(T element) {
        Node n = new Node(element);
        n.next = top;
        top = n;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        top.data = null;
        size=0;
    }
}
