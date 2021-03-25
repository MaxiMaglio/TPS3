package StacksAndQueues;

public class StaticStack<T> implements StackInterface<T>{
    private int size;
    private T[] structure;

    public StaticStack() {
        this.size = 0;
        this.structure = (T[]) new Object[10];
    }

    public void pop() {
        size--;
    }

    @Override
    public void stack(T element) {
        if (size == structure.length){
            biggerArrangement();
        }
        size++;
        structure[size+1] = (T)element;
    }


    private void biggerArrangement(){
        T[] newStructure = (T[]) new Object[size+20];
        for (int i = 0; i < structure.length; i++) {
            newStructure[i] = structure[i];
        }
        structure = newStructure;
    }
    public int size(){
        return size;
    }

    @Override
    public void empty() {
        size = 0;
    }

    public T peek(){
        return structure[size-1];
    }
    public boolean isEmpty(){
        return size == 0;
    }
}

