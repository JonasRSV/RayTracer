package Builds;

import Objects.Plane;
import Objects.Sphere;
import Objects.Object;
import utils.Specifications;

/**
 * Created by jonval on 23/11/16.
 */
public class ObjectFactory {
    public static Object build(Specifications specifications) throws Exception {

        switch (specifications.type) {
            case SPHERE:
                return new Sphere(specifications);
            case PLANE:
                return new Plane(specifications);
            default:
                throw new Exception("No such Object");
        }
    }
}
