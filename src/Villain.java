import javax.imageio.ImageIO;
import java.io.IOException;

public class Villain extends Shape{
    private int level;

    public Villain(int posX, int posY, int width, int height, int type, int level) {
        super(posX, posY, width, height, type);
        this.level = level;

        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/villain.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
