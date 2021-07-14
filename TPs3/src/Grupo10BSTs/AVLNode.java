package Grupo10BSTs;

class AVLNode<T> {
    int height;
    Comparable<T> key;
    AVLNode left, right;

    AVLNode(Comparable<T> d) {
        key = d;
        height = 1;
    }

}
