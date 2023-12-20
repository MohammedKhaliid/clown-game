package Characters;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Coin extends Shape {
    public Coin(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);

        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("res/coin.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
