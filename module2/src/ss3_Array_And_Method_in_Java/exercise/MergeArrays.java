package ss3_Array_And_Method_in_Java.exercise;

import java.util.Scanner;
import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the first array:");
        int size1 = sc.nextInt();
        int[] array1 = new int[size1];
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Enter the element " + (i + 1) + " of the first array: ");
            array1[i] = sc.nextInt();
        }
        System.out.println("Enter the size of the second array:");
        int size2 = sc.nextInt();
        int[] array2 = new int[size2];
        for (int i = 0; i < array2.length; i++) {
            System.out.println("Enter the element " + (i + 1) + " of the second array: ");
            array2[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(array1) + "\n" + Arrays.toString(array2));
        int array3[] = new int[size1 + size2];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array3[array1.length + i] = array2[i];
        }
        System.out.println("The array after merging is: ");
        System.out.println(Arrays.toString(array3));
    }
}
