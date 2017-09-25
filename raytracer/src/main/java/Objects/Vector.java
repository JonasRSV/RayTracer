package Objects;

/**
 * Created by jonval on 18/11/16.
 */
public class Vector {

    public Vector origin;

    public double x;
    public double y;
    public double z;

    public Vector(double x_cord, double y_cord, double z_cord) {
        this.x = x_cord;
        this.y = y_cord;
        this.z = z_cord;
    }


    public double dot(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector crossProduct(Vector vector) {
        return new Vector(y*vector.z - z*vector.y, z*vector.x - x*vector.z, x*vector.y - y*vector.x);
    }

    public Vector add(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector subtract(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public Vector scale(double scalar) {
        return new Vector(this.x*scalar, this.y*scalar, this.z*scalar);
    }

    public void normalize() {
        double magnitued = Math.sqrt(x*x + y*y + z*z);
        x = x / magnitued;
        y = y / magnitued;
        z = z / magnitued;
    }

    public Vector project(Vector vector) {
        return vector.scale(vector.dot(this) / vector.dot(vector));
    }

    public Vector reflectPlane(Vector normal) {
        return this.subtract(this.subtract(this.project(normal)).scale(2));
    }
}
