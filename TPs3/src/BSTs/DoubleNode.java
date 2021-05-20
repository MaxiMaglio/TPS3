package BSTs;

/**
 * @author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 3/30/2021.
 * @project TPS3
 */
public class DoubleNode<T>{
    T data;
    DoubleNode<T> right,  left;

    public DoubleNode() { }

    public DoubleNode(T o) {
        this.data = o;
    }

    public DoubleNode(T o, DoubleNode<T> izq, DoubleNode<T> der) {
        this.data = o; this.left = izq; this.right = der;
    }

    public T getData() {
        return data;
    }
}

