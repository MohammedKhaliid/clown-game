package Characters;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Character implements GameObject {
    protected int x;
    protected int y;
    protected boolean visible;
    protected BufferedImage[] spriteImages;

    public Character(int x, int y, boolean visible) {
        this.x = x;
        this.y = y;
        this.visible = visible;
    }

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
        return spriteImages[0].getWidth();
    }

    public int getHeight() {
        return spriteImages[0].getHeight();
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
