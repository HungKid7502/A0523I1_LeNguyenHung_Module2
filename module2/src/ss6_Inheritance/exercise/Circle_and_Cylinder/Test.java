package ss6_Inheritance.exercise.Circle_and_Cylinder;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Object Circle--");
        System.out.println("Enter the radius: ");
        double radius = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the color: ");
        String color = scanner.nextLine();
        Circle circle = new Circle(radius, color);
        System.out.println(circle);
        System.out.println("Area = " + circle.getArea());

        System.out.println("--Object Cylinder--");
        System.out.println("Enter the height: ");
        double height = Double.parseDouble(scanner.nextLine());
        Cylinder cylinder = new Cylinder(radius, color, height);
        System.out.println(cylinder);
        System.out.println("Volume = " + cylinder.getVolume());
        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1);
    }
}
