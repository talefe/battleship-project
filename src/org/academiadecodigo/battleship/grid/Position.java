package org.academiadecodigo.battleship.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

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

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    /* public void hit() {


        Rectangle cell = new Rectangle(Grid.colToPixel(col) +1, Grid.rowToPixel(row) +1, Grid.CELLSIZE -1, Grid.CELLSIZE-1);
        cell.setColor(Color.RED);
        cell.fill();
    }

    */


}

