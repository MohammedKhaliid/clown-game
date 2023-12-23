package Helpers;

import java.util.ArrayList;
import java.util.List;
import Games.Game;

public class State {
    private List<Observer> observers = new ArrayList<>();
    private String state;
private Game game;
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setState(String state,Game game) {
        this.state = state;
        this.game = game;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state,game);
        }
    }
}
