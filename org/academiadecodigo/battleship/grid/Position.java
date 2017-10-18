package org.academiadecodigo.battleship.grid;

import org.academiadecodigo.battleship.grid.Grid;

public class Position {

    private Grid grid = new Grid();
    private int col;
    private int row;
    private boolean hit;

    public Position() {
        col = (int) (Math.random() * grid.getCols());
        System.out.println("Ship col: " + col);
        row = (int) (Math.random() * grid.getRows());
        System.out.println("Ship row: " + row);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isHit() {
        return hit = true;
    }
}
