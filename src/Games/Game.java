package Games;

import Characters.Background;
import Characters.Character;
import Characters.Mario;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import Helpers.*;

import java.util.LinkedList;
import java.util.List;

public abstract class Game implements World {

    public static int MAX_TIME = 60 * 1000;	// 2 minute

//    public static final int RANDOM_Y_RANGE = 200;

    protected Mario mario;
    protected int score;
    protected int width;
    protected int height;
    protected int speed;
    protected State Progress;


    protected long startTime = System.currentTimeMillis();
    protected GameObject rightPlate;
    protected GameObject leftPlate;
    protected final List<GameObject> constant = new LinkedList<GameObject>();
    protected final List<GameObject> moving = new LinkedList<GameObject>();
    protected final List<GameObject> control = new LinkedList<GameObject>();

    public Game(int screenWidth, int screenHeight) {

        width = screenWidth;
        height = screenHeight;
        Background b = new Background(0,-5,"/World.png");
        constant.add(b);
        Observers player = new Observers("Player");
        Progress = new State();
        Progress.addObserver(player);
        addProgress();
        clearProgress();
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

    private void addProgress(){
        Background two = new Background(0,0,"/2.png");
        constant.add(two);
        Background five = new Background(0,0,"/5.png");
        constant.add(five);
        Background bad1 = new Background(0,0,"/bad1.png");
        constant.add(bad1);
        Background bad3 = new Background(0,0,"/bad3.png");
        constant.add(bad3);
        Background bad5 = new Background(0,0,"/bad5.png");
        constant.add(bad5);
    }
    public void printProgress(String state){
        switch (state) {
            case "+2":
                ((Character)constant.get(1)).setVisible(true);
                break;
            case "+5":
                ((Character)constant.get(2)).setVisible(true);
                break;
            case "-1":
                ((Character)constant.get(3)).setVisible(true);
                break;
            case "-3":
                ((Character)constant.get(4)).setVisible(true);
                break;
            case "-5":
                ((Character)constant.get(5)).setVisible(true);
                break;

        }

    }

 public void clearProgress(){
        boolean flag =true;
        for(GameObject o:constant)
        {
            if(flag==true) {
                flag = false;
                continue;
            }
            ((Character)o).setVisible(false);
        }

 }

}
