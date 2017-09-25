package Builds;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.bind.ValidationException;

import Objects.Ray;
import Objects.Room;
import utils.CoordinateArray;
import utils.ImageCoordinate;
import utils.RBG;
import utils.Resolution;

/**
 * Created by jonval on 18/11/16.
 */


public class ImageBuilder {

    static BufferedImage image;
    static Room room;
    static Resolution resolution;


    public static void build(Resolution res, Room space) {
        image = new BufferedImage(res.x, res.y, BufferedImage.TYPE_INT_RGB);
        room = space;
        resolution = res;

        CoordinateArray array = new CoordinateArray(res.x - 1, res.y - 1);


        for (ImageCoordinate coordinate: array.imageCoordinates) {
            colorPixel(coordinate, new RBG(255, 255, 255));
        }

        try {
            File imageFile = new File("/Users/jonval/Desktop/test.png");
            ImageIO.write(image, "png", imageFile);
        } catch (IOException e) {
            System.err.println("Couldnt Make Image File :(");
        }

    }


    static void colorPixel(ImageCoordinate coordinate, RBG startColor) {
        Ray traveler = RayFactory.makeRay(offset(coordinate), startColor, room);
        Boolean bounced = false;

        int bounces = 0;
        while (bounces <= 3) {

            int currentBounces = bounces;
            if (room.bounce(traveler)) {
                bounces++;
                bounced = true;
            }
            try {
                if (room.lightSource.rayIntersectLight(traveler)) {
                    bounced = true;
                    break;
                }
            } catch (ValidationException e) {}



            if (currentBounces == bounces) {
                break;
            }
        }
        if (!bounced) {
            traveler.color = new RBG(0, 0, 0);
        }

        image.setRGB(coordinate.x, coordinate.y, traveler.color.rbg());
    }


    static ImageCoordinate offset(ImageCoordinate coordinate) {
        return new ImageCoordinate(coordinate.x - resolution.x / 2, coordinate.y - resolution.y / 2);
    }



}
