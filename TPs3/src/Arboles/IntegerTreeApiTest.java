package Arboles;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerTreeApiTest {
    IntegerTreeApi ita= new IntegerTreeApi();
    BinaryTree<Integer> tree = new BinaryTree<>(15);
    BinaryTree<Integer> t2 = new BinaryTree<>(10);
    BinaryTree<Integer> t3 = new BinaryTree<>(30,tree,t2);
    BinaryTree<Integer> t4 = new BinaryTree<>(5,t3,t2);
    BinaryTree<Integer> t5 = new BinaryTree<>(1,t4,t4);

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



}