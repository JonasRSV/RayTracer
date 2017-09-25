package Objects;

import javax.xml.bind.ValidationException;

import Builds.Figure;
import utils.PixelPainter;
import utils.RBG;
import utils.Specifications;

/**
 * Created by jonval on 18/11/16.
 */

public class Sphere extends Object{

    public RBG rbg;
    public Vector sphereCenter;
    double radius;

    public Sphere(Specifications specifications) {
        super(Figure.SPHERE, specifications.center, specifications.size);
        this.sphereCenter = specifications.center;
        this.radius = specifications.size.radius;
        this.rbg = specifications.color;
    }

    public void Bounce(Ray ray) throws ValidationException {


        double scalarOne = (-(ray.vector.dot(ray.vector.origin.subtract(sphereCenter)))
                + Math.sqrt(ray.vector.dot(ray.vector.origin.subtract(sphereCenter))
                * ray.vector.dot(ray.vector.origin.subtract(sphereCenter))
                - ray.vector.dot(ray.vector)
                * ((ray.vector.origin.subtract(sphereCenter)).dot(ray.vector.origin.subtract(sphereCenter))
                - this.radius * this.radius)))
                /ray.vector.dot(ray.vector);

        double scalarTwo = (-(ray.vector.dot(ray.vector.origin.subtract(sphereCenter)))
                - Math.sqrt(ray.vector.dot(ray.vector.origin.subtract(sphereCenter))
                * ray.vector.dot(ray.vector.origin.subtract(sphereCenter))
                - ray.vector.dot(ray.vector)
                * ((ray.vector.origin.subtract(sphereCenter)).dot(ray.vector.origin.subtract(sphereCenter))
                - this.radius * this.radius)))
                /ray.vector.dot(ray.vector);


        if (scalarOne < 0 || scalarTwo < 0 || Double.isNaN(scalarOne) || Double.isNaN(scalarTwo)) {
            throw new ValidationException("Does not Intersect");
        }

        Vector intersect;
        if (scalarOne <= scalarTwo) {
            intersect = ray.vector.scale(scalarOne).add(ray.vector.origin);
        } else {
            intersect = ray.vector.scale(scalarTwo).add(ray.vector.origin);
        }


        Vector reflection = ray.vector.reflectPlane(intersect.subtract(sphereCenter));

        ray.color = PixelPainter.paint(ray.vector, reflection, this.rbg, ray.color, Figure.SPHERE);
        ray.vector = reflection.scale(-1);
        ray.vector.origin = intersect;
    }
}
