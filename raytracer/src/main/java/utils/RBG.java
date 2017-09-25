package utils;

import java.awt.*;

/**
 * Created by jonval on 18/11/16.
 */
public class RBG {

    public int red;
    public int blue;
    public int green;

    boolean painted = false;

    public RBG(int r, int b, int g) {
        this.red = r;
        this.blue = b;
        this.green = g;
    }

    public void dim(double percentage) {
        red = (int) (red * percentage);
        blue = (int) (blue * percentage);
        green = (int) (green * percentage);

        if (red > 255) red = 255;
        if (blue > 255) blue = 255;
        if (green > 255) green = 255;

    }

    public void dimGreen(double percentage) {
        green = (int) (green * percentage);
        if (green > 255) green = 255;
    }

    public void dimBlue(double percentage) {
        blue = (int) (blue * percentage);
        if (blue > 255) blue = 255;
    }

    public void dimRed(double percentage) {
        red = (int) (red * percentage);
        if (red > 255) red = 255;
    }

    public int rbg() {
        return (new Color(red, green, blue)).getRGB();
    }

    public RBG mean(RBG rbg) {
        return new RBG((this.red + rbg.red)/2, (this.blue + rbg.blue)/2, (this.green + rbg.green)/2);
    }

}
