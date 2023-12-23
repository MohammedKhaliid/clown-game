package Helpers;
import Games.Game;
interface Observer {
    public abstract void update(String state,Game game);
}
