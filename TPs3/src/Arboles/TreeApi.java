package Arboles;

import java.util.ArrayList;

/**
 * @author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 3/30/2021.
 * @project TPS3
 */
public class TreeApi<T> {

    //Este seria el ejercicio 13)a)
    public int weight(BinaryTree<T> a) {
        if (a.isEmpty()) {
            return 0;
        } else return 1 + weight(a.getLeft()) + weight(a.getRight());
    }

    //Numero de hojas (nodos vacios). Ejercicio 13)b)
    public int leafCount(BinaryTree<T> a) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return 1;
        } else {
            return leafCount(a.getLeft()) + leafCount(a.getRight());
        }
    }

    public int completeNodesQuantity(BinaryTree<T> a) {
        //Si esta vacio
        if (a.isEmpty()) {
            return 0;
        }
        //Si solo el arbol izq esta vacio
        if (a.getLeft().isEmpty()) {
            return completeNodesQuantity(a.getRight());
        }
        //Si solo el arbol der esta vacio
        if (a.getRight().isEmpty()) {
            return completeNodesQuantity(a.getLeft());
        }
        //Si ninguno esta vacio es la suima del nodo + sus 2 arboles
        return 1 + completeNodesQuantity(a.getRight()) + completeNodesQuantity(a.getLeft());

    }

    //Este seria el ejercicio 13)c)
    public int ocurrencias(BinaryTree<T> a, T o) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getRoot().equals(o))
            return
                    1 + ocurrencias(a.getLeft(), o) + ocurrencias(a.getRight(), o);
        else
            return ocurrencias(a.getLeft(), o) + ocurrencias(a.getRight(), o);
    }

    public void inorden(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            inorden(a.getLeft());
            System.out.println(a.getRoot());
            inorden(a.getRight());
        }
    }

    public void inorden(BinaryTree<T> a, ArrayList<T> ar) {
        if (!a.isEmpty()) {
            inorden(a.getLeft(), ar);
            ar.add(a.getRoot());
            inorden(a.getRight(), ar);
        }
    }


    int countLeft = 1;
    int countRight = 1;

    //Ejercicio 13c)
    /*public int elementosPorNivel(BinaryTree<T> a, int level){
        int elements = 0;
        for (int i = 1; i < level-1; i++) {
            if(!a.getLeft().isEmpty()){
                elementosPorNivelIzq(a.getLeft(),level);
            }if(!a.getRight().isEmpty()){
                elementosPorNivelDer(a.getRight(),level);
            }
        }
    }

    private int elementosPorNivelIzq(BinaryTree<T> a, int level) {
        if (countLeft != level) {
            if (!a.getLeft().isEmpty()) {
                countLeft++;
                elementosPorNivelIzq(a.getLeft(), level);
            }else{
                return 0;
            }
        }
    return 0;
    }
    private int elementosPorNivelDer(BinaryTree<T> a, int level) {
        if (countRight != level){
            if (!a.getRight().isEmpty()){
                countRight++;
                elementosPorNivelDer(a.getRight(), level);
            }
        }
        return weight(a);
    }*/
    public int height(BinaryTree tree) {
        if (tree.isEmpty()) {
            return -1;
        }
        int heightLeft = height(tree.getLeft());
        int heightRight = height(tree.getRight());
        if (heightLeft > heightRight) {
            return heightLeft + 1;
        } else {
            return heightRight + 1;
        }
    }

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

    public boolean includes(BinaryTree tree1, BinaryTree tree2) {
        if (tree1.isEmpty()) {
            return true;
        } else if (ocurrencias(tree2, (T) tree1.getRoot()) == 1) {
            return includes(tree1.getLeft(), tree2) && includes(tree1.getRight(), tree2);
        } else {
            return false;
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

    public boolean semejantesSinRepetidos(BinaryTree tree1, BinaryTree tree2) {
        return weight(tree1) == weight(tree2) && includes(tree1, tree2);
    }

    public boolean isCompleto(BinaryTree t) {
        if (t.isEmpty()) {
            return false;
        } else if (t.getLeft().isEmpty() && t.getRight().isEmpty()) {
            return true;
        } else if (t.getRight().isEmpty() || t.getLeft().isEmpty()) {
            return false;
        } else {
            return isCompleto(t.getLeft()) && isCompleto(t.getRight());
        }
    }


    public boolean isFull(BinaryTree t) {
        if (height(t) == 0) {
            return true;
        }
        if (height(t.getRight()) == height(t.getLeft())) {
            return isFull(t.getLeft()) && isFull(t.getRight());
        } else {
            return false;
        }
    }

    public boolean isStable(BinaryTree<Integer> t) {
        if (t.isEmpty()) {
            return true;
        }
        if (t.getRight().isEmpty() && t.getLeft().isEmpty()) {
            return true;
        }
        if (t.getRight().isEmpty() && !t.getLeft().isEmpty()) {
            if (t.getLeft().getRoot() < t.getRoot()) {
                return isStable(t.getLeft());
            }else{
                return false;
            }
        }
        if (t.getLeft().isEmpty() && !t.getRight().isEmpty()) {
            if (t.getRight().getRoot() < t.getRoot()) {
                return isStable(t.getRight());
            }else{
                return false;
            }
        }else {
            if(t.getLeft().getRoot()<t.getRoot() & t.getRight().getRoot()<t.getRoot()){
                return isStable(t.getLeft()) && isStable(t.getRight());
                }
            else{
                return false;
            }
        }
    }

    public void displayBorder(BinaryTree t){
        if(!t.isEmpty()){
            if(height(t)==0){
                System.out.println(t.getRoot());
            }else{
                displayBorder(t.getLeft());
                displayBorder(t.getRight());
            }
        }
    }

    public ArrayList<T> arrayListBorder(BinaryTree t, ArrayList<T> arr){
        if(!t.isEmpty()){
            if(height(t)==0){
                arr.add((T) t.getRoot());
            }else{
                arrayListBorder(t.getLeft(),arr);
                arrayListBorder(t.getRight(),arr);
            }
        }
        return arr;
    }

}