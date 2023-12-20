import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Character implements GameObject {
    protected int x;
    protected int y;
    protected boolean visible;
    protected int width;
    protected int height;
    protected BufferedImage[] spriteImages;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
    	this.y = y;
    }
}
