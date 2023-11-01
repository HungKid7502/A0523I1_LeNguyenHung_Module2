package ss5_Access_Modifier.Acess_Modifier;

public class TestCircle {
    public static void main(String[] args) {
//        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);
        System.out.println("--Circle--");
        System.out.println("Radius = " + circle2.getRadius() + ", Area = " + circle2.getArea() +
                ", Color is " + circle2.getColor());
    }
}
