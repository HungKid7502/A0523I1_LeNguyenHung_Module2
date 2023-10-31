package ss4_Class_and_Object_in_Java.QuadraticEquation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
        do {
            System.out.println("Enter coefficient a (a != 0): ");
            a = Double.parseDouble(sc.nextLine());
        } while (a == 0);
        System.out.println("Enter coefficient b: ");
        double b = Double.parseDouble(sc.nextLine());
        System.out.println("Enter coefficient c: ");
        double c = Double.parseDouble(sc.nextLine());
        sc.close();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The equation has one root is x = " + quadraticEquation.getRoot3());
        } else {
            System.out.println("The equation has two roots is x1 = " + quadraticEquation.getRoot1()
                    + " and x2 = " + quadraticEquation.getRoot2());
        }
    }
}
