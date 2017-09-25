package utils;

import java.util.ArrayList;

/**
 * Created by jonval on 23/11/16.
 */
public class CoordinateArray {

    public ArrayList<ImageCoordinate> imageCoordinates = new ArrayList<ImageCoordinate>();

    public CoordinateArray(int xSize, int ySize) {

        for (int y = ySize/2; y >= -ySize/2; y--) {
            for (int x = -xSize/2; x <= xSize/2; x++) {
                imageCoordinates.add(new ImageCoordinate(x + xSize/2 , y + ySize/2 ));
            }
        }
    }

}
