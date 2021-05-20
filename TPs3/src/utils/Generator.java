package utils;

import java.util.Random;

public class Generator {

    public Generator(){}
    Random r = new Random();

    public static int randomInt(int minValue, int maxValue){
       return (int) (Math.random()*(maxValue-minValue)+minValue);
    }

    public static Integer[] randomIntArr(int minValue, int maxValue, int size){
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = randomInt(minValue, maxValue);
        }
        return arr;
    }

    public static Integer[] chooseRandomNumbers(Integer[] arr, int quant){
        Integer[] newArr = new Integer[quant];
        for (int i = 0; i < quant; i++) {
            newArr[i] = arr[randomInt(0, arr.length)];
        }
        return newArr;
    }
}
