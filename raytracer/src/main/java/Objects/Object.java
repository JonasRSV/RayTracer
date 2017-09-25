package Objects;

import javax.xml.bind.ValidationException;

import Builds.Figure;
import utils.ObjectSize;

/**
 * Created by jonval on 23/11/16.
 */
public abstract class Object {

    public Figure type;
    public Vector objectCenter;
    public ObjectSize size;

    public Object(Figure t, Vector objectCenter, ObjectSize size) {
        this.type = t;
        this.objectCenter = objectCenter;
        this.size = size;
    }

    public abstract void Bounce(Ray ray) throws ValidationException;
}
