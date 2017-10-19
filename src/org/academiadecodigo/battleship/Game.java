package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.ship.Ship;
import org.academiadecodigo.battleship.ship.ShipFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 14/10/17.
 */
public class Game {

    private Grid grid = new Grid();
    private Rectangle cell;
    private Line lineA;
    private Line lineB;
    private ShipFactory shipFactory = new ShipFactory();
    private Ship[] ships;
    private boolean gameStart = false;
    private Rectangle initialScreen;

    public void init() {

        MouseController mc = new MouseController(this);

        Rectangle initialScreen = new Rectangle(10, 10, 800, 800);
        initialScreen.fill();
    }

    public void start() {

        gameStart = true;

        grid.gridInit();

        ships = shipFactory.createNavy();

        for (Ship ship : ships) {
            ship.fillShip();
            System.out.println(ship.getPositions()[0].getCol() + "," + ship.getPositions()[0].getRow());
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void hitGuess(int x, int y) {

        boolean outOfBounds = x < 0 || y < 0 || x >= Grid.COLS || y >= Grid.ROWS;

        if (outOfBounds) {
            return;
        }

        for (Ship ship : ships) {

            if (ship.isHit(x, y)) {
                ship.hit(x, y);
                return;
            }
        }

        grid.drawCross(x, y);

    }

    public boolean started() {
        return gameStart;
    }
}


