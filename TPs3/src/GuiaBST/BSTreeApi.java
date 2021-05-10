package GuiaBST;

public class BSTreeApi<T> {

    //Ejercicio 4
    public void deleteAccounts(BinarySearchTree<T> toDelete, BinarySearchTree<T> accounts) throws IsEmptyException {
       T[] arr = (T[]) new Object[toDelete.weight(toDelete)];
        for (int i = 0; i < arr.length; i++) {
            accounts.delete((Comparable<T>) arr[i]);
        }
    }

    //Ejercicio 5

}
