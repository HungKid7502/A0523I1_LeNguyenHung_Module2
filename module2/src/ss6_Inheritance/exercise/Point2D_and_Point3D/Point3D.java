package ss6_Inheritance.exercise.Point2D_and_Point3D;

public class Point3D extends Point2D{
    private float z= 0.0f;

    public Point3D() {
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] XYZ = new float[3];
        XYZ[0] = this.getX();
        XYZ[1] = this.getX();
        XYZ[2] = this.getX();
        return XYZ;
    }

    @Override
    public String toString() {
        return super.toString() + " z = " + getZ();
    }
}
