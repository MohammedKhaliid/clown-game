package Iterators;

import Characters.Mushroom;

import java.util.Stack;

public class LeftHand implements Iterator {
    private Stack<Mushroom> plate = new Stack<Mushroom>();

    public void add(Mushroom mushroom)
    {
        plate.push(mushroom);
    }
    public Mushroom[] lastThreeMushrooms()
    {
        if (plate.size() > 3) {
            Mushroom m1 = plate.pop();
            Mushroom m2 = plate.pop();
            Mushroom m3 = plate.pop();

            if (m1.getColor() == m2.getColor() && m2.getColor() == m3.getColor()) return new Mushroom[]{m1, m2, m3};

            plate.push(m3);
            plate.push(m2);
            plate.push(m1);
        }
        return null;
    }

    public Mushroom getLastMushroom()
    {
        if(plate.isEmpty())
            return null;
        return plate.peek();
    }
}
