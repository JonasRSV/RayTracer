package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import Builds.Figure;
import Builds.ImageBuilder;
import Builds.LightSourceFactory;
import Builds.ObjectFactory;
import Builds.RoomFactory;
import Builds.ViewFactory;
import Objects.Vector;
import utils.ObjectSize;
import utils.RBG;
import utils.Resolution;
import utils.Specifications;

/**
 * Created by jonval on 23/11/16.
 */
public class Main {

    public static void main(String... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RoomFactory.instantiateSize(10000);
        System.out.println("Room Instantiated");
        Random rg = new Random();

        //RoomFactory.addObject(ObjectFactory.build(new Specifications(Figure.SPHERE,
        //        new RBG(255, 255, 255), new ObjectSize(400), new Vector(0, 0 ,0))));

        int balls = 0;
        int toMake = Integer.parseInt(br.readLine());
        while (toMake > balls) {
            RoomFactory.addObject(ObjectFactory.build(new Specifications(Figure.SPHERE,
                    new RBG(rg.nextInt(256), rg.nextInt(256), rg.nextInt(256)),
                    new ObjectSize(rg.nextInt(100)), new Vector(rg.nextInt(600) * (rg.nextInt(3) - 1),
                    rg.nextInt(600) * (rg.nextInt(3) - 1), rg.nextInt(600) * (rg.nextInt(3) - 1)))));
            balls++;
        }

        RoomFactory.addObject(ObjectFactory.build(new Specifications(Figure.PLANE,
                new RBG(255, 0, 0), new Vector(0, 1, 0), new Vector(0,-1000,0))));

        RoomFactory.addObject(ObjectFactory.build(new Specifications(Figure.SPHERE,
                new RBG(0, 255, 255), new ObjectSize(500), new Vector(0,0,0))));



        System.out.println("Object Added");

        RoomFactory.addLightSource(LightSourceFactory.make(10, new Vector(1000, 1000, 1000), new Vector(1, -1, -1)));

        System.out.println("Light Source Added");

        RoomFactory.addView(ViewFactory.makeViewPlane(new Vector(0, 1000, 0), new Vector(0, -1, 0), 800, new Vector(1, 0, 0)));

        System.out.println("View Added");
        ImageBuilder.build(new Resolution(2000, 2000), RoomFactory.buildRoom());
        System.out.println("Image made");
    }
}
