package Characters;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Villain extends Shape{
    private final int type;
    public Villain(int posX, int posY, int type) {
        super(posX, posY, "/Villain" + type + ".png");
        this.type = type;
    }
    public int getType(){
        return type;
    }
}
