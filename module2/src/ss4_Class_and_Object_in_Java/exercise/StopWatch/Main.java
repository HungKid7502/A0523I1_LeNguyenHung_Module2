package ss4_Class_and_Object_in_Java.exercise.StopWatch;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        StopWatch stopWatch = new StopWatch();
        long start = stopWatch.start();
        selectionSort(array);
        long end = stopWatch.stop();
        System.out.println("The time is: " + stopWatch.getElapsedTime(start, end) + " milliseconds");
    }

    public static void selectionSort(int[] arr) {
        int currentNum, tempIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            currentNum = arr[i];
            tempIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[tempIndex]) {
                    tempIndex = j;
                }
            }
            arr[i] = arr[tempIndex];
            arr[tempIndex] = currentNum;
        }
    }
}

