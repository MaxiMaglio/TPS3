package practica_1;

public class Ejercicio_1_2 {
    public static void main(String[] args) {

        int [] randomArray = randomArray(5, 99, -99);


    }

    // (2)
    //Un problema muy frecuente es ordenar un conjunto de datos en forma ascendente o
    //descendente. Los datos pueden ser números enteros, dobles, strings o estructuras más
    //complejas. Este problema se conoce en inglés como sort. Algunos algoritmos básicos son
    //selección, inserción, y burbujeo. Hay otros más complejos pero más eficientes como por
    //ejemplo quicksort.
    //____________________________________________________________________________________________________________________________________________________________________________
    // a) Describir los algoritmos de selección, inserción, burbujeo.

    /*
    selección:
                Consiste en encontrar el menor de todos los elementos del arreglo o vector e intercambiarlo con el que está en la primera posición. Luego el segundo mas pequeño, y así sucesivamente hasta ordenarlo todo.

    inserción:
                El metodo de insercion es el siguiente: Se ordenan los primeros dos valores del array en el orden deseado (ascendente/descendente). Luego, se toma el 3er valor y este se inserta en la posición correcta respecto a los otros dos valores, y así sucesivamente.
    burbujeo:
                El algoritmo de la burbuja es un algoritmo de ordenamiento de arreglos popular, este dividirá el arreglo en 2 secciones o particiones, una ordenada y la otra desordenada, durante la ejecución la partición ordenada irá creciendo y la des ordenada irá disminuyendo.
     */
    //____________________________________________________________________________________________________________________________________________________________________________
    // b) Codificarlos.

    static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int aux = array[i];
                array[i] = array[min];
                array[min] = aux;
            }
        }
        return array;
    }

    static int[] insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        return array;
    }

    static int[] bubbleSort(int[] array) {
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    //____________________________________________________________________________________________________________________________________________________________________________
    // c) Generar en forma random un arreglo de números enteros para distintos valores de N (siendo N el tamaño del arreglo) y comparar los tiempos para distintos valores de N.

    static int[] randomArray(int arrayLength, int minNumber, int maxNumber){
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * (maxNumber - minNumber + 1) + minNumber);
        }
        long end = System.currentTimeMillis();
        return array;
    } //devuele un arreglo de (n) longitud, con numeros aleatorios desde (minNumber) hasta (maxNumber).

    static double randomArrayExecutionTime(int arrayLength, int minNumber, int maxNumber){
        long start = System.currentTimeMillis(); //devuelve un número long que devuelve los milisegundos desde el 01/01/1970.
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * (maxNumber - minNumber + 1) + minNumber);
        }
        long end = System.currentTimeMillis();
        return (double) ((end - start));
    } // Crea un arreglo de la misma forma que randomArray, solo que devuelve los milisegundos que tardo en ejecutrase el metodo.

    static double selectionSortExecutionTime(int[] array) {
        long start = System.currentTimeMillis(); //devuelve un número long que devuelve los milisegundos desde el 01/01/1970.
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int aux = array[i];
                array[i] = array[min];
                array[min] = aux;
            }
        }
        long end = System.currentTimeMillis();
        return (double) ((end - start));    }

    static double insertionSortExecutionTime(int array[]) {
        long start = System.currentTimeMillis(); //devuelve un número long que devuelve los milisegundos desde el 01/01/1970.
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        long end = System.currentTimeMillis();
        return (double) ((end - start));    }

    static double bubbleSortExecutionTime(int[] array) {
        long start = System.currentTimeMillis(); //devuelve un número long que devuelve los milisegundos desde el 01/01/1970.
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        return (double) ((end - start));
    }
    //____________________________________________________________________________________________________________________________________________________________________________
    // d) Modificar los algoritmos anteriores para que ordenen cadenas. Observar que hay que realizar muy pocos cambios.

    static String[] selectionSort(String[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                String aux = array[i];
                array[i] = array[min];
                array[min] = aux;
            }
        }
        return array;
    }

    static String[] insertionSort(String[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            String key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i].compareTo(key) > 0)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        return array;
    }

    static String[] bubbleSort(String[] array) {
        int n = array.length;
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    //____________________________________________________________________________________________________________________________________________________________________________
    // e) Modificar los algoritmos de manera que ordenen cualquier tipo de dato (no sólo simples sino también compuestos, como por ejemplo debemos ordenar aviones por compañía y nro de avión).

    static <T> Object[] selectionSort(Comparable<T>[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo((T) array[min]) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                Comparable<T> aux = array[i];
                array[i] = array[min];
                array[min] = aux;
            }
        }
        return array;
    }

    static <T> Object[] insertionSort(Comparable<T>[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            Comparable<T> key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i].compareTo((T) key) > 0)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        return array;
    }

    static <T> Object[] bubbleSort(Comparable<T>[] array) {
        int n = array.length;
        Comparable<T> temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].compareTo((T) array[j]) > 0) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    //____________________________________________________________________________________________________________________________________________________________________________
    // f) Buscar temas afines en Internet (hay páginas muy interesantes).

    //____________________________________________________________________________________________________________________________________________________________________________
    // g) Desarrollar la versión recursiva del método de selección.

    static int[] RecursiveSelectionSort(int[] array) {
        return array; // falta implementar
    }

    //____________________________________________________________________________________________________________________________________________________________________________
    // extras
    static int[] copyArray(int array[]){
        int [] copyArray = new int[array.length];
        for (int i = 0; i < array.length; i++)
            copyArray[i] = array[i];
        return copyArray;
    }

    public static String arrayToString(int[] array){
        String string = "{";
        for(int i=0; i < array.length; i++){
            if(i < array.length-1)
                string += array[i] + ", ";
            else
                string += array[i] + "}";
        }
        return string;
    }

    public static String arrayToString(String[] array){
        String string = "{";
        for(int i=0; i < array.length; i++){
            if(i < array.length-1)
                string += array[i] + ", ";
            else
                string += array[i] + "}";
        }
        return string;
    }
}

/*
        System.out.println(randomArrayExecutionTime(100,0,100));
        System.out.println(randomArrayExecutionTime(1000,0,100));
        System.out.println(randomArrayExecutionTime(10000,0,100));
        System.out.println(randomArrayExecutionTime(3000000,0,100));
 */
