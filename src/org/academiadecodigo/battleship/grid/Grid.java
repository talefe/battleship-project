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

    private int battleshipLeft = 1;
    private int cruiserLeft = 2;
    private int submarineLeft = 3;
    private int carrierLeft = 4;

    private Text battleship;
    private Text battleshipNumber;
    private Text cruiser;
    private Text cruiserNumber;
    private Text submarine;
    private Text submarineNumber;
    private Text carrier;
    private Text carrierNumber;

    public void gridInit() {

        background = new Rectangle(PADDING2, PADDING2, getWidth() * 2 + PADDING, getHeight() * 2);
        background.fill();

        grid = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        grid.setColor(Color.GREEN);
        grid.draw();

        Text enemyNavy = new Text(PADDING +getWidth()+ CELLSIZE  , PADDING - CELLSIZE, "ENEMY NAVY");
        enemyNavy.setColor(Color.GREEN);
        enemyNavy.draw();

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

    public void gameLabels(){
        Rectangle square;

        //battleship
        battleship = new Text(PADDING + getWidth() +CELLSIZE , PADDING + (CELLSIZE /2), "Battleship");
        battleship.setColor(Color.GREEN);
        battleship.draw();
        //amount of ships left placed to the right of the squares
        battleshipNumber = new Text(PADDING + getWidth() + CELLSIZE + CELLSIZE * 6, PADDING + CELLSIZE, "" + battleshipLeft);
        battleshipNumber.setColor(Color.GREEN);
        battleshipNumber.draw();


        for (int i = 0; i <5 ; i++) {

           square = new Rectangle(PADDING + getWidth() + CELLSIZE + (CELLSIZE*i), PADDING + CELLSIZE, CELLSIZE, CELLSIZE);
           square.setColor(Color.GREEN);
           square.draw();

        }

        //cruiser
        cruiser = new Text(PADDING + getWidth() +CELLSIZE , PADDING + (CELLSIZE*2) + (CELLSIZE /2), "Cruiser");
        cruiser.setColor(Color.GREEN);
        cruiser.draw();
        //amount of ships left placed to the right of the squares
        cruiserNumber = new Text(PADDING + getWidth() + CELLSIZE + CELLSIZE * 5, PADDING + CELLSIZE*3,"" + cruiserLeft);
        cruiserNumber.setColor(Color.GREEN);
        cruiserNumber.draw();

        for (int i = 0; i <4 ; i++) {

            square = new Rectangle(PADDING + getWidth()+CELLSIZE + (CELLSIZE*i), PADDING + CELLSIZE*3, CELLSIZE, CELLSIZE);
            square.setColor(Color.GREEN);
            square.draw();

        }

        //submarine
        submarine = new Text(PADDING + getWidth() +CELLSIZE , PADDING + (CELLSIZE*4) + (CELLSIZE /2), "Submarine");
        submarine.setColor(Color.GREEN);
        submarine.draw();
        //amount of ships left placed to the right of the squares
        submarineNumber = new Text(PADDING + getWidth() + CELLSIZE + CELLSIZE * 4, PADDING + CELLSIZE*5, "" + submarineLeft);
        submarineNumber.setColor(Color.GREEN);
        submarineNumber.draw();

        for (int i = 0; i <3 ; i++) {

            square = new Rectangle(PADDING + getWidth()+CELLSIZE + (CELLSIZE*i), PADDING + CELLSIZE*5, CELLSIZE, CELLSIZE);
            square.setColor(Color.GREEN);
            square.draw();

        }

        //carrier

        carrier = new Text(PADDING + getWidth() +CELLSIZE , PADDING + (CELLSIZE*6) + (CELLSIZE /2), "Carrier");
        carrier.setColor(Color.GREEN);
        carrier.draw();
        //amount of ships left placed to the right of the squares
        carrierNumber = new Text(PADDING + getWidth() + CELLSIZE * 4, PADDING + CELLSIZE*7, "" + carrierLeft);
        carrierNumber.setColor(Color.GREEN);
        carrierNumber.draw();

        for (int i = 0; i <2 ; i++) {

            square = new Rectangle(PADDING + getWidth() + CELLSIZE + (CELLSIZE * i), PADDING + CELLSIZE * 7, CELLSIZE, CELLSIZE);
            square.setColor(Color.GREEN);
            square.draw();
        }

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

    public static int rowToPixel(int row)
    {
        return row * CELLSIZE + PADDING;
    }

    public void setBattleshipLeft(){
        battleshipLeft--;
        battleshipNumber.setText("" + battleshipLeft);
    }

    public void setCruiserLeft(){
        cruiserLeft--;
        cruiserNumber.setText("" + cruiserLeft);
    }

    public void setSubmarineLeft(){
        submarineLeft--;
        submarineNumber.setText("" + submarineLeft);
    }

    public void setCarrierLeft(){
        carrierLeft--;
        carrierNumber.setText("" + carrierLeft);
    }

}
