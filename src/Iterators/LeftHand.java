package Iterators;

import Characters.Mushroom;
import Iterators.Iterator;

import java.util.Stack;

public class LeftHand implements Iterator {
    Stack<Mushroom> plate = new Stack<Mushroom>();

    public void add(Mushroom mushroom)
    {
        plate.push(mushroom);
    }
    public boolean lastThreeMatches()
    {
        Mushroom m1 = plate.pop();
        Mushroom m2 = plate.pop();
        Mushroom m3 = plate.pop();

        if(m1.getColor() == m2.getColor() && m2.getColor() == m3.getColor())
            return true;

        plate.push(m3);
        plate.push(m2);
        plate.push(m1);
        return false;
    }

    public Mushroom lastMushroom()
    {
        return plate.peek();
    }
}
