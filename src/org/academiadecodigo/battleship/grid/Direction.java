package org.academiadecodigo.battleship.grid;

public enum Direction {

    LEFT,
    RIGHT,
    UP,
    DOWN;

    public static Direction direction()
    {
        double random = Math.random();

        if(random <0.25)
            return LEFT;
        else if(random >= 0.25 && random < 0.5)
            return RIGHT;
        else if(random >= 0.5 && random < 0.75)
            return UP;
        else
            return DOWN;
    }
}
