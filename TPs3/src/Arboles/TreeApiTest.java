package Arboles;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeApiTest {

    Book l1 = new Book(12, "Hamlet", 230);
    Book l2 = new Book(25, "Muerte en las nubes", 321);
    Book l3 = new Book(22, "El precio de la intriga", 530);
    Book l4 = new Book(75, "Romeo y Julieta", 199);
    Book l5 = new Book(56, "La isla del tesoro", 452);
    Book l6 = new Book(64, "El anillo", 520);
    Book l7 = new Book(44, "El doctor Zhivago", 930);

    TreeApi<Book> a = new TreeApi<Book>();
    BinaryTree <Book>    t1 = new BinaryTree<Book>(l7);
    BinaryTree <Book>    t2 = new BinaryTree<Book>(l5);
    BinaryTree <Book>    t3 = new BinaryTree(l6,t1,new BinaryTree<Book>());
    BinaryTree <Book>    t4 = new BinaryTree<Book>( l4, t3,t2);
    BinaryTree <Book>    t5 = new BinaryTree<Book>(l2,t4,new BinaryTree<Book>());
    BinaryTree <Book>    t6 = new BinaryTree<Book>(l3,new BinaryTree<Book>(),t2);
    BinaryTree <Book>    t7 = new BinaryTree<Book>(l1,t5,t6);


    @Test
    public void size() {
    }

    @Test
    public void leafCount() {
    }

    @Test
    public void completeNodesQuantity() {
    }

    @Test
    public void ocurrencias() {
    }

    @Test
    public void inorden() {
    }

    @Test
    public void testInorden() {
    }

    /*@Test
    public void elementosPorNivel() {
        int elementosPorNivel = a.elementosPorNivel(t7,3);
        Assert.assertEquals(2,elementosPorNivel);

    }*/
    @Test
    public void height(){
        int height = a.height(t7);
        Assert.assertEquals(4,height);
    }

    @Test
    public void emptyTreeHeightReturnsZero(){
        BinaryTree tree = new BinaryTree(null);
        int height = a.height(tree);
        Assert.assertEquals(0,height);
    }
}