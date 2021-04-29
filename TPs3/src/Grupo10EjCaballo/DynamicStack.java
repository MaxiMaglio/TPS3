package Grupo10EjCaballo;

public class DynamicStack<T> implements StackInterface<T> {

    private Node<T> top;
    private int size;

    public DynamicStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    @Override
    public void pop() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        }
        top = top.next;
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
        size = 0;
    }

    public void printStack() throws IsEmptyException {
        while (!isEmpty()) {
            System.out.print(peek() + "| ");
            pop();
        }
    }


    /*
    public DynamicStack<T> createCopyStack() throws IsEmptyException {
        DynamicStack<T> copyStack = new DynamicStack<>();
        T[] auxArr = new T[size()];
        int i = size() - 1;
        while (!isEmpty()) {
            auxArr[i] = peek();
            i--;
            pop();
        }
        for (int j = 0; j < auxArr.length; j++) {
            copyStack.stack(auxArr[j]);
            stack(auxArr[j]);
        }
        return copyStack;
    }
*/

}
