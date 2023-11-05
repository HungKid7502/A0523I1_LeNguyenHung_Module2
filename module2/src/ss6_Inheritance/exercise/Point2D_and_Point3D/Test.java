package ss6_Inheritance.exercise.Point2D_and_Point3D;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D = new Point2D(3.5f, 4.5f);
        System.out.println(point2D);

        Point3D point3D = new Point3D();
        System.out.println(point3D);
        point3D = new Point3D( 8.0f, 9.0f, 10.0f);
        System.out.println(point3D);
    }
}
