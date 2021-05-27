package BSTs;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree;
        AVLTree<Integer> avlTree;
        RedBlackTree<Integer> redBlacktree;

        //a)
        Integer[] randomNumbers = utils.Generator.differentRandomIntArr(1,100000, 1000);
        //b)
        long actualTime = System.currentTimeMillis();
        binarySearchTree = Comparation.generateBinarySearchTree(randomNumbers);
        long bstCreationTime = System.currentTimeMillis() - actualTime;
        System.out.println(bstCreationTime);

        actualTime = System.currentTimeMillis();
        avlTree = Comparation.generateAVL(randomNumbers);
        long avlTreeCreationTime = System.currentTimeMillis() - actualTime;
        System.out.println(avlTreeCreationTime);

        actualTime = System.currentTimeMillis();
        redBlacktree = Comparation.generateRedBlackTree(randomNumbers);
        long redBlacktreeTreeCreationTime = System.currentTimeMillis() - actualTime;
        System.out.println(redBlacktreeTreeCreationTime);
        //c
        System.out.println(binarySearchTree.height(binarySearchTree));
        System.out.println(avlTree.height(avlTree.getRoot()));
        System.out.println(redBlacktree.height(redBlacktree));
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