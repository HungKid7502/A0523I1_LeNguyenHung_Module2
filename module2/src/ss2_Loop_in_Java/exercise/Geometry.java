package ss2_Loop_in_Java.exercise;

import java.util.Scanner;

public class Geometry {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    printRectangle(sc);
                    break;
                }
                case 2: {
                    printTriangleBottomLeft(sc);
                    break;
                }
                case 3: {
                    printTriangleTopLeft(sc);
                    break;
                }
                case 4: {
                    System.out.println("Exit!!!");
                    break;
                }
                default : {
                    flag = false;
                    break;
                }
            }
        } while(flag);
    }

    public static void printRectangle(Scanner sc) {
        System.out.println("--Print the rectangle--");
        System.out.println("Input the height: ");
        int height = sc.nextInt();
        System.out.println("Input the width: ");
        int width = sc.nextInt();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void printTriangleBottomLeft(Scanner sc) {
        System.out.println("--Print the Triangle Bottom-Left--");
        System.out.println("Input the height: ");
        int height = sc.nextInt();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void printTriangleTopLeft(Scanner sc) {
        System.out.println("--Print the Triangle Top-Left--");
        System.out.println("Input the height: ");
        int height = sc.nextInt();
        for (int i = 1; i <= height; i++) {
            for (int j = height; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
}





