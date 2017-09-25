package utils;


import Builds.Figure;
import Objects.Vector;

/**
 * Created by jonval on 23/11/16.
 */
public class Specifications {
    public ObjectSize size;
    public Vector center;
    public Figure type;
    public RBG color;


    public Specifications(Figure type, RBG color, ObjectSize size, Vector center) {
        this.size = size;
        this.center = center;
        this.type = type;
        this.color = color;
    }

    public Vector normal;

    public Specifications(Figure type, RBG color, Vector normal, Vector pointInPlane) {
        this.type = type;
        this.normal = normal;
        this.center = pointInPlane;
        this.color = color;
        this.size = new ObjectSize(Integer.MAX_VALUE);
    }
}
