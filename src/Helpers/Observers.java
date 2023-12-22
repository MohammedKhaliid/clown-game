package Helpers;

public class Observers implements Observer {
    private String observerName;

    public Observers(String observerName) {
        this.observerName = observerName;
    }

    public void update(String state) {
        System.out.println(observerName + " is updated and the new state is " + state);
    }
}
