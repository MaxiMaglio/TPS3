package utils;

import org.junit.Test;
import  org.junit.Assert.*;

public class GeneratorTest {

    Generator g = new Generator();

    @Test
    public void randomIntTester() {
        for (int i = 0; i < 100; i++) {
            int j = g.randomInt(-5, 5);
            System.out.println(j);
        }
    }

    @Test
    public void randomArrTester(){
        Integer[] arr = g.randomIntArr(1,100000,1000);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(arr.length);
    }
}