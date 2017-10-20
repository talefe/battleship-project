package org.academiadecodigo.battleship.grid;

public enum Direction {

    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, -1),
    DOWN(0, 1),
    UPLEFT(-1, -1),
    UPRIGHT(1, -1),
    DOWNLEFT(-1, 1),
    DOWNRIGHT(1, 1);

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
