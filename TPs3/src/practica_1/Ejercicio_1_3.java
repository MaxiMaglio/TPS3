package practica_1;

public class Ejercicio_1_3 {
    //Otro problema frecuente es intercalar dos secuencias ordenadas. Este problema se conoce en
    //inglés como merge. El enunciado es:
    // Dados dos arreglos ordenados, a y b, construir un tercer arreglo de salida c que contenga a
    //los elementos de ambos arreglos de entrada, y esté ordenado.
    //Algoritmo de merge
    //• Mantener un índice para recorrer el arreglo a otro para b y otro para c.
    //• Recorrer linealmente los arreglos a y b, asignando de a un elemento por vez en el
    //arreglo de salida c. El elemento a asignar en c es el menor entre el elemento actual de
    //a y el actual de b.
    //• Incrementar en 1 el índice del arreglo del que provino el elemento y también
    //incrementar en 1 el índice de c. 
    //• Repetir hasta que uno de los dos arreglos de entrada haya sido pasado totalmente a c.
    //• Pasar el resto del otro arreglo a c.
    //Se pide codificar el algoritmo merge para cualquier tipo de objetos comparables
    public static void main(String[] args) {
        int[] a = {0,2,4,6,8};
        int[] b = {3,7,8,8,10};
        int[] c = mergeArray(a,b);
        System.out.println(practica_1.Ejercicio_1_2.arrayToString(c));
    }

    static int[] mergeArray(int[] arrayA, int[] arrayB){
        int[] arrayC = new int[arrayA.length+arrayB.length];
        int a=0;
        int b=0;
        int c=0;
        for (int i = 0; i < arrayC.length ; i++) {
            if (a < arrayA.length && b < arrayB.length) {
                if (arrayA[a] < arrayB[b]) {
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
