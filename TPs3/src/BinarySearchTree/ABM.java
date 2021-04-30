package BinarySearchTree;


public class ABM<T> {

    public ABM(){}

    public void addOrganism(Organism organism, BinarySearchTree<T> tree){
        if(!tree.exists((Comparable<T>) organism)){
            tree.insert((Comparable<T>) organism);
        }
        else{
            System.out.println("This organism is already in the system.");
        }
    }

    public void eliminateOrganism(Organism organism, BinarySearchTree<T> tree){
        if(tree.exists((Comparable<T>) organism)){
            tree.delete((Comparable<T>) organism);
        }
        else {
            System.out.println("This organism is not in the system.");
        }
    }

    public void editOrganism(Organism organism, BinarySearchTree<T> tree){
        if(tree.exists((Comparable<T>) organism)){
            String newDesc = Scanner.getString("Inserte la nueva descripcion: ");
                tree.delete((Comparable<T>) organism);
                organism.setDescription(newDesc);
                tree.insert((Comparable<T>) organism);
        }
    }
}
