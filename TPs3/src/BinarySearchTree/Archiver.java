package BinarySearchTree;

public class Archiver<T> {
    BinarySearchTree<T> tree;
    Organism[] organisms;

    public void archive(Organism[] organisms, BinarySearchTree<T> tree){
        for (int i = 0; i < organisms.length; i++) {
            tree.insert((Comparable<T>) organisms[i]);
        }
    }
}
