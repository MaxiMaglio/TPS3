package BSTs;

import utils.Generator;

public class Comparation {
    BinarySearchTree<Integer> binarySearchTree;
    AVLTree<Integer> avlTree;
    RedBlackTree<Integer> redBlacktree;

    public void main(String[] args) {
        Integer[] randomNumbers = utils.Generator.randomIntArr(1,100000, 1000);

        long actualTime = System.currentTimeMillis();
        avlTree = this.generateAVL(randomNumbers);
        long avlTreeCreationTime = System.currentTimeMillis() - actualTime;

        actualTime = System.currentTimeMillis();
        binarySearchTree = this.generateBinarySearchTree(randomNumbers);
        long bstCreationTime = System.currentTimeMillis() - actualTime;

        actualTime = System.currentTimeMillis();
        redBlacktree = this.generateRedBlackTree(randomNumbers);
        long redBlacktreeTreeCreationTime = System.currentTimeMillis() - actualTime;

        int avlTreeHeight = avlTree.height();
        int binarySearchTreeHeight = binarySearchTree.height(binarySearchTree);
        int redBlacktreeTreeHeight = redBlacktree.height(redBlacktree);

        Integer[] randomSelected = Generator.chooseRandomNumbers(randomNumbers, 10);
        int[] avlAttemps = new int[10];
        int[] bstAttemps = new int[10];
        int[] rbtAttemps = new int[10];
        for (int i = 0; i < randomSelected.length; i++) {
            avlAttemps[i] = 1;
            bstAttemps[i] = 1;
            rbtAttemps[i] = 1;
        }

    }

    private AVLTree<Integer> generateAVL(Integer[] array){
        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < array.length; i++) {
            avl.insert(array[i]);
        }
        return avl;
    }

    public BinarySearchTree<Integer> generateBinarySearchTree(Integer[] array){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        return binarySearchTree;
    }

    public RedBlackTree<Integer> generateRedBlackTree(Integer[] array){
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        for (int i = 0; i < array.length; i++) {
            redBlackTree.insert(array[i]);
        }
        return redBlackTree;
    }
}
