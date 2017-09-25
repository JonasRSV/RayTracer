package utils;

/**
 * Created by jonval on 24/11/16.
 */
public class ObjectSize {

    public double x;
    public double y;
    public double z;
    public double radius;

    public ObjectSize(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ObjectSize(double radius) {
        this.x = radius;
        this.y = radius;
        this.z = radius;
        this.radius = radius;
    }
}
