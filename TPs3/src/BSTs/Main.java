package BSTs;

import utils.Generator;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree;
        AVLTree<Integer> avlTree;
        RedBlackTree<Integer> redBlacktree;

        //a)
        System.out.println("a) ✔");
        Integer[] randomNumbers = utils.Generator.differentRandomIntArr(1,100000, 1000);
        //b)
        System.out.println("\nb) Tiempo de construccion de cada arbol");
        long actualTime = System.currentTimeMillis();
        binarySearchTree = Comparation.generateBinarySearchTree(randomNumbers);
        long bstCreationTime = System.currentTimeMillis() - actualTime;
        System.out.println("  -binarySearchTree: " + bstCreationTime);

        actualTime = System.currentTimeMillis();
        avlTree = Comparation.generateAVL(randomNumbers);
        long avlTreeCreationTime = System.currentTimeMillis() - actualTime;
        System.out.println("  -avlTree: " + avlTreeCreationTime);

        actualTime = System.currentTimeMillis();
        redBlacktree = Comparation.generateRedBlackTree(randomNumbers);
        long redBlacktreeTreeCreationTime = System.currentTimeMillis() - actualTime;
        System.out.println("  -redBlacktree: " + redBlacktreeTreeCreationTime);
        //c
        System.out.println("\nc) Altura de cada arbol");
        System.out.println("  -binarySearchTree: " + binarySearchTree.height(binarySearchTree));
        System.out.println("  -avlTree: " + avlTree.height(avlTree.getRoot()));
        System.out.println("  -redBlacktree: " + redBlacktree.height(redBlacktree));
        //d
        System.out.println("\nd) Altura de cada arbol");
        Integer[] numerosSeleccionados = Generator.chooseRandomNumbers(randomNumbers, 10);
        System.out.print("[");
        for (int i = 0; i < numerosSeleccionados.length; i++) {
            System.out.print(numerosSeleccionados[i]);
            if (i+1 < numerosSeleccionados.length) {
                System.out.print(",");
            }
        }
        System.out.print("]");

        Integer[] randomSelected = Generator.chooseRandomNumbers(randomNumbers, 10);
        Integer[][] treesAttemps = Comparation.treesAttemps(randomSelected, binarySearchTree, avlTree, redBlacktree);
        System.out.println("[nro] | binarySearchTree | avlTree | redBlacktree");

    }
}
/*
//a)
        Integer[] randomNumbers = utils.Generator.randomIntArr(1,100000, 1000);
        //b)
        long actualTime = System.currentTimeMillis();
        avlTree = this.generateAVL(randomNumbers);
        long avlTreeCreationTime = System.currentTimeMillis() - actualTime;

        actualTime = System.currentTimeMillis();
        binarySearchTree = this.generateBinarySearchTree(randomNumbers);
        long bstCreationTime = System.currentTimeMillis() - actualTime;

        actualTime = System.currentTimeMillis();
        redBlacktree = this.generateRedBlackTree(randomNumbers);
        long redBlacktreeTreeCreationTime = System.currentTimeMillis() - actualTime;
        //c)
        int avlTreeHeight = avlTree.height();
        int binarySearchTreeHeight = binarySearchTree.height(binarySearchTree);
        int redBlacktreeTreeHeight = redBlacktree.height(redBlacktree);
        //d)
        Integer[] randomSelected = Generator.chooseRandomNumbers(randomNumbers, 10);
        int[] avlAttemps = new int[10];
        int[] bstAttemps = new int[10];
        int[] rbtAttemps = new int[10];
        for (int i = 0; i < randomSelected.length; i++) {
            avlAttemps[i] = avlTree.getLevel(avlTree.getAVLRoot(), randomSelected[i]);
            bstAttemps[i] = binarySearchTree.getLevel(binarySearchTree.getRoot(), randomSelected[i]);
            rbtAttemps[i] = redBlacktree.getLevel(redBlacktree.getRoot(), randomSelected[i]);
        }
 */