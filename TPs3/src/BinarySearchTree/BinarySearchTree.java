package BinarySearchTree;

/**
 * @author Maxi Maglio on 4/13/2021.
 * @project Prog3
 */
public class BinarySearchTree<T> {

    private DoubleNode<T> root;

    public BinarySearchTree(){
        root = null;
    }
    //precondicion: elemento a insertar no pertenece al arbol
    public void insert(Comparable<T> x){
        root = insert(root, x);
    }
    // precondicion: elemento a eliminar pertenece al árbol
    public void delete(Comparable <T> x){
        root = delete(root, x);
    }

    // precondicion: árbol distinto de vacío
    public T getMin(){
        return getMin(root).data;
    }

    // precondicion: árbol distinto de vacío
    public T getMax(){
        return getMax(root).data;
    }

    // precondicion: elemnto a buscar pertenece al arbol
    public T search(Comparable<T> x){
        return search(root, x).data;
    }

    // precondicion: -
    public boolean exists(Comparable<T> x){
        return exists(root, x);
    }

    // precondicion: -
    public boolean isEmpty(){
        return (root == null);
    }

    // precondición: árbol distino de vacío
    public T getRoot(){
        return root.data ;
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getLeft(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.left;
        return t;
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getRight(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.right;
        return t;
    }


    // METODOS PRIVADOS
    private DoubleNode<T> getMax(DoubleNode <T> t){
        if (t.right == null)
            return t;
        else
            return getMax(t.right);
    }

    private DoubleNode<T> getMin(DoubleNode <T> t){
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }

    private DoubleNode <T> search(DoubleNode <T> t, Comparable<T> x){
        if (x.compareTo(t.data)== 0)
            return t;
        else if (x.compareTo(t.data)< 0)
            return search(t.left, x);
        else
            return search(t.right, x);
    }

    private boolean exists(DoubleNode <T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.data) == 0)
            return true;
        else if (x.compareTo(t.data)< 0)
            return exists(t.left, x);
        else
            return exists(t.right, x);
    }


    private DoubleNode<T> insert (DoubleNode <T> t, Comparable <T> x) {
        if (t == null){
            t = new DoubleNode<T>();
            t.data = (T) x;

        }
        else if (x.compareTo(t.data) < 0)
            t.left = insert(t.left, x);
        else
            t.right = insert(t.right, x);
        return t;
    }


    private DoubleNode<T> delete (DoubleNode<T> t, Comparable<T> x) {
        if (x.compareTo(t.data) < 0)
            t.left = delete(t.left, x);
        else if (x.compareTo(t.data) > 0)
            t.right = delete(t.right, x);
        else
        if (t.left != null && t.right != null ) {
            //Reemplazamos el elemento a eliminar por el valor del minimo
            t.data = getMin(t.right).data;
            //Y ahora eliminamos el minimo
            t.right = deleteMin(t.right);
        }
        /*
        if (!t.left != null && t.right != null){
            t.data = getMax(t.left).data;
            t.left = deleteMax(t.right);
        }
         */
        else if (t.left != null)
            t = t.left;
        else
            t =t.right;
        return t;
    }

    private DoubleNode<T> deleteMin(DoubleNode<T> t){
        if (t.left != null)
            t.left = deleteMin(t.left);
        else
            t = t.right;
        return t;
    }

    private DoubleNode<T> deleteMax(DoubleNode<T> t){
       if (t.right != null){
           t.right = deleteMax(t.right);
       }
       else{ t = t.left; }
        return t;
    }
}
