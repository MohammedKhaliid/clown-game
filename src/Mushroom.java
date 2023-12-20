import javax.imageio.ImageIO;
import java.io.IOException;

public class Mushroom extends Shape {
    private int color;

    public Mushroom(int posX, int posY, int width, int height, int type, int color) {
        super(posX, posY, width, height, type);

        this.setColor(color);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;

        try {
            switch(color){
                case 1:
                    // Red
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/red_mushroom.png"));
                    break;
                case 2:
                    // Green
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/green_mushroom.png"));
                    break;
                case 3:
                    // Blue
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/blue_mushroom.png"));
                    break;
                case 4:
                    // Violet
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/violet_mushroom.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
