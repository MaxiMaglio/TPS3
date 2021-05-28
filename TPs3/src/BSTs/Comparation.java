package BSTs;

import utils.Generator;

public class Comparation {
    BinarySearchTree<Integer> binarySearchTree;
    AVLTree<Integer> avlTree;
    RedBlackTree<Integer> redBlacktree;

    public void main(String[] args) {

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
            avlAttemps[i] = avlTree.getLevel(avlTree.getRoot(), randomSelected[i]);
            bstAttemps[i] = binarySearchTree.getLevel(binarySearchTree.getRoot(), randomSelected[i]);
            rbtAttemps[i] = redBlacktree.getLevel(redBlacktree.getRoot(), randomSelected[i]);
        }

    }



    public static AVLTree<Integer> generateAVL(Integer[] array){
        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < array.length; i++) {
            avl.insert(array[i]);
        }
        return avl;
    }

    public long avlTreeCreationTime (AVLTree<Integer> avlTree, Integer[] randomNumbers){
        long actualTime = System.currentTimeMillis();
        this.generateAVL(randomNumbers);
        return System.currentTimeMillis() - actualTime;
    }

    public static BinarySearchTree<Integer> generateBinarySearchTree(Integer[] array){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        return binarySearchTree;
    }

    public long bstCreationTime (BinarySearchTree<Integer> binarySearchTree, Integer[] randomNumbers){
        long actualTime = System.currentTimeMillis();
        this.generateRedBlackTree(randomNumbers);
        return System.currentTimeMillis() - actualTime;
    }

    public static RedBlackTree<Integer> generateRedBlackTree(Integer[] array){
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        for (int i = 0; i < array.length; i++) {
            redBlackTree.insert(array[i]);
        }
        return redBlackTree;
    }

    public long redBlacktreeTreeCreationTime (RedBlackTree<Integer> redBlacktree, Integer[] randomNumbers){
        long actualTime = System.currentTimeMillis();
        this.generateRedBlackTree(randomNumbers);
        return System.currentTimeMillis() - actualTime;
    }

    public static Integer[][] treesAttemps(Integer[] randomSelected, BinarySearchTree<Integer> binarySearchTree, AVLTree<Integer> avlTree,RedBlackTree<Integer> redBlacktree){
        Integer[] avlAttemps = new Integer[10];
        Integer[] bstAttemps = new Integer[10];
        Integer[] rbtAttemps = new Integer[10];
        for (int i = 0; i < randomSelected.length; i++) {
            avlAttemps[i] = avlTree.getLevel(avlTree.getRoot(), randomSelected[i]);
            bstAttemps[i] = binarySearchTree.getLevel(binarySearchTree.getRoot(), randomSelected[i]);
            rbtAttemps[i] = redBlacktree.getLevel(redBlacktree.getRoot(), randomSelected[i]);
        }
        return new Integer[][]{bstAttemps, avlAttemps, rbtAttemps};
    }

    public static long promedioDeArreglo(long[] arr){
        int suma = 0;
        for (int i = 0; i < arr.length; i++) {
            suma += arr[i];
        }
        return suma/arr.length;
    }

}
