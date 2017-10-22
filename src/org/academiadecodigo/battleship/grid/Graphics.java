package org.academiadecodigo.battleship.grid;

import org.academiadecodigo.battleship.game.GameStats;
import org.academiadecodigo.battleship.ship.ShipType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Graphics {

    private GameStats gameStats;

    private Rectangle background;
    private Rectangle grid;
    private Text info;
    private Text shipsLeft;


    private int PADDING = Grid.PADDING;
    private int CELLSIZE = Grid.CELLSIZE;
    private int WIDTH = Grid.WIDTH;
    private int HEIGHT = Grid.HEIGHT;
    private int COLS = Grid.COLS;
    private int ROWS = Grid.ROWS;


    public Graphics() {
        this.gameStats = new GameStats();
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
        Line lineA2 = new Line(Grid.colToPixel(x) + 1, Grid.rowToPixel(y), Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y) + Grid.CELLSIZE - 1);
        lineA2.setColor(Color.GREEN);
        Line lineA3 = new Line(Grid.colToPixel(x), Grid.rowToPixel(y) + 1, Grid.colToPixel(x) + Grid.CELLSIZE - 1, Grid.rowToPixel(y) + Grid.CELLSIZE);
        lineA3.setColor(Color.GREEN);

        Line lineB = new Line(Grid.colToPixel(x), Grid.rowToPixel(y) + Grid.CELLSIZE, Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y));
        lineB.setColor(Color.GREEN);
        Line lineB2 = new Line(Grid.colToPixel(x), Grid.rowToPixel(y) + Grid.CELLSIZE - 1, Grid.colToPixel(x) + Grid.CELLSIZE - 1, Grid.rowToPixel(y));
        lineB2.setColor(Color.GREEN);
        Line lineB3 = new Line(Grid.colToPixel(x) + 1, Grid.rowToPixel(y) + Grid.CELLSIZE, Grid.colToPixel(x) + Grid.CELLSIZE, Grid.rowToPixel(y) + 1);
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

        setBattleshipLeft();
        setCarrierLeft();
        setCruiserLeft();
        setSubmarineLeft();
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

        Text shipName = new Text(PADDING + WIDTH + CELLSIZE, PADDING + CELLSIZE / 4, ShipType.BATTLESHIP.getName());
        shipName.setColor(Color.GREEN);
        shipName.draw();

        Text battleshipLeft = new Text(PADDING + WIDTH + CELLSIZE * 7, PADDING + CELLSIZE + CELLSIZE / 4, "" + gameStats.getBattleship());
        battleshipLeft.setColor(Color.GREEN);
        battleshipLeft.grow(10, 10);
        battleshipLeft.draw();
    }

    public void setCruiserLeft() {

        Text shipName = new Text(PADDING + WIDTH + CELLSIZE, PADDING + CELLSIZE * 2 + CELLSIZE / 4, ShipType.CRUISER.getName());
        shipName.setColor(Color.GREEN);
        shipName.draw();

        Text cruiserLeft = new Text(PADDING + WIDTH + CELLSIZE * 6, PADDING + CELLSIZE * 3 + CELLSIZE / 4, "" + gameStats.getCruiser());
        cruiserLeft.setColor(Color.GREEN);
        cruiserLeft.grow(10, 10);
        cruiserLeft.draw();
    }

    public void setSubmarineLeft() {
        Text shipName = new Text(PADDING + WIDTH + CELLSIZE, PADDING + CELLSIZE * 4 + CELLSIZE / 4, ShipType.SUBMARINE.getName());
        shipName.setColor(Color.GREEN);
        shipName.draw();

        Text submarineLeft = new Text(PADDING + WIDTH + CELLSIZE * 5, PADDING + CELLSIZE * 5 + CELLSIZE / 4, "" + gameStats.getSubmarine());
        submarineLeft.setColor(Color.GREEN);
        submarineLeft.grow(10, 10);
        submarineLeft.draw();
    }


    public void setCarrierLeft() {
        Text shipName = new Text(PADDING + WIDTH + CELLSIZE, PADDING + CELLSIZE * 6 + CELLSIZE / 4, ShipType.SMALL_SHIP.getName());
        shipName.setColor(Color.GREEN);
        shipName.draw();

        Text carrierLeft = new Text(PADDING + WIDTH + CELLSIZE * 4, PADDING + CELLSIZE * 7 + CELLSIZE / 4, "" + gameStats.getCarrier());
        carrierLeft.setColor(Color.GREEN);
        carrierLeft.grow(10, 10);
        carrierLeft.draw();
    }


    public void shipsLeft() {

        shipsLeft = new Text(Grid.PADDING, Grid.PADDING + Grid.HEIGHT + Grid.CELLSIZE, "SHIPS LEFT: " + gameStats.shipsRemaining());
        shipsLeft.setColor(Color.GREEN);

        shipsLeft.draw();

    }

    public void gameInfo() {

        info = new Text(Grid.PADDING, Grid.PADDING + Grid.HEIGHT + Grid.CELLSIZE * 2, "START HITTING SHIPS !");
        info.setColor(Color.GREEN);

        info.draw();
    }

    public void setGameInfo(String information) {

        info.setText(information);
    }

    public void setShipsLeftText(){

        shipsLeft.setText("SHIPS LEFT: " + gameStats.shipsRemaining());
    }

    public GameStats getGameStats() {
        return gameStats;
    }
}

