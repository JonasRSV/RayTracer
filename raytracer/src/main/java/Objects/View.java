package Objects;

import utils.ImageCoordinate;

/**
 * Created by jonval on 23/11/16.
 */
public class View {

    public Vector viewOrigin;

    Vector relativeOrigo;
    Vector relativeX;
    Vector relativeY;

    Vector viewDirection;

    public View(Vector normal, Vector viewOrigin) {
        this.viewDirection = normal;
        this.viewOrigin = viewOrigin;
    }

    public void setRelativePlane(Vector planeCenter, Vector axis) {
        relativeOrigo = planeCenter;
        relativeX = axis;
        relativeY = viewDirection.crossProduct(relativeX);
    }

    public ImageCoordinate transformCoordinates(Vector point, Vector viewPoint) {
        ImageCoordinate ic = new ImageCoordinate(0, 0);
        ic.x = (int)(viewPoint.subtract(relativeOrigo).dot(point.subtract(viewPoint).crossProduct(relativeY))
                / relativeX.dot(point.subtract(viewPoint).crossProduct(relativeY)));

        ic.y = (int)(viewPoint.subtract(relativeOrigo).dot(point.subtract(viewPoint).crossProduct(relativeX))
                /relativeY.dot(point.subtract(viewPoint).crossProduct(relativeX)));

        return ic;
    }

    public Vector coordinatesToVector(ImageCoordinate coordinates) {
        return (relativeOrigo.add(relativeX.scale(coordinates.x)).add(relativeY.scale(coordinates.y))).subtract(viewOrigin);
    }
}
