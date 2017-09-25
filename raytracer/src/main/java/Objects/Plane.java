package Objects;

import javax.xml.bind.ValidationException;

import Builds.Figure;
import utils.PixelPainter;
import utils.RBG;
import utils.Specifications;

/**
 * Created by jonval on 18/11/16.
 */
public class Plane extends Object {

    public Vector normal;
    Vector pointInPlane;
    public RBG color;

    double xCoefficient;
    double yCoefficient;
    double zCoefficient;
    double constant;


    public Plane(Specifications specifications) {
        super(specifications.type, specifications.center, specifications.size);
        this.normal = specifications.normal;
        this.pointInPlane = specifications.center;
        this.color = specifications.color;
        setPlane();
    }

    public void setPlane() {
        xCoefficient = normal.x;
        yCoefficient = normal.y;
        zCoefficient = normal.z;
        constant = (-(normal.x * pointInPlane.x) -
                (normal.y * pointInPlane.y ) -
                (normal.z * pointInPlane.z)) * -1;
    }

    public Vector planeVectorIntersect(Vector start, Vector direction) throws ValidationException {
        double scalar = (constant - xCoefficient*start.x - yCoefficient*start.y - zCoefficient*start.z)/
                (xCoefficient*direction.x + yCoefficient*direction.y + zCoefficient*direction.z);

        if (scalar < 0) throw new ValidationException("Does not Hit Plane");
        return start.add(direction.scale(scalar));
    }

    public void Bounce(Ray ray) throws  ValidationException {
        try {
            Vector intersect = planeVectorIntersect(ray.vector.origin, ray.vector);
            Vector reflection = ray.vector.reflectPlane(this.normal);
            ray.color = PixelPainter.paint(ray.vector, reflection, this.color, ray.color, Figure.PLANE);
            ray.vector = reflection.scale(-1);
            ray.vector.origin = intersect;
        } catch (ValidationException e) {
            throw new ValidationException(e);
        }
    }


}
