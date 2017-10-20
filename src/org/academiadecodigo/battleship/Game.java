package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.battleship.ship.Ship;
import org.academiadecodigo.battleship.ship.ShipFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 14/10/17.
 */
public class Game {

    private Grid grid = new Grid();
    private Rectangle cell;


    private ShipFactory shipFactory = new ShipFactory();
    private Ship[] ships;
    private boolean gameStart = false;
    private Rectangle initialScreen;
    private int liveships = 10;
    private boolean gameFinished = false;
    private Text howManyShipsText;
    private Text gameInformation;
    private Position[] hitPositions = new Position[20];
    static int index = 0;


    public void init() {

        MouseController mc = new MouseController(this);

        Rectangle initialScreen = new Rectangle(10, 10, 800, 800);
        initialScreen.fill();
        Text starText = new Text(410,410, "//Click to start");
        starText.setColor(Color.GREEN);
        starText.draw();
    }

    public void start() {

        gameStart = true;

        grid.gridInit();

        ships = shipFactory.createNavy();

        for (Ship ship : ships) {
            //ship.fillShip();
            System.out.println(ship.getPositions()[0].getCol() + "," + ship.getPositions()[0].getRow());
        }

        howManyShipsText = new Text(200,620, "Ships remaining: " + liveships);
        howManyShipsText.setColor(Color.GREEN);
        howManyShipsText.draw();

        gameInformation = new Text(200,640," ");
        gameInformation.setColor(Color.GREEN);
        gameInformation.draw();



    }

    public Grid getGrid() {
        return grid;
    }

    public void hitGuess(int x, int y) {


        boolean outOfBounds = x < 0 || y < 0 || x >= Grid.COLS || y >= Grid.ROWS;

        if (outOfBounds) {
            return;
        }
       // if(position was used before){
       //     return;
       // }
        for (Ship ship : ships) {

            if (ship.isHit(x, y)) {

                Position pos = new Position();
                pos.setCol(x);
                pos.setRow(y);
                hitPositions[index] = pos;
                index++;


                ship.hit(x, y);
                gameInformation.setText(ship.getShipType() +" HIT");
                if(ship.isDestroyed()){
                    liveships --;
                    gameInformation.setText(ship.getShipType() + " DESTRYED");
                    howManyShipsText.setText("Ships remaining: " + liveships);
                }
                if(isGameFinished()){
                  finalScreen();
                }
                return;
            }
        }
        gameInformation.setText("MISS");
        System.out.println("MISS");
        grid.drawCross(x, y);

    }

    public boolean started() {
        return gameStart;
    }

    public boolean isGameFinished(){
       if(liveships == 0) {
           gameFinished = true;
           return gameFinished;
       }
       return false;
    }

    public void finalScreen(){
        Rectangle initialScreen = new Rectangle(10, 10, 800, 800);
        initialScreen.fill();
        Text finalText = new Text(410,410, "//The End");
        finalText.setColor(Color.GREEN);
        finalText.draw();
    }


    public Position[] getHitPositions(){
        return hitPositions;
    }

}


