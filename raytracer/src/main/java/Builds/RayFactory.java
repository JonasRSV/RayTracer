package Builds;

import Objects.Ray;
import Objects.Room;
import Objects.Vector;
import utils.ImageCoordinate;
import utils.RBG;

/**
 * Created by jonval on 23/11/16.
 */
public class RayFactory {

    public static Ray makeRay(ImageCoordinate pixel, RBG color, Room room) {
        Vector rayVector = room.view.coordinatesToVector(pixel);
        rayVector.origin = room.view.viewOrigin;

        rayVector.normalize();

        return new Ray(rayVector, color, pixel);
    }

}
