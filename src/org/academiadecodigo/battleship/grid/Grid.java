package org.academiadecodigo.battleship.grid;

public class Grid {

    private Graphics graphics = new Graphics();

    public static int COLS = 10;
    public static int ROWS = 10;
    public static int PADDING = 200;
    public static int PADDING2 = 10;
    public static int MOUSESHIT = 23;
    public static int CELLSIZE = 40;
    public static int WIDTH = COLS * CELLSIZE;
    public static int HEIGHT = ROWS * CELLSIZE;

    public void gridInit() {
        graphics.drawBackground();
        graphics.drawGrid();
    }

    public int pixelToCol(int pixel) {
        return (int) (Math.floor(pixel / CELLSIZE));
    }

    public int pixelToRow(int pixel) {
        return (int) (Math.floor(pixel / CELLSIZE));
    }

    public static int colToPixel(int col) {
        return col * CELLSIZE + PADDING;
    }

    public static int rowToPixel(int row) {
        return row * CELLSIZE + PADDING;
    }

}
