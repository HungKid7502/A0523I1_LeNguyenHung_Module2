package ss3_Array_And_Method_in_Java.exercise;
import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
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
        int indexDel;
        int elementDel;
        System.out.println("Enter the element you want to delete: ");
        elementDel = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementDel) {
                indexDel = i;
                System.out.println("The element at index " + indexDel);
                for (int j = indexDel; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
            }
        }
        System.out.println("Array after delete:");
        System.out.println(Arrays.toString(array));
        sc.close();
    }
}
