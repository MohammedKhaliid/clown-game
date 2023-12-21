package Iterators;

import Characters.Mushroom;

import java.util.Stack;

public class RightHand implements Iterator {
    Stack<Mushroom> plate = new Stack<Mushroom>();

    public void add(Mushroom mushroom)
    {
        plate.push(mushroom);
    }
    public boolean lastThreeMatches()
    {
        Mushroom m1 = plate.peek();
        plate.pop();
        Mushroom m2 = plate.peek();
        plate.pop();
        Mushroom m3 = plate.peek();
        plate.push(m2);
        plate.push(m1);

        if(m1.getColor() == m2.getColor() && m2.getColor() == m3.getColor())
            return true;
        return false;
    }
    public Mushroom lastMushroom()
    {
        return plate.peek();
    }
}
