package StacksAndQueues;

import utils.IsEmptyException;

public class StaticQueue<T> implements QueueInterface<T> {
    private T[] array;
    private int front;
    private int back;
    private int size;

    public StaticQueue(){
        array =  (T[]) new Object[10];
        front = 0;
        back = 0;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if(size<array.length && size!=0){
            back++;
            if(!(back<array.length)){
                back=0;
            }
            array[back]=element;
            ++size;
        }else if(size==0){
            array[back]=element;
            ++size;
        }else{
             enlarge();
             enqueue(element);
        }
    }

    @Override
    public T dequeue() throws IsEmptyException {
        T dequeued = array[front];
        if(isEmpty()){
            throw new IsEmptyException();
        }
        ++front;
        --size;
        return dequeued;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
    private void enlarge(){
        T[] array2 =  (T[]) new Object[array.length+10];
        for (int i = 0; i < array.length; i++) {
                array2[i-front]=array[i];
        }
        if(front !=0){
            int size2 = array.length-front;
            for (int i = 0; i < front; i++) {
                array2[size2+i]=array[i];
            }
        }
        back=array.length-1;
        front=0;
        array=array2;
    }
}
