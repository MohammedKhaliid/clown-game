package Characters;

import Iterators.RightHand;
import Iterators.LeftHand;

public class Mario extends Character {
    private static final Mario mario = new Mario(200, 270);    // To be updated later
    private RightHand rightHand;
    private LeftHand leftHand;

    private Mario(int x, int y) {
        super(x, y, "/Mario.png");
        this.rightHand = new RightHand();
        this.leftHand = new LeftHand();
    }

    public static Mario getMario() {
        return mario;
    }

    public RightHand getRightHand() {
        return this.rightHand;
    }

    public LeftHand getLeftHand() {
        return this.leftHand;
    }

    @Override
    public void setY(int y) {}
}
