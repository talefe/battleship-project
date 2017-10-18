package org.academiadecodigo.battleship.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 14/10/17.
 */
public class Grid {

    public static int PADDING = 10;
    public static int MOUSESHIT = 23;
    public static int CELLSIZE = 40;
    private int cols;
    private int rows;
    private Rectangle grid;

    public Grid() {
        this.cols = 10;
        this.rows = 10;
    }

    public void gridInit() {
        grid = new Rectangle(PADDING, PADDING, (CELLSIZE * cols), (CELLSIZE * rows));
        grid.draw();
    }

    public int getCellSize() {
        return CELLSIZE;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getX() {
        return grid.getX();
    }

    public int getY() {
        return grid.getY();
    }

    public int getWidth() {
        return grid.getWidth();
    }

    public int getHeight() {
        return grid.getHeight();
    }

    public int pixelToCol(int pixel){
        return (int) (Math.floor(pixel / CELLSIZE));
    }

    public int pixelToRow(int pixel){
        return (int) (Math.floor(pixel / CELLSIZE));
    }

    public static int colToPixel(int col) {
        return col * CELLSIZE + PADDING;
    }

    public static int rowToPixel(int row) {
        return row * CELLSIZE + PADDING;
    }
}
