package Characters;

import Games.Game;

import java.util.Random;

public class ShapeFactory {
    private static final int WINDOW_WIDTH = 800;

    private static int lastX = 0;
    private static int lastY = 0;

    public static Shape createShape(int type, int level) {
        Shape shape;
        Random randomizer = new Random();

        if (type == 0) {
            lastX = randomizer.nextInt(WINDOW_WIDTH);
            lastY = randomizer.nextInt(4500);
            int color = randomizer.nextInt(Mushroom.COLORS_COUNT);
            shape = new Mushroom((lastX + 80)%(WINDOW_WIDTH-10), -(lastY+100), color);
        } else if (type == 1) {
            lastX = randomizer.nextInt(WINDOW_WIDTH);
            lastY = randomizer.nextInt(4500);
            shape = new Coin((lastX + 80)%(WINDOW_WIDTH-10), -(lastY+100));
        } else if (type == 2) {
            int vType = randomizer.nextInt(level);
            lastX = randomizer.nextInt(WINDOW_WIDTH);
            lastY = randomizer.nextInt(4500);
            shape = new Villain((lastX + 80)%(WINDOW_WIDTH-10), -(lastY+100), vType);
        } else {
            shape = new Plate(400, 0, "/Plate.png");
        }

        return shape;
    }
}
