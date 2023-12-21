package Iterators;
import Characters.Mushroom;
public interface Iterator {

    void add(Mushroom mushroom);
    Mushroom[] lastThreeMushrooms();

    Mushroom getLastMushroom();
}
