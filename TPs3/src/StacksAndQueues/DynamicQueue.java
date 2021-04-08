package StacksAndQueues;

import utils.IsEmptyException;

public class DynamicQueue<T> implements QueueInterface<T>{

    private Node<T> front;
    private Node<T> back;
    private int size;

    public DynamicQueue(){
        front=new Node<T>(null,null);
        back=new Node<T>(null,null);;
        size=0;
    }
    @Override
    public void enqueue(T element) {
        if(isEmpty()){
            back = new Node<T>(element);
            front=back;
            ++size;
        }else {
            Node<T> aux = new Node<T>(element,null);
            back.setNext(aux);
            back=aux;
            ++size;
        }
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if(isEmpty()){
            throw new IsEmptyException();
        }else {
            T dequeued = front.getData();
            front = front.next;
            --size;
            return dequeued;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
}
