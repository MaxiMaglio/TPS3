package Grupo10EjCaballo;



public interface StackInterface<T> {
    
    boolean isEmpty();
    T peek();
    void pop() throws IsEmptyException, Grupo10EjCaballo.IsEmptyException;
    void stack(T element);
    int size();
    void empty();

}
