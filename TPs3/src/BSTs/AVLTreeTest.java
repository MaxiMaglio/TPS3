package BSTs;

import org.junit.jupiter.api.Test;

class AVLTreeTest {

    @Test
    void insertShouldReturn() {
        AVLTree<Integer> arbol = new AVLTree<>(7);
      /* NodeAVL<Integer> node10 = new NodeAVL<>(10);
       NodeAVL<Integer> node15 = new NodeAVL<>(15);
       NodeAVL<Integer> node25 = new NodeAVL<>(25);
       NodeAVL<Integer> node80 = new NodeAVL<>(80);
       */
        arbol.insert(3);
        arbol.insert(11);
        arbol.insert(9);
        arbol.insert(13);
        arbol.insert(12);
        arbol.insert(33);
        arbol.insert(44);
        arbol.insert(55);
        arbol.insert(66);
        arbol.insert(1);
        arbol.insert(4);
        arbol.preOrden(arbol);
        System.out.println(arbol.height());
    }

    @Test
    void deleteShouldReturn() {

    }
}