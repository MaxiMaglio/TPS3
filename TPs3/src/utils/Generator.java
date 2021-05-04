package utils;

import java.util.Random;

public class Generator {

    public Generator(){}
    Random r = new Random();

    public int randomInt(int minValue, int maxValue){
       return (int) (Math.random()*(maxValue-minValue)+minValue);
    }

    public int[] randomIntArr(int minValue, int maxValue, int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = randomInt(minValue,maxValue);
        }
        return arr;
    }
}
