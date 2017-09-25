package Builds;

import java.lang.reflect.Type;

import Objects.LightSource;
import Objects.Plane;
import Objects.Vector;
import utils.RBG;
import utils.Specifications;

/**
 * Created by jonval on 23/11/16.
 */
public class LightSourceFactory {

    public static LightSource make(double size, Vector centerPoint, Vector direction) {
        Plane lightPlane = new Plane(new Specifications(Figure.PLANE, new RBG(255, 255, 255), direction, centerPoint));
        return new LightSource(lightPlane, centerPoint, size);
    }
}
