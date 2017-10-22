package org.academiadecodigo.battleship.grid;

import org.academiadecodigo.battleship.game.GameStats;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

// THIS CLASS NEEDS TO BE CLEANED

public class Graphics {

    private GameStats gameStats;

    private Rectangle background;
    private Rectangle grid;
    private Text info;

    private int PADDING = Grid.PADDING;
    private int CELLSIZE = Grid.CELLSIZE;
    private int WIDTH = Grid.WIDTH;
    private int HEIGHT = Grid.HEIGHT;
    private int COLS = Grid.COLS;
    private int ROWS = Grid.ROWS;

    public Graphics() {
        this.gameStats = gameStats;
    }

    public void startScreen() {

        Picture startImage = new Picture(10, 10, "start-screen.jpg");
        startImage.draw();
    }

    public void endScreen() {

        Picture startImage = new Picture(10, 10, "end-screen.jpg");
        startImage.draw();
    }

    public void drawHit(int x, int y) {

        Line lineA = new Line(Grid.colToPixel(x), Grid.rowToPixel(y), Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y) + Grid.CELLSIZE);
        lineA.setColor(Color.GREEN);
        Line lineA2 = new Line(Grid.colToPixel(x)+1, Grid.rowToPixel(y), Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y) + Grid.CELLSIZE-1);
        lineA2.setColor(Color.GREEN);
        Line lineA3= new Line(Grid.colToPixel(x), Grid.rowToPixel(y)+1, Grid.colToPixel(x) + Grid.CELLSIZE-1, Grid.rowToPixel(y) + Grid.CELLSIZE);
        lineA3.setColor(Color.GREEN);

        Line lineB = new Line(Grid.colToPixel(x), Grid.rowToPixel(y) + Grid.CELLSIZE, Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y));
        lineB.setColor(Color.GREEN);
        Line lineB2 = new Line(Grid.colToPixel(x), Grid.rowToPixel(y) + Grid.CELLSIZE-1, Grid.colToPixel(x) + Grid.CELLSIZE-1, Grid.rowToPixel(y));
        lineB2.setColor(Color.GREEN);
        Line lineB3 = new Line(Grid.colToPixel(x)+1, Grid.rowToPixel(y) + Grid.CELLSIZE, Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y)+1);
        lineB3.setColor(Color.GREEN);

        lineA.draw();
        lineA2.draw();
        lineA3.draw();
        lineB.draw();
        lineB2.draw();
        lineB3.draw();
    }

    public void drawMiss(int x, int y) {

        Rectangle cell = new Rectangle(Grid.colToPixel(x) + 1, Grid.rowToPixel(y) + 1, Grid.CELLSIZE - 1, Grid.CELLSIZE - 1);
        cell.setColor(new Color(0, 102, 0));
        cell.fill();
    }

    public void drawBackground() {
        background = new Rectangle(Grid.PADDING2, Grid.PADDING2, Grid.WIDTH * 2 + Grid.PADDING, Grid.HEIGHT * 2);
        background.fill();
    }

    public void drawGrid() {

        grid = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.WIDTH, Grid.HEIGHT);
        grid.setColor(Color.GREEN);
        grid.draw();
        linesX();
        linesY();
        numbers();
        aBc();
        gameLabels();
    }

    public void linesX() {
        int nextLine = CELLSIZE;

        for (int i = 0; i < COLS - 1; i++) {

            Line gridLine;
            gridLine = new Line(PADDING + nextLine, PADDING, PADDING + nextLine, PADDING + HEIGHT);
            gridLine.setColor(Color.GREEN);
            gridLine.draw();
            nextLine += CELLSIZE;
        }
    }

    public void linesY() {
        int nextLine = CELLSIZE;

        for (int i = 0; i < COLS - 1; i++) {
            Line gridLine;
            gridLine = new Line(PADDING, PADDING + nextLine, PADDING + WIDTH, PADDING + nextLine);
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


    public void gameLabels() {
        Rectangle square;

        //battleship


        for (int i = 0; i < 5; i++) {

            square = new Rectangle(PADDING + WIDTH + CELLSIZE + (CELLSIZE * i), PADDING + CELLSIZE, CELLSIZE, CELLSIZE);
            square.setColor(Color.GREEN);
            square.draw();

        }

        //cruiser

        for (int i = 0; i < 4; i++) {

            square = new Rectangle(PADDING + WIDTH + CELLSIZE + (CELLSIZE * i), PADDING + CELLSIZE * 3, CELLSIZE, CELLSIZE);
            square.setColor(Color.GREEN);
            square.draw();

        }


        //submarine


        for (int i = 0; i < 3; i++) {

            square = new Rectangle(PADDING + WIDTH + CELLSIZE + (CELLSIZE * i), PADDING + CELLSIZE * 5, CELLSIZE, CELLSIZE);
            square.setColor(Color.GREEN);
            square.draw();

        }

        //carrier


        for (int i = 0; i < 2; i++) {

            square = new Rectangle(PADDING + WIDTH + CELLSIZE + (CELLSIZE * i), PADDING + CELLSIZE * 7, CELLSIZE, CELLSIZE);
            square.setColor(Color.GREEN);
            square.draw();
        }
    }


    public void setBattleshipLeft() {
    }

    public void setCruiserLeft() {
    }

    public void setSubmarineLeft() {
    }

    public void setCarrierLeft() {
    }

    public void shipsLeft() {

        Text shipsLeft = new Text(Grid.PADDING, Grid.PADDING + Grid.HEIGHT+Grid.CELLSIZE,"SHIPS LEFT: ");
        shipsLeft.setColor(Color.GREEN);
        shipsLeft.draw();

    }

    public void gameInfo() {

         info = new Text(Grid.PADDING, Grid.PADDING + Grid.HEIGHT+Grid.CELLSIZE*2,"START HITTING SHIPS !");
        info.setColor(Color.GREEN);
        info.draw();
    }

    public void setGameInfo(String information){

        info.setText(information);
    }
}
