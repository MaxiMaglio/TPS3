package Lists;

public class OrderedList<T extends Comparable<T>> extends DynamicList<T> {

    public void add(T t) {
        if (size() == 0 || t.compareTo(getActual()) == 0) {
            super.insertNext(t);
            return;
        }
        if(t.compareTo(getActual()) > 0){
            goForward(t);
        } else {
            goBackwards(t);
        }
    }

    private void goForward(T t){
        while(!endList()){
            goNext();
            if(t.compareTo(getActual()) < 0){
                insertPrev(t);
                return;
            }
        }
        insertNext(t);
    }

    private void goBackwards(T t){
        while(getActualPosition()!=0){
            goPrev();
            if(t.compareTo(getActual()) > 0){
                insertNext(t);
                return;
            }
        }
        insertPrev(t);
    }
}