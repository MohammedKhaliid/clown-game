package Characters;

import Iterators.RightHand;
import Iterators.LeftHand;

public class Mario extends Character {
    private static Mario mario;
    private RightHand rightHand;
    private LeftHand leftHand;

    private Mario(int x, int y, boolean visible) {
        super(x, y, visible);
        this.rightHand = new RightHand();
        this.leftHand = new LeftHand();
    }

    public static Mario getMario() {
        if (mario == null) {
            mario = new Mario(-1, -1, true);    // To be updated later
        }

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
