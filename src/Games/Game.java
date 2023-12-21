package Games;

import Characters.Mario;
import Characters.Plate;
import Helpers.ProgressManager;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.LinkedList;
import java.util.List;

public abstract class Game implements World {

    public static int MAX_TIME = 120 * 1000;	// 2 minute

//    public static final int RANDOM_Y_RANGE = 200;

    protected Mario mario;
    protected int score;
    protected int width;
    protected int height;
    protected int speed;
    protected long startTime = System.currentTimeMillis();
    protected ProgressManager progressManager;
    protected GameObject rightPlate;
    protected GameObject leftPlate;
    protected final List<GameObject> constant = new LinkedList<GameObject>();
    protected final List<GameObject> moving = new LinkedList<GameObject>();
    protected final List<GameObject> control = new LinkedList<GameObject>();

    public Game(int screenWidth, int screenHeight) {
        width = screenWidth;
        height = screenHeight;
    }
    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }
    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }
    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public abstract boolean refresh();

    @Override
    public String getStatus() {
        return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis()-startTime))/1000);	// update status
    }

    @Override
    public int getSpeed() {
        return 5;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }

//    protected boolean intersect(GameObject o1, GameObject o2){
//        return (Math.abs((o1.getX()+o1.getWidth()/2) - (o2.getX()+o2.getWidth()/2)) <= o1.getWidth()) && (Math.abs((o1.getY()+o1.getHeight()/2) - (o2.getY()+o2.getHeight()/2)) <= o1.getHeight());
//    }

    protected boolean intersect(GameObject o1, GameObject o2) {
        return (Math.abs((o1.getX() + o1.getWidth()/2) - (o2.getX() + o2.getWidth()/2)) <= (o1.getWidth() + o2.getWidth())/2)
                && (Math.abs((o1.getY() + o1.getHeight()/2) - (o2.getY() + o2.getHeight()/2)) <= (o1.getHeight() + o2.getHeight())/2);
    }

//    protected boolean intersect(GameObject o1, GameObject o2) {
//        return (Math.abs((o1.getX() + o1.getWidth()/2) - (o2.getX() + o2.getWidth()/2)) <= (o1.getWidth() + o2.getWidth())/2)
//                && (Math.abs((o1.getY() + o1.getHeight()/2) - (o2.getY() + o2.getHeight()/2)) == (o1.getHeight() + o2.getHeight())/2);
//    }


    protected void attachPlates(){
        rightPlate.setX(mario.getX());
        rightPlate.setY(mario.getY() + (int)(mario.getHeight()*0.15));

        leftPlate.setX(mario.getX() + (int)(mario.getWidth()*0.65));
        leftPlate.setY(mario.getY() + (int)(mario.getHeight()*0.15));
    }
}
