package ss1_Introduction_to_Java.exercise;

import java.util.Scanner;

public class Hello {
    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        sc.close();
        System.out.println("Hello " + name);
    }
}
