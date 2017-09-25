package Builds;

import Objects.View;
import Objects.Vector;

public class ViewFactory {

    public static View makeViewPlane(Vector viewPoint, Vector direction, double distance, Vector axis) {
        View view = new View(direction, viewPoint);
        view.setRelativePlane(viewPoint.add(direction.scale(distance)), axis);
        return view;
    }
}
