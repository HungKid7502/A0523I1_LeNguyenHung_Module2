package ss3_Array_And_Method_in_Java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter the size: ");
            size = sc.nextInt();
            if (size > 10)
                System.out.println("Size does not exceed 10");
        } while (size > 10);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        System.out.println(Arrays.toString(array));
        int indexAdd;
        do {
            System.out.println("Enter position to be additional: ");
            indexAdd = sc.nextInt();
        } while (indexAdd <= -1 || indexAdd > array.length - 1);
        System.out.println("Enter element to be additional");
        int elementAdd = sc.nextInt();
        for (int i = array.length - 1; i > indexAdd; i--) {
            array[i] = array[i - 1];
        }
        array[indexAdd] = elementAdd;
        System.out.printf("%-20s%s", "Element in array after additional: ", "");
        System.out.println(Arrays.toString(array));
        sc.close();
    }
}
