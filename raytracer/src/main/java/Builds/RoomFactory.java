package Builds;

import Objects.LightSource;
import Objects.View;
import Objects.Object;
import Objects.Room;
import utils.PixelPainter;


/**
 * Created by jonval on 23/11/16.
 */
public class RoomFactory {

    static Room room;

    public static void instantiateSize(int size) {
        room = new Room(size);
    }

    public static void addObject(Object object) throws Exception {
        room.objects.add(object);
    }

    public static void addView(View view) {
        room.view= view;
    }

    public static void addLightSource(LightSource source) {
        room.lightSource = source;
    }

    public static Room buildRoom() {
        PixelPainter.room = room;
        return room;
    }



}
