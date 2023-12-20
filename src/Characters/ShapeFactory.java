package Characters;

import java.util.Random;

public class ShapeFactory {
    private static final int WINDOW_WIDTH = 800;
    public static Shape createShape(int level) {
        Shape shape;
        Random randomizer = new Random();

        int shapeType = randomizer.nextInt(3);

        if (shapeType == 0) {
            shape = new Mushroom(randomizer.nextInt(WINDOW_WIDTH), 0, 60, 60, randomizer.nextInt(Mushroom.COLORS_COUNT));
        } else if (shapeType == 1) {
            shape = new Coin(randomizer.nextInt(WINDOW_WIDTH), 0, 60, 60);
        } else {
            shape = new Villain(randomizer.nextInt(WINDOW_WIDTH), 0, 60, 60, level);
        }

        return shape;
    }
}
