package org.academiadecodigo.battleship.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int col;
    private int row;
    private boolean hit;

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

    public void hit() {
        Rectangle cell = new Rectangle(Grid.colToPixel(col), Grid.rowToPixel(row), Grid.CELLSIZE, Grid.CELLSIZE);
        cell.setColor(Color.WHITE);
        cell.fill();
    }
}
