package StacksAndQueues;

import utils.IsEmptyException;

public class StaticStack<T> implements StackInterface<T>{
    private int top;
    private T[] structure;

    public StaticStack() {
        this.top = -1;
        this.structure = (T[]) new Object[10];
    }

    public void pop() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        }else {
            --top;
        }

    }

    @Override
    public void stack(T element) {
        if (top == structure.length-1){
            biggerArrangement();
        }
        ++top;
        structure[top] = (T)element;
    }


    private void biggerArrangement(){
        T[] newStructure = (T[]) new Object[top+20];
        for (int i = 0; i < structure.length; i++) {
            newStructure[i] = structure[i];
        }
        structure = newStructure;
    }
    public int size(){
        return ++top;
    }

    @Override
    public void empty() {
        top = -1;
    }

    public T peek() {
        if (!isEmpty()) {
            return structure[top];
        }
        return null;
    }
    public boolean isEmpty(){
        return top == -1;
    }
}

