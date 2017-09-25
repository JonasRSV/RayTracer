package Objects;

import java.util.ArrayList;

import javax.xml.bind.ValidationException;

import utils.RoomUtils;

/**
 * Created by jonval on 18/11/16.
 */
public class Room {

    RoomUtils utils = new RoomUtils();

    double xLimit;
    double yLimit;
    double zLimit;

    public View view;
    public LightSource lightSource;

    public ArrayList<Object> objects = new ArrayList<Object>();


    public boolean bounce(Ray ray)  {

        for (Object obj : utils.sort(ray.vector.origin, objects)) {
            try {
                obj.Bounce(ray);
                return true;
            } catch (ValidationException e) {}
        }
        return false;
    }
    public Room(double dimensions) {
        this.xLimit = dimensions;
        this.yLimit = dimensions;
        this.zLimit = dimensions;
    }

}
