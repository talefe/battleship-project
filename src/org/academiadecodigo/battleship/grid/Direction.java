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

    private int col;
    private int row;

    Direction(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public static Direction randomDirection() {

        //double random = Math.random();
        return values()
                [(int) (Math.random() * 4)];
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
