package Iterators;
import Characters.Mushroom;
public interface Iterator {

    void add(Mushroom mushroom);
    boolean lastThreeMatches();

    Mushroom lastMushroom();
}
