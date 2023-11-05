package ss6_Inheritance.exercise.Point2D_and_Point3D;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;
    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] XY = new float[2];
        XY[0] = this.getX();
        XY[1] = this.getY();
        return XY;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + getX() + " y = " + getY();
    }
}
