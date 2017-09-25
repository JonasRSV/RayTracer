package Objects;

import javax.xml.bind.ValidationException;

/**
 * Created by jonval on 18/11/16.
 */
public class LightSource {

    public Plane plane;
    public Vector center;
    public double radius;

    public LightSource(Plane p, Vector planeCenter, double radius) {
        this.plane = p;
        this.center = planeCenter;
        this.radius = radius;
    }

    public Boolean rayIntersectLight(Ray lightRay) throws ValidationException {
        Vector planeIntersect = plane.planeVectorIntersect(lightRay.vector.origin, lightRay.vector);

        return radius*radius >= ((center.x - planeIntersect.x) * (center.x - planeIntersect.x) +
                (center.y - planeIntersect.y) * (center.y - planeIntersect.y) +
                (center.z - planeIntersect.z) * (center.z - planeIntersect.z));


    }
}
