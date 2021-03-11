package practica_1;

public class Ejercicio_1_1 {

    // (1)
    //Modificar los algoritmos de búsqueda secuencial y búsqueda binaria de manera que devuelva
    //la posición en donde se encuentra el valor a buscar. Tener en cuenta que el elemento a buscar
    //puede no pertenecer al conjunto.
    //____________________________________________________________________________________________________________________________________________________________________________
    public <T> int BinarySearchPosition(Comparable<T>[] a, Comparable<T> k) {
        int min = 0;
        int max = a.length + 1;
        int middle = (min + max) / 2;
        while (min <= max) {
            if (k.compareTo((T) a[middle]) == 0) {
                return middle;
            } else if (k.compareTo((T) a[middle]) < 0) {
                max = middle - 1;
            } else
                min = middle + 1;
            middle = (min + max) / 2;
        }
        return -1;
    }

    public boolean SeqSearch ( int a[], int k) {
        for (int i = 0; i < a.length; i++)
            if (k == a[i])
                return true;
        return false;
    }

}