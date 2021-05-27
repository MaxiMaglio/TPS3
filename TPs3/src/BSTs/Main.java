package BSTs;

import utils.Generator;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree;
        AVLTree<Integer> avlTree;
        RedBlackTree<Integer> redBlacktree;

        //a)
        System.out.println("a) ✔ (generar un arrglo de 1k enteros que varian de 1 a 100k)");
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
        //c)
        System.out.println("\nc) Altura de cada arbol");
        System.out.println("  -binarySearchTree: " + binarySearchTree.height(binarySearchTree));
        System.out.println("  -avlTree: " + avlTree.height(avlTree.getRoot()));
        System.out.println("  -redBlacktree: " + redBlacktree.height(redBlacktree));
        //d)
        System.out.println("\nd) Altura de cada arbol");
        Integer[] randomSelected = Generator.chooseRandomNumbers(randomNumbers, 10);
        Integer[][] treesAttemps = Comparation.treesAttemps(randomSelected, binarySearchTree, avlTree, redBlacktree);
        System.out.println("[nro]\t | binarySearchTree | avlTree | redBlacktree");
        System.out.println("----------------------------------------------------");
        float sumaBinarySearchTree = 0;
        float sumaAvl = 0;
        float sumRedBlacktree = 0;
        for (int i = 0; i < randomSelected.length; i++) {
            System.out.println("[" + randomSelected[i] + "]\t |\t\t  " + treesAttemps[0][i] + "  \t\t| \t " + treesAttemps[1][i] + "\t  |     " + treesAttemps[2][i]);
            sumaBinarySearchTree += treesAttemps[0][i];
            sumaAvl += treesAttemps[1][i];
            sumRedBlacktree += treesAttemps[2][i];
        }
        System.out.println("----------------------------------------------------");

        System.out.println("Promedio |\t\t  " + (sumaBinarySearchTree/randomSelected.length) + "  \t\t| \t " + (sumaAvl/randomSelected.length) + "\t  |     " + (sumRedBlacktree/randomSelected.length));

        //e)
        long[][] datosBinarySearchTree = new long[10][3];//[i][BinarySearchTree, Avl, Blacktree][tiempo p, altura p, intentos p]
        long[][] datosAvl = new long[10][3];
        long[][] datosBlacktree = new long[10][3];

        for (int i = 0; i < 10; i++) {
            //a)
            randomNumbers = utils.Generator.differentRandomIntArr(1,100000, 1000);
            //b)
            actualTime = System.currentTimeMillis();
            binarySearchTree = Comparation.generateBinarySearchTree(randomNumbers);
            datosBinarySearchTree[i][0] = System.currentTimeMillis() - actualTime;

            actualTime = System.currentTimeMillis();
            avlTree = Comparation.generateAVL(randomNumbers);
            datosAvl[i][0] = System.currentTimeMillis() - actualTime;

            actualTime = System.currentTimeMillis();
            redBlacktree = Comparation.generateRedBlackTree(randomNumbers);
            datosBlacktree[i][0] = System.currentTimeMillis() - actualTime;
            //c)
            datosBinarySearchTree[i][1] = binarySearchTree.height(binarySearchTree);
            datosAvl[i][1] = avlTree.height(avlTree.getRoot());
            datosBlacktree[i][1] = redBlacktree.height(redBlacktree);
            //d)
            randomSelected = Generator.chooseRandomNumbers(randomNumbers, 10);
            treesAttemps = Comparation.treesAttemps(randomSelected, binarySearchTree, avlTree, redBlacktree);
            sumaBinarySearchTree = 0;
            sumaAvl = 0;
            sumRedBlacktree = 0;
            for (int j = 0; j < randomSelected.length; j++) {
                sumaBinarySearchTree += treesAttemps[0][j];
                sumaAvl += treesAttemps[1][j];
                sumRedBlacktree += treesAttemps[2][j];
            }
            datosBinarySearchTree[i][2] = (long)(sumaBinarySearchTree/randomSelected.length);
            datosAvl[i][2] = (long)(sumaAvl/randomSelected.length);
            datosBlacktree[i][2] = (long)((sumRedBlacktree/randomSelected.length));
        }
        //datos a imprimir_____________________________
        long[] promedioBinarySearchTree = new long[3];
        long[] promedioBinaryAvl = new long[3];
        long[] promediolacktree = new long[3];

        promedioBinarySearchTree[1] = Comparation.promedioDeArreglo(datosBinarySearchTree[][i])
        promedioBinarySearchTree[2] = Comparation.promedioDeArreglo(datosBinarySearchTree[][i])
        promedioBinarySearchTree[3] = Comparation.promedioDeArreglo(datosBinarySearchTree[][i])

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