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
        System.out.println("\nb) Tiempo de construccion de cada arbol (micro sec)");
        long actualTime = System.nanoTime();
        binarySearchTree = Comparation.generateBinarySearchTree(randomNumbers);
        long bstCreationTime = (System.nanoTime() - actualTime)/1000;
        System.out.println("  -binarySearchTree: " + bstCreationTime);

        actualTime = System.nanoTime();
        avlTree = Comparation.generateAVL(randomNumbers);
        long avlTreeCreationTime = (System.nanoTime() - actualTime)/1000;
        System.out.println("  -avlTree: " + avlTreeCreationTime);

        actualTime = System.nanoTime();
        redBlacktree = Comparation.generateRedBlackTree(randomNumbers);
        long redBlacktreeTreeCreationTime = (System.nanoTime() - actualTime)/1000;
        System.out.println("  -redBlacktree: " + redBlacktreeTreeCreationTime);
        //c)
        System.out.println("\nc) Altura de cada arbol");
        System.out.println("  -binarySearchTree: " + binarySearchTree.height(binarySearchTree));
        System.out.println("  -avlTree: " + avlTree.height(avlTree.getRoot()));
        System.out.println("  -redBlacktree: " + redBlacktree.height(redBlacktree));
        //d)
        System.out.println("\nd) Tabla con nro de intentos");
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
        long[][] datosBinarySearchTree = new long[3][10];//[i][BinarySearchTree, Avl, Blacktree][tiempo p, altura p, intentos p]
        long[][] datosAvl = new long[3][10];
        long[][] datosRedBlacktree = new long[3][10];

        for (int i = 0; i < 10; i++) {
            //a)
            randomNumbers = utils.Generator.differentRandomIntArr(1,100000, 1000);
            //b)
            actualTime = System.nanoTime();
            binarySearchTree = Comparation.generateBinarySearchTree(randomNumbers);
            datosBinarySearchTree[0][i] = System.nanoTime() - actualTime;

            actualTime = System.nanoTime();
            avlTree = Comparation.generateAVL(randomNumbers);
            datosAvl[0][i] = System.nanoTime() - actualTime;

            actualTime = System.nanoTime();
            redBlacktree = Comparation.generateRedBlackTree(randomNumbers);
            datosRedBlacktree[0][i] = System.nanoTime() - actualTime;
            //c)
            datosBinarySearchTree[1][i] = binarySearchTree.height(binarySearchTree);
            datosAvl[1][i] = avlTree.height(avlTree.getRoot());
            datosRedBlacktree[1][i] = redBlacktree.height(redBlacktree);
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
            datosBinarySearchTree[2][i] = (long)(sumaBinarySearchTree/randomSelected.length);
            datosAvl[2][i] = (long)(sumaAvl/randomSelected.length);
            datosRedBlacktree[2][i] = (long)((sumRedBlacktree/randomSelected.length));
        }
        //datos a imprimir_____________________________
        long[] promedioBinarySearchTree = new long[3];
        long[] promedioAvl = new long[3];
        long[] promedioRedBlacktree = new long[3];

        promedioBinarySearchTree[0] = Comparation.promedioDeArreglo(datosBinarySearchTree[0]);
        promedioBinarySearchTree[1] = Comparation.promedioDeArreglo(datosBinarySearchTree[1]);
        promedioBinarySearchTree[2] = Comparation.promedioDeArreglo(datosBinarySearchTree[2]);

        promedioAvl[0] = Comparation.promedioDeArreglo(datosAvl[0]);
        promedioAvl[1] = Comparation.promedioDeArreglo(datosAvl[1]);
        promedioAvl[2] = Comparation.promedioDeArreglo(datosAvl[2]);

        promedioRedBlacktree[0] = Comparation.promedioDeArreglo(datosRedBlacktree[0]);
        promedioRedBlacktree[1] = Comparation.promedioDeArreglo(datosRedBlacktree[1]);
        promedioRedBlacktree[2] = Comparation.promedioDeArreglo(datosRedBlacktree[2]);

        System.out.println("\nd) Promedios de tiempo, altura e intentos");
        System.out.println("\n[tipo de arbol]\t   | p. tiempo |  p. altura | p. intentos");
        System.out.println("---------------------------------------------------------");
        System.out.println("[BinarySearchTree] |\t" + promedioBinarySearchTree[0]/1000 + "\t   |\t " + promedioBinarySearchTree[1] + "  \t|     " +  promedioBinarySearchTree[2]);
        System.out.println("[AVL]              |\t" + promedioAvl[0]/1000 + "\t   |\t " + promedioAvl[1] + "\t|     " +  promedioAvl[2]);
        System.out.println("[RedBlacktree]     |\t" + promedioRedBlacktree[0]/1000 + "\t   |\t " + promedioRedBlacktree[1] + "  \t|     " +  promedioRedBlacktree[2]);
    }
}