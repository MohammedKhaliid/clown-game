package Games;

public class MediumGame extends Game{
    public MediumGame(int screenWidth, int screenHeight) {
        super(screenWidth, screenHeight);
    }

    @Override
    public boolean refresh() {
        return true;
    }

}
