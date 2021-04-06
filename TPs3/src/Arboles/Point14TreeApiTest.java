package Arboles;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Point14TreeApiTest<T> {

    TreeApi<T> ita= new TreeApi<T>();

    BinaryTree<Integer> tree = new BinaryTree<>( 15);
    BinaryTree<Integer> t2 = new BinaryTree<>(10);
    BinaryTree<Integer> t3 = new BinaryTree<>(30,tree,t2);
    BinaryTree<Integer> t4 = new BinaryTree<>(5,t3,t2);
    BinaryTree<Integer> t19 = new BinaryTree<>(90);
    BinaryTree<Integer> t20 = new BinaryTree<>(5,t3,t19);
    BinaryTree<Integer> t5 = new BinaryTree<>(1,t4,t4);
    BinaryTree<Integer> t6 = new BinaryTree<>(30,t2,tree);
    BinaryTree<Integer> t7 = new BinaryTree<>(8,tree,t2);
    BinaryTree<Integer> t8 = new BinaryTree<>(100,t3,t3);
    BinaryTree<Integer> t9 = new BinaryTree<>(5,t2, new BinaryTree<>());
    BinaryTree<Integer> t10 = new BinaryTree<>(1,t4,t9);
    BinaryTree<Integer> t11 = new BinaryTree<>(300,t8, new BinaryTree<>());
    BinaryTree<Integer> t12 = new BinaryTree<>(4,t3,t3);
    BinaryTree<Integer> t13 = new BinaryTree<>(300,t8, new BinaryTree<>());
    BinaryTree<Integer> t15 = new BinaryTree<>(54);
    BinaryTree<Integer> t16 = new BinaryTree<>(98);
    BinaryTree<Integer> t14 = new BinaryTree<>(31,t15,t16);


    Book l1 = new Book(12, "Hamlet", 230);
    Book l2 = new Book(25, "Muerte en las nubes", 321);
    Book l3 = new Book(22, "El precio de la intriga", 530);
    Book l4 = new Book(75, "Romeo y Julieta", 199);
    Book l5 = new Book(56, "La isla del tesoro", 452);
    Book l6 = new Book(64, "El anillo", 520);
    Book l7 = new Book(44, "El doctor Zhivago", 930);

    TreeApi<Book> a = new TreeApi<Book>();
    BinaryTree <Book>    t53 = new BinaryTree<Book>(l7);
    BinaryTree <Book>    t22 = new BinaryTree<Book>(l5);
    BinaryTree <Book>    t33 = new BinaryTree<>(l6,t53,new BinaryTree<Book>());
    BinaryTree <Book>    t44 = new BinaryTree<Book>( l4, t33,t22);
    BinaryTree <Book>    t55 = new BinaryTree<Book>(l2,t44,new BinaryTree<Book>());
    BinaryTree <Book>    t66 = new BinaryTree<Book>(l3,new BinaryTree<Book>(),t22);
    BinaryTree <Book>    t77 = new BinaryTree<Book>(l1,t55,t66);

    @Test
    public void sum(){
        int sum = ita.sum(t5);
        Assert.assertEquals(141,sum);
    }

    @Test
    public void sumOfMultipleof3(){
        int sum = ita.sumOfMultiplesOf3(t5);
        Assert.assertEquals(90,sum);

    }

    @Test
    public void equalsShouldReturnTrue(){
        boolean equals = ita.iguales(t77,t77);
        Assert.assertTrue(equals);
    }

    @Test
    public void equalsShouldReturnFalse(){
        boolean equals = ita.iguales(t77,t44);
        Assert.assertFalse(equals);
    }

    @Test
    public void isomorfosShouldReturnTrue(){
        boolean equals = ita.isomorfos(t3,t6);
        Assert.assertTrue(equals);
    }

    @Test
    public void isomorfosShouldReturnFalse(){
        boolean isomorfos = ita.isomorfos(t4,t5);
        Assert.assertFalse(isomorfos);
    }

    @Test
    public void semejantesShouldReturnTrue(){
        boolean semejantes = ita.semejantesSinRepetidos(t3,t6);
        Assert.assertTrue(semejantes);
    }

    @Test
    public void semejantesShouldReturnFalse(){
        boolean semejantes = ita.semejantesSinRepetidos(t3,t7);
        Assert.assertFalse(semejantes);
    }

    @Test
    public void isCompletoShouldReturnTrue(){
        boolean isCompleto = ita.isCompleto(t8);
        Assert.assertTrue(isCompleto);
    }

    @Test
    public void isCompletoShouldReturnFalse(){
        boolean isCompleto = ita.isCompleto(t10);
        Assert.assertFalse(isCompleto);
    }

    @Test
    public void isFullShouldReturnTrue(){
        boolean isFull = ita.isFull(t8);
        Assert.assertTrue(isFull);
    }

    @Test
    public void isFullShouldReturnFalse(){
        boolean isFull = ita.isFull(t5);
        Assert.assertFalse(isFull);
    }

    @Test
    public void isStableShouldReturnTrue(){
        boolean isStable = ita.isStable(t8);
        Assert.assertTrue(isStable);
    }

    @Test
    public void isStableShouldReturnFalse(){
        boolean isStable = ita.isStable(t4);
    }

    @Test
    public void isStableShouldReturnTrueWithNullNodes(){
        boolean isStable = ita.isStable(t11);
        Assert.assertTrue(isStable);
    }

    @Test
    public void isStableShouldReturnFalseWithNullNodes(){
        boolean isStable = ita.isStable(t13);
    }

    @Test
    public void includesShouldReturnTrue(){
        boolean includes = ita.includes(t3,t20);
        Assert.assertTrue(includes);
    }

    @Test
    public void includesShouldReturnFalse(){
        boolean includes = ita.includes(t14,t8);
        Assert.assertFalse(includes);
    }

    @Test
    public void borderDisplayedCorrectly(){
        ita.displayBorder(t20);
    }

    @Test
    public void borderArrayedCorrectly(){
        ArrayList<T> arr = ita.arrayListBorder(t20, new ArrayList<>());
        System.out.println(arr);
    }

}