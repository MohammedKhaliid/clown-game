package Games;

import Characters.*;
import eg.edu.alexu.csd.oop.game.GameObject;

public class HardGame extends Game{

    private static final int MUSHROOM_COUNT = 22;
    private static final int COIN_COUNT = 3;
    private static final int VILLAIN_COUNT = 6;


    //    private final long startTime = System.currentTimeMillis();
    public HardGame(int screenWidth, int screenHeight) {
        super(screenWidth, screenHeight);
        mario = Mario.getMario();
        control.add(mario);


        rightPlate = ShapeFactory.createShape(3,0);
        leftPlate = ShapeFactory.createShape(3,0);

        rightPlate.setX(mario.getX());
        rightPlate.setY(mario.getY() + (int)(mario.getHeight()*0.15));

        leftPlate.setX(mario.getX() + (int)(mario.getWidth()*0.65));
        leftPlate.setY(mario.getY() + (int)(mario.getHeight()*0.15));

        ((Plate)leftPlate).setVisible(false);
        ((Plate)rightPlate).setVisible(false);

        control.add(rightPlate);
        control.add(leftPlate);

        for (int i = 0; i < MUSHROOM_COUNT; i++)
            moving.add(ShapeFactory.createShape(0,0));      // 0 for mushroom
//
        for (int i = 0; i < COIN_COUNT; i++)
            moving.add(ShapeFactory.createShape(1,0));      // 1 for coin

        for (int i = 0; i < VILLAIN_COUNT; i++)
            moving.add(ShapeFactory.createShape(2,3));      // 2 for villain

    }

    @Override
    public boolean refresh() {
        if (System.currentTimeMillis() - startTime > MAX_TIME) {
            return false;
        }

        attachPlates();

        for (GameObject mvng : moving.toArray(new GameObject[moving.size()])) {

//            if(mvng.isVisible()){

            mvng.setY(mvng.getY() + 3);

            //Exceeds the borders
            if (mvng.getY() >= getHeight()) {
                mvng.setX((int) (Math.random() * getWidth()));
                mvng.setY(-1 * (int) (Math.random() * getHeight()));
            }

            if (mvng instanceof Mushroom) {

                GameObject rightComp = rightPlate;
                GameObject leftComp = leftPlate;

                //specifying the last mushroom to be used in intersection comparison
                if (mario.getRightHand().getLastMushroom() != null) {
                    rightComp = mario.getRightHand().getLastMushroom();
                }
                if (mario.getLeftHand().getLastMushroom() != null) {
                    leftComp = mario.getLeftHand().getLastMushroom();
                }

                if (intersect(mvng, rightComp)) {
                    moving.remove(mvng);
                    control.add(mvng);



                    mario.getRightHand().add((Mushroom) mvng);

                    Mushroom[] m = mario.getRightHand().lastThreeMushrooms();

                    if (m != null) {
                        for (int i = 0; i < 3; i++) {
                            control.remove(m[i]);
                            moving.add(m[i]);
                            m[i].setX((int) (Math.random() * getWidth()));
                            m[i].setY(-1 * (int) (Math.random() * getHeight()));
                        }
                        score+=5;
                        Progress.setState("+5");
                    }
                } else if (intersect(mvng, leftComp)) {
                    moving.remove(mvng);
                    control.add(mvng);

                    mario.getLeftHand().add((Mushroom) mvng);

                    Mushroom[] m = mario.getLeftHand().lastThreeMushrooms();
                    if (m != null) {
                        for (int i = 0; i < 3; i++) {
                            control.remove(m[i]);
                            moving.add(m[i]);
                            m[i].setX((int) (Math.random() * getWidth()));
                            m[i].setY(-1 * (int) (Math.random() * getHeight()));
                        }
                        score+=5;
                        Progress.setState("+5");
                    }
                }

                if (!mvng.isVisible()) {
                    mvng.setY(-1 * (int) (Math.random() * getHeight()));
                    mvng.setX((int) (Math.random() * getWidth()));

                    ((Mushroom) mvng).setVisible(true);
                }
            } else if (mvng instanceof Coin) {
                if (intersect(mvng, mario)) {
                    score += 2;
                    Progress.setState("+2");
                    ((Coin) mvng).setVisible(false);
                }
                if (!mvng.isVisible()) {
                    mvng.setY(-1 * (int) (Math.random() * getHeight()));
                    mvng.setX((int) (Math.random() * getWidth()));

                    ((Coin) mvng).setVisible(true);
                }
            } else if (mvng instanceof Villain) {     //add sort of visuals or sounds when score decreases
                if (intersect(mvng, mario)) {
                    score -= 2*((Villain) mvng).getType() + 1;
                    Progress.setState("-"+2*((Villain) mvng).getType() + 1);
                    if(score < 0) score = 0;
                    ((Villain) mvng).setVisible(false);
                }

                if (!mvng.isVisible()) {
                    mvng.setY(-1 * (int) (Math.random() * getHeight()) * 5);
                    mvng.setX((int) (Math.random() * getWidth()));

                    ((Villain) mvng).setVisible(true);
                }
            }
            GameObject lastRight = rightPlate, lastLeft = leftPlate;
            int rightFlag = lastRight.getWidth() / 6, leftFlag = lastLeft.getWidth() / 4;
            for (GameObject o : control) {
                if (o instanceof Mushroom) {
                    if (((Mushroom) o).getIsRight()) {
                        o.setX(lastRight.getX() + rightFlag);
                        o.setY(lastRight.getY() - o.getHeight());
                        lastRight = o;
                        rightFlag = 0;
                    } else {
                        o.setX(lastLeft.getX() + leftFlag);
                        o.setY(lastLeft.getY() - o.getHeight());
                        lastLeft = o;
                        leftFlag = 0;
                    }

                }
            }
        }
        if(control.size() - 3 == MUSHROOM_COUNT) return false;
        return true;
    }
}