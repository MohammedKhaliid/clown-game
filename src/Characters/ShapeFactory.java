package Characters;

import java.util.Random;

public class ShapeFactory {
    private static final int WINDOW_WIDTH = 800;
    public static Shape createShape(int type, int level) {
        Shape shape;
        Random randomizer = new Random();

//      int shapeType = randomizer.nextInt(100);

        if (type == 0) {
            int color = randomizer.nextInt(Mushroom.COLORS_COUNT);
            shape = new Mushroom(randomizer.nextInt(WINDOW_WIDTH), -randomizer.nextInt(1000), color);
        } else if (type == 1) {
            shape = new Coin(randomizer.nextInt(WINDOW_WIDTH), -randomizer.nextInt(WINDOW_WIDTH/4));
        } else if (type == 2){
            int vType = randomizer.nextInt(level);
            shape = new Villain(randomizer.nextInt(WINDOW_WIDTH), 0, vType);
        }
        else {
            shape = new Plate(400, 0, "/Plate.png");
        }

        return shape;
    }
}
