package Arboles;

import java.util.ArrayList;

/**
 * @author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 3/30/2021.
 * @project TPS3
 */
public class TreeApi<T> {

    //Este seria el ejercicio 13)a)
    public int size(BinaryTree<T> a) {
        if (a.isEmpty()) {
            return 0;
        } else return 1 + size(a.getLeft()) + size(a.getRight());
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
        return size(a);
    }*/
    public int height(BinaryTree<T> tree){
        if(tree.isEmpty()){
            return -1;
        }
        int heightLeft= height(tree.getLeft());
        int heightRight = height(tree.getRight());
        if(heightLeft>heightRight){
            return heightLeft+1;
        }else{
            return heightRight+1;
        }
    }
}