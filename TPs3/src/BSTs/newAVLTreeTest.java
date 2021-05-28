package BSTs;

import org.junit.Test;

import static org.junit.Assert.*;


public class newAVLTreeTest {
    newAVLTree tree = new newAVLTree();
    @Test
    public void insert() {
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 33);
        tree.root = tree.insert(tree.root, 44);
        tree.root = tree.insert(tree.root, 55);
        tree.root = tree.insert(tree.root, 66);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 4);

        System.out.println("Preorder: ");
        tree.preOrder(tree.root);
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("Inorder:");
        tree.inOrder(tree.root);

    }


}