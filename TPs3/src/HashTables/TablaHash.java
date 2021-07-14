package HashTables;

import GuiaBST.BinarySearchTree;

public class TablaHash {
    // Implementacion de algunos metodos de
    // Tabla Hash con resolucion dinamica de colisiones
    // El objeto que se inserta debe implementar las interfaces Comparable y
    //Hashable.
    // Autor Alicia Gioia

    private DynamicList<Comparable> t[];
    private int capacidad;

    public TablaHash(int M) {
        if (!Primo.esPrimo(M))
            M = Primo.proxPrimo(M);
        capacidad = M;
        t = new DynamicList[M];
        for(int i = 0; i < M ; i++)
            t[i] = new DynamicList();
    }

    public void insertar (Comparable x) {
        int k =((Hashable) x).hash(capacidad);
        t[k].insertNext(x);
    }
    public Object buscar (Object x) {
        int k = ((Hashable) x).hash(capacidad);
        t[k].goTo(0);
        int l = t[k].size();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(t[k].getActual())== 0)
                return t[k].getActual();
        return x;
    }
    public BinarySearchTree obtenerArBinBus () {
        BinarySearchTree a = new BinarySearchTree();
        for (int i = 0; i < capacidad; i++ ) {
            if (!t[i].isVoid()) {
                t[i].goTo(0);
                for (int j = 0; j < t[i].size() ; j++) {
                    a.insert(t[i].getActual());
                    t[i].goNext();
                    j++;
                }
            }
        }
        return a;
    }
}

interface Hashable {
    int hash(int M);
}
class Primo {
    public static boolean esPrimo(int n) {
        if (n == 1 || n == 2 || n == 3)
            return true;
        if (n % 2 == 0)
            return false;
        else {
            int k = 3;
            while (k <= Math.sqrt(n)) {
                if (n % k == 0)
                    return false;
                k = k +2;
            }
        }
        return true;
    }
    public static int proxPrimo(int n) {
        if (n % 2 == 0)
            n++;
        while (!esPrimo(n))
            n = n + 2;
        return n;
    }
}
