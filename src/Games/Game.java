package Games;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.List;

public class Game implements World {

    protected int score;
    protected int width;
    protected int height;
    protected int speed;
    protected long startTime;
    @Override
    public List<GameObject> getConstantObjects() {
        return null;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return null;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public boolean refresh() {
        return false;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getControlSpeed() {
        return 0;
    }
}
