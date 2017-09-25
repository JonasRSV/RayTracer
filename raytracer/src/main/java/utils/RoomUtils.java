package utils;

import java.util.ArrayList;
import java.util.Collections;

import Objects.Object;
import Objects.Vector;

/**
 * Created by jonval on 24/11/16.
 */
public class RoomUtils {

    public ArrayList<Object> sort(Vector point, ArrayList<Object> objects) {
        int sort = 1;
        while (sort != 0) {
            sort = 0;
            for (int j = 1; j < objects.size(); j++) {
                if (comparedObjects(point, objects.get(j), objects.get(j - 1))) {
                    Collections.swap(objects, j, j - 1);
                    sort++;
                    }
                }
            }
        return objects;
    }


    boolean comparedObjects(Vector point, Object one, Object two) {
        if (distance(point, one) < distance(point, two)) {
            return true;
        } else {
            return false;
        }
    }

    public double distance(Vector point, Object object) {
        double xDistance = Math.abs(point.x) - object.size.x;
        double yDistance = Math.abs(point.y) - object.size.y;
        double zDistance = Math.abs(point.z) - object.size.z;

        if (xDistance < 0) xDistance = 0;
        if (yDistance < 0) yDistance = 0;
        if (zDistance < 0) zDistance = 0;

        return point.subtract(object.objectCenter).dot(point.subtract(object.objectCenter));
    }

}
