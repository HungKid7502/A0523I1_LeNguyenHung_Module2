package ss4_Class_and_Object_in_Java.Fan;

public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int HIGH = 3;
    private int speed = SLOW;
    private boolean ON = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isON() {
        return ON;
    }

    public void setON(boolean ON) {
        this.ON = ON;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
    }

    public Fan(int speed, boolean ON, double radius, String color) {
        this.speed = speed;
        this.ON = ON;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        if (isON())
            return "Speed is: " + getSpeed() + ", Radius is: " + getRadius() + ", Color is:  " + getColor() + ", "
                    + " fan is on";
        else
            return "Speed is: " + getSpeed() + ", Radius is: " + getRadius() + ", Color is:  " + getColor() + ", "
                    + " fan is off";
    }
}
