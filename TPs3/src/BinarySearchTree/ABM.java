package BinarySearchTree;


public class ABM<T> {

    public ABM(){}

    public void addOrganism(Organism organism, BinarySearchTree<T> tree){
            tree.insert((Comparable<T>) organism);
    }

    public void eliminateOrganism(Organism organism, BinarySearchTree<T> tree){
            tree.delete((Comparable<T>) organism);
    }

    public void editOrganism(Organism organism, BinarySearchTree<T> tree, String newDesc){
                tree.delete((Comparable<T>) organism);
                organism.setDescription(newDesc);
                tree.insert((Comparable<T>) organism);
    }

    public void printReport(BinarySearchTree<T> tree){
        if (!tree.isEmpty()){
            printReport(tree.getLeft());
            System.out.println("Code: " + ((Organism) tree.getRoot()).getCode() +
                                "\nType: " + ((Organism) tree.getRoot()).getType()+"\n");
            printReport(tree.getRight());
        }
    }

}

