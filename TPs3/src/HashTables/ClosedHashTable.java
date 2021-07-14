package HashTables;

public class ClosedHashTable<T extends Hashable> {
    private T[] arr;
    private int occupiedSpaces;
    private int size;

    public ClosedHashTable(int maxSize){
        this.size = maxSize;
        this.occupiedSpaces = 0;
        this.arr = (T[]) new Object[size];
    }



    public void insert(T obj){
        int posToInsert = obj.hash(size);
        if(occupiedSpaces +1 <= size){
            int i = posToInsert;
            while(posToInsert < arr.length || arr[posToInsert] == null){
                i++;
            }
            if(i == size -1 && arr[i] == null){
                arr[i] = obj;
                occupiedSpaces++;
            }
            else if(i == size -1 && arr[i] != null) {
                arr[i] = obj;
                enlargeHashTable();
            }
            else{
                arr[i] = obj;
                occupiedSpaces++;
            }
        }
        else{
            enlargeHashTable();
        }
    }
    public boolean contains(T obj){
        return indexOfInList(obj) != -1;
    }

    public int indexOfInList(T obj){
        int code = obj.hash(size);
        if(arr[code].equals(obj)) return code;
        else{
            for (int i = code; i < size; i++) {
                if(arr[code].equals(obj)) return i;
            }
            return -1;
        }
    }

    public void remove(T obj){
        if(contains(obj)){
            arr[indexOfInList(obj)] = null;
            occupiedSpaces--;
        }
    }

    private void enlargeHashTable() {
        T[] newStructure = (T[]) new Object[size*2];
        for (int i = 0; i < arr.length; i++) {
            newStructure[i] = arr[i];
        }
        arr = newStructure;
    }
}
