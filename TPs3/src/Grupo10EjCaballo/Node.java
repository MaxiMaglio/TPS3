package Grupo10EjCaballo;

public class Node<T> {
    T data;
    Node<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node(T x){
        data=x;
    }
    public Node(T x, Node<T> n){
        data=x;
        next = n;
    }
}
