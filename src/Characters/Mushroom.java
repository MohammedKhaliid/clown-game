package Characters;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mushroom extends Shape {
    private int color;

    static final int COLORS_COUNT = 4;

    public Mushroom(int posX, int posY, int color) {
        super(posX, posY, "res/Mushroom" + color + ".png");

        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
