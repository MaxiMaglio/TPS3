package HashTables;

public class OpenHashTable<T> {
    private DynamicList<T>[] dynamicLists;
    private int capacidad;

    public OpenHashTable(int M) {
        if (!Primo.esPrimo(M))
            M = Primo.proxPrimo(M);
        capacidad = M;
        dynamicLists = new DynamicList[M];
        for(int i = 0; i < M ; i++)
            dynamicLists[i] = new DynamicList<>();
    }

    public void insert (T x) {
        int k =((Hashable) x).hash(capacidad);
        dynamicLists[k].insertNext(x);
    }

    public Object search (Object x) {
        int k = ((Hashable) x).hash(capacidad);
        dynamicLists[k].goTo(0);
        int l = dynamicLists[k].size();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(dynamicLists[k].getActual())== 0)
                return dynamicLists[k].getActual();
        return x;
    }
    public boolean contains(Object x){
        int k = ((Hashable) x).hash(capacidad);
        dynamicLists[k].goTo(0);
        int l = dynamicLists[k].size();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(dynamicLists[k].getActual())== 0)
                return true;
        return false;
    }
    public BinarySearchTree getBinarySearchTree() {
        BinarySearchTree a = new BinarySearchTree();
        for (int i = 0; i < capacidad; i++ ) {
            if (!dynamicLists[i].isVoid()) {
                dynamicLists[i].goTo(0);
                for (int j = 0; j < dynamicLists[i].size() ; j++) {
                    a.insert((java.lang.Comparable) dynamicLists[i].getActual());
                    dynamicLists[i].goNext();
                    j++;
                }
            }
        }
        return a;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
