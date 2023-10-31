package ss3_Array_And_Method_in_Java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheSmallestValue {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size: ");
        size = sc.nextInt();
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        System.out.println(Arrays.toString(array));
        System.out.println("--Find the smallest value in array--");
        int min = array[0];
        int indexMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                indexMin = i;
                min = array[i];
            }
        }
        System.out.println("The smallest value in the array is " + min + " at index " + indexMin);
        sc.close();
    }
}
