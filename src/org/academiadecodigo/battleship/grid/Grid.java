package org.academiadecodigo.battleship.grid;

import java.util.LinkedList;
import java.util.List;

public class Grid {

    private final List<Position> positions;
    private Graphics graphics = new Graphics();

    public static int COLS = 10;
    public static int ROWS = 10;
    public static int PADDING = 200;
    public static int PADDING2 = 10;
    public static int MOUSESHIT = 23;
    public static int CELLSIZE = 40;
    public static int WIDTH = COLS * CELLSIZE;
    public static int HEIGHT = ROWS * CELLSIZE;

    public Grid() {
        positions = new LinkedList<>();
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                Position position = new Position(i, j);
                positions.add(position);
            }
        }
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
