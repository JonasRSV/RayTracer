package Objects;

import utils.ImageCoordinate;
import utils.RBG;

/**
 * Created by jonval on 23/11/16.
 */
public class Ray {

    public Vector vector;
    public RBG color;
    public ImageCoordinate pixel;

    public Ray(Vector vector, RBG c, ImageCoordinate p) {
        this.vector = vector;
        this.color = c;
        this.pixel = p;
    }
}
