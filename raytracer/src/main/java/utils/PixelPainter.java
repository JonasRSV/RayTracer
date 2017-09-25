package utils;

import Builds.Figure;
import Objects.Room;
import Objects.Vector;

/**
 * Created by jonval on 23/11/16.
 */
public class PixelPainter {

    public static  Room room;

    public static RBG paint(Vector original, Vector reflection, RBG color, RBG rayColor, Figure type) {


        //Change code here to make stuff Look really Funny

        if (type.equals(Figure.SPHERE)) {
            rayColor.red = color.red;
            rayColor.blue = color.blue;
            rayColor.green = color.green;
        }
        rayColor.painted = true;
        shade(rayColor, reflection);
        return rayColor;

    }

    public static void shade(RBG color, Vector reflection) {

       color.dim((reflection.dot(room.lightSource.plane.normal)
           /(Math.sqrt(reflection.dot(reflection))
                * Math.sqrt(room.lightSource.plane.normal.dot(room.lightSource.plane.normal))))/2 + 0.5);
    }


}
