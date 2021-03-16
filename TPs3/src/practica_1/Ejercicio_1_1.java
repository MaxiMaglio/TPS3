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

    public <T> int SeqSearch (Comparable<T>[] a, Comparable<T> k) {
        for (int i = 0; i < a.length; i++)
            if (k.compareTo((T) a[i]) == 0)
                return i;
        return -1;
    }

    public <T> Object[] mergeArray(Comparable<T>[] arrayA, Comparable<T>[] arrayB){
        Object[] arrayC = new Object[arrayA.length+arrayB.length];
        int a=0;
        int b=0;
        int c=0;
        for (int i = 0; i < arrayC.length ; i++) {
            if (a < arrayA.length && b < arrayB.length) {
                if (arrayA[a].compareTo((T) arrayB[b]) < 1) {
                    arrayC[c] = arrayA[a];
                    c++;
                    a++;
                } else {
                    arrayC[c] = arrayB[b];
                    c++;
                    b++;
                }
            }else if(a >= arrayA.length){
                for (int j = b; j < arrayB.length; j++) {
                    arrayC[c]=arrayB[b];
                    c++;
                    b++;
                }
            }else{
                for (int j = a; j < arrayA.length; j++) {
                    arrayC[c]=arrayA[a];
                    c++;
                    b++;
                }
            }
        }
        return arrayC;
    }
}