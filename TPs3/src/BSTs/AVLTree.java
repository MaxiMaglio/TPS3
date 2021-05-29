package BSTs;


import Arboles.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T> {

    AVLNode root;

    public AVLTree(){
        root = null;
    }

    public AVLTree(Comparable<T> o){
        root = new AVLNode(o);
    }
    // A utility function to get the height of the tree
    int height(AVLNode N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of AVLNode N
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    AVLNode insert(AVLNode AVLNode, Comparable<T> key) {

        /* 1.  Perform the normal BST insertion */
        if (AVLNode == null)
            return (new AVLNode(key));

        if (AVLNode.key.compareTo(key)>0)
            AVLNode.left = insert(AVLNode.left, key);
        else if (AVLNode.key.compareTo(key)<0)
            AVLNode.right = insert(AVLNode.right, key);
        else // Duplicate keys not allowed
            return AVLNode;

        /* 2. Update height of this ancestor AVLNode */
        AVLNode.height = 1 + max(height(AVLNode.left),
                height(AVLNode.right));

        /* 3. Get the balance factor of this ancestor
              AVLNode to check whether this AVLNode became
              unbalanced */
        int balance = getBalance(AVLNode);

        // If this AVLNode becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && AVLNode.left.key.compareTo(key)>0)
            return rightRotate(AVLNode);

        // Right Right Case
        if (balance < -1 && AVLNode.right.key.compareTo(key)<0)
            return leftRotate(AVLNode);

        // Left Right Case
        if (balance > 1 && AVLNode.left.key.compareTo(key)<0) {
            AVLNode.left = leftRotate(AVLNode.left);
            return rightRotate(AVLNode);
        }

        // Right Left Case
        if (balance < -1 && AVLNode.right.key.compareTo(key)>0) {
            AVLNode.right = rightRotate(AVLNode.right);
            return leftRotate(AVLNode);
        }

        /* return the (unchanged) AVLNode pointer */
        return AVLNode;
    }

    // The function also prints height of every AVLNode
    void preOrder(AVLNode AVLNode) {
        if (AVLNode != null) {
            System.out.print(AVLNode.key + " ");
            preOrder(AVLNode.left);
            preOrder(AVLNode.right);
        }
    }

    public void inOrder(AVLNode a) {
        if (a != null) {
            inOrder(a.left);
            System.out.print(a.key + " ");
            inOrder(a.right);
        }
    }

    public void postOrder(AVLNode a){
        if (a != null){
            postOrder(a.left);
            postOrder(a.right);
            System.out.print(a.key + " ");
        }
    }

    public int getLevelUtil(AVLNode node, Comparable<T> data, int level) {
        if (node == null)
            return 0;

        if (node.key.compareTo(data)==0)
            return level;

        int downlevel = getLevelUtil(node.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevelUtil(node.right, data, level + 1);
        return downlevel;
    }

    /* Returns level of given data value */
    int getLevel(AVLNode node, Comparable<T> data)
    {
        return getLevelUtil(node, data, 1);
    }

    public int weight(AVLNode<T> a) {
        if (a == null) {
            return 0;
        } else return 1 + weight(a.left) + weight(a.right);
    }

}

