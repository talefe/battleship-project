package org.academiadecodigo.battleship.grid;

public class Position {

    private int col;
    private int row;

    public Position() {
        col = (int) (Math.random() * Grid.COLS);
        row = (int) (Math.random() * Grid.COLS);
    }

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean areCoordinatesEqual(int x, int y) {
        return this.col == x && this.row == y;
    }

}

