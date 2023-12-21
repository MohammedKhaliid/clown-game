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
            shape = new Mushroom(randomizer.nextInt(WINDOW_WIDTH), 0, color);
        } else if (type == 1) {
            shape = new Coin(randomizer.nextInt(WINDOW_WIDTH), 0);
        } else {
            int vType = randomizer.nextInt(level);
            shape = new Villain(randomizer.nextInt(WINDOW_WIDTH), 0, vType);
        }

        return shape;
    }
}
