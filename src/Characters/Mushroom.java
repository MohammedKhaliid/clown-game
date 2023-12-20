package Characters;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mushroom extends Shape {
    private int color;

    static final int COLORS_COUNT = 4;

    public Mushroom(int posX, int posY, int color) {
        super(posX, posY);

        this.setColor(color);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;

        try {
            switch(color){
                case 0:
                    // Red
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/red_mushroom.png"));
                    break;
                case 1:
                    // Green
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/green_mushroom.png"));
                    break;
                case 2:
                    // Blue
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/blue_mushroom.png"));
                    break;
                case 3:
                    // Violet
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/violet_mushroom.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
