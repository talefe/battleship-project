package org.academiadecodigo.battleship.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 14/10/17.
 */
public class Grid {

    private Rectangle background;
    private Rectangle grid;

    public static int COLS = 10;
    public static int ROWS = 10;
    public static int PADDING = 200;
    public static int PADDING2 = 10;
    public static int MOUSESHIT = 23;
    public static int CELLSIZE = 40;

    public void gridInit() {

        background = new Rectangle(PADDING2, PADDING2, getWidth() * 2, getHeight() * 2);
        background.fill();

        grid = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        grid.setColor(Color.GREEN);
        grid.draw();

        linesX();
        linesY();
        numbers();
        aBc();
    }

    public void linesX() {
        int nextLine = CELLSIZE;

        for (int i = 0; i < COLS - 1; i++) {

            Line gridLine;
            gridLine = new Line(PADDING + nextLine, PADDING, PADDING + nextLine, PADDING + getHeight());
            gridLine.setColor(Color.GREEN);
            gridLine.draw();
            nextLine += CELLSIZE;
        }
    }

    public void linesY() {
        int nextLine = CELLSIZE;

        for (int i = 0; i < COLS - 1; i++) {
            Line gridLine;
            gridLine = new Line(PADDING, PADDING + nextLine, PADDING + getWidth(), PADDING + nextLine);
            gridLine.setColor(Color.GREEN);
            gridLine.draw();
            nextLine += CELLSIZE;
        }
    }

    public void numbers() {
        Text text;

        for (int i = 0; i < COLS; i++) {
            String t = "" + i;
            text = new Text(PADDING + i * CELLSIZE + CELLSIZE / 2, PADDING - CELLSIZE, t);
            text.setColor(Color.GREEN);
            text.draw();
        }
    }

    public void aBc() {

        Text text;
        String[] abc = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int i = 0; i < ROWS; i++) {
            text = new Text(PADDING - CELLSIZE, PADDING + i * CELLSIZE + CELLSIZE / 2, abc[i]);
            text.setColor(Color.GREEN);
            text.draw();
        }
    }

    public void drawCross(int x, int y) {

        Line lineA = new Line(Grid.colToPixel(x), Grid.rowToPixel(y), Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y) + Grid.CELLSIZE);
        lineA.setColor(Color.GREEN);
        Line lineB = new Line(Grid.colToPixel(x), Grid.rowToPixel(y) + Grid.CELLSIZE, Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y));
        lineB.setColor(Color.GREEN);

        lineA.draw();
        lineB.draw();
    }

    public int getWidth() {
        return CELLSIZE * COLS;
    }

    public int getHeight() {
        return CELLSIZE * ROWS;
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
