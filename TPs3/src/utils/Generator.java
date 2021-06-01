package utils;

import java.util.Random;

public class Generator {

    public Generator() {
    }

    Random r = new Random();

    public static int randomInt(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue) + minValue);
    }

    public static Integer[] randomIntArr(int minValue, int maxValue, int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = randomInt(minValue, maxValue);
        }
        return arr;
    }

    public static Integer[] differentRandomIntArr(int minValue, int maxValue, int size){

        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = randomInt(minValue,maxValue);//note, this generates numbers from [0,9]

            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    i--; //if a[i] is a duplicate of a[j], then run the outer loop on i again
                    break;
                }
            }
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

    public String generateString(int stringLength) { //Creates a random codeName
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int length = stringLength; //string length
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString().toUpperCase();
    }

}
