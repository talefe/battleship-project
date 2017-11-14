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
    private Text battleshipLeft;
    private Text cruiserLeft;
    private Text submarineLeft;
    private Text carrierLeft;


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

        Picture select = new Picture((350 + Grid.PADDING2), 500, "press.jpg");

        while (!gameStats.isGameStarted()){

            try{
                select.draw();
                Thread.sleep(500);
                select.delete();
                Thread.sleep(500);

            } catch (InterruptedException i){
                System.out.println(i);
            }
        }
    }

    public void endScreen() {

        Picture startImage = new Picture(10, 10, "end-screen.jpg");
        startImage.draw();
    }

    public void drawBackground() {
        background = new Rectangle(Grid.PADDING2, Grid.PADDING2, Grid.WIDTH * 2 + Grid.PADDING, Grid.HEIGHT * 2);
        background.fill();
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


    public void shipStatus(int x, int y, String shipName, int num) {
        Text carrier = new Text(PADDING + WIDTH + CELLSIZE, PADDING + CELLSIZE * 6 + CELLSIZE / 4, shipName);
        carrier.setColor(Color.GREEN);
        carrier.draw();

        carrierLeft = new Text(PADDING + WIDTH + CELLSIZE * 4, PADDING + CELLSIZE * 7 + CELLSIZE / 4, "" + num);
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

    public void gameResults(){

        Text shots = new Text(400,460, "SHOTS: "+gameStats.getShots());
        Text misses = new Text(400, 500,"MISSES: "+gameStats.getMisses());
        Text score = new Text(400,540, "TOTAL SCORE: "+gameStats.getScore());

        shots.setColor(Color.GREEN);
        misses.setColor(Color.GREEN);
        score.setColor(Color.GREEN);
        shots.draw();
        misses.draw();
        score.draw();

    }

    public void setGameInfo(String information) {

        info.setText(information);
    }

    public void setShipsLeftText(){

        shipsLeft.setText("SHIPS LEFT: " + gameStats.shipsRemaining());
    }



    public void setShipsStats(){
        battleshipLeft.setText("" + gameStats.getBattleship());
        cruiserLeft.setText("" + gameStats.getCruiser());
        submarineLeft.setText("" + gameStats.getSubmarine());
        carrierLeft.setText("" + gameStats.getCarrier());
    }
    public GameStats getGameStats() {
        return gameStats;
    }
}

