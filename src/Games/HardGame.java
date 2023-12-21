package Games;

public class HardGame extends Game{
    public HardGame(int screenWidth, int screenHeight) {
        super(screenWidth, screenHeight);
    }

    @Override
    public boolean refresh() {
        return false;
    }

}
