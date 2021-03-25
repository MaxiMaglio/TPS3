package StacksAndQueues;

public class StaticQueue<T> implements QueueInterface<T> {
    @Override
    public void enqueue(T element) {

    }

    @Override
    public T dequeue() throws IsEmptyException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
