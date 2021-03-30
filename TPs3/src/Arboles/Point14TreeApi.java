package Arboles;

import java.util.ArrayList;

/**
 * @author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 3/30/2021.
 * @project TPS3
 */
public class Point14TreeApi<T> {
    TreeApi<T> t = new TreeApi<T>();

    public Integer sum(BinaryTree<Integer> tree) {
        if (tree.isEmpty()) {
            return 0;
        }
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) {
            return tree.getRoot();
        } else {
            return sum(tree.getLeft()) + sum(tree.getRight()) + tree.getRoot();
        }
    }

    public Integer sumOfMultiplesOf3(BinaryTree<Integer> tree) {
        int a = tree.getRoot();
        if (tree.isEmpty()) {
            return 0;
        }
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) {
            if (a % 3 == 0) {
                return a;
            } else {
                return 0;
            }
        } else {
            if (a % 3 == 0) {
                return sumOfMultiplesOf3(tree.getLeft()) + sumOfMultiplesOf3(tree.getRight()) + a;
            }
            {
                return sumOfMultiplesOf3(tree.getLeft()) + sumOfMultiplesOf3(tree.getRight());
            }
        }
    }

    public boolean iguales(BinaryTree tree1, BinaryTree tree2) {
        if (!tree1.isEmpty() && !tree2.isEmpty()) {
            if (tree1.getRoot() == tree2.getRoot()) {
                iguales(tree1.getLeft(), tree2.getLeft());
                iguales(tree1.getRight(), tree2.getRight());
            } else {
                return false;
            }
        } else if ((tree1.isEmpty() && !tree2.isEmpty()) || (tree2.isEmpty() && !tree1.isEmpty())) {
            return false;
        }
        return true;
    }

    public boolean isomorfos(BinaryTree tree1, BinaryTree tree2) {
        if (!tree1.isEmpty() && !tree2.isEmpty()) {
            return isomorfos(tree1.getLeft(), tree2.getLeft()) && isomorfos(tree1.getRight(), tree2.getRight());
        } else return (!tree1.isEmpty() || tree2.isEmpty()) && (!tree2.isEmpty() || tree1.isEmpty());
    }

    public boolean semejantes(BinaryTree tree1, BinaryTree tree2) {

            T value = (T) tree1.getRoot();

            if (1 == t.ocurrencias(tree2, value)) {
                if (!tree1.getLeft().isEmpty())
                    semejantes(tree1.getLeft(), tree2);
                if (!tree1.getRight().isEmpty())
                    semejantes(tree1.getRight(), tree2);
                return true;
            } else {
                return false;
            }
    }

}