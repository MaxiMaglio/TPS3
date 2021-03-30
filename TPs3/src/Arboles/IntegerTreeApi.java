package Arboles;

/**
 * @author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 3/30/2021.
 * @project TPS3
 */
public class IntegerTreeApi {

    public Integer sum(BinaryTree<Integer> tree){
        if (tree.isEmpty()) {
            return 0;
        }
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) {
            return tree.getRoot();
        } else {
            return sum(tree.getLeft()) + sum(tree.getRight()) + tree.getRoot();
        }
    }
}
