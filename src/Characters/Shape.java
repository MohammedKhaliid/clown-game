package Characters;

import java.awt.image.BufferedImage;

public abstract class Shape extends Character {
    private static final int MAX_STATES = 1;
//    private int type;

    public Shape(int posX, int posY){
        super(posX, posY, true);

        super.spriteImages = new BufferedImage[MAX_STATES];
//        this.type = type;
    }
}
