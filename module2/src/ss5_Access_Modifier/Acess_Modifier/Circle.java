package ss5_Access_Modifier.Acess_Modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    private final double PI = 3.14;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return PI * Math.pow(radius, 2);
    }
}
