package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.battleship.ship.Ship;
import org.academiadecodigo.battleship.ship.ShipFactory;
import org.academiadecodigo.battleship.ship.ShipType;
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

    public void init() {

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

    public void drawCell(int x, int y) {

        // variable to check if mouse position is out of bounds. that way we can call the variable later
        boolean outOfBounds = x < 0 || y < 0 || x >= grid.getCols() || y >= grid.getRows();

        if (outOfBounds) {
            System.out.println("position out of bounds!");
            return;
        }

        Line lineA = new Line(grid.colToPixel(x), grid.rowToPixel(y), grid.colToPixel(x) + grid.getCellSize(), grid.rowToPixel(y) + grid.getCellSize());
        lineA.setColor(Color.GREEN);
        Line lineB = new Line(grid.colToPixel(x), grid.rowToPixel(y) + grid.getCellSize(), grid.colToPixel(x) + grid.getCellSize(), grid.rowToPixel(y));
        lineB.setColor(Color.GREEN);

        System.out.println("x: " + x + " || y: " + y);

        for (Ship ship : ships) {

            if (ship.isHit(x, y)) {
                ship.hit(x, y);
                return;
            }
        }

        lineA.draw();
        lineB.draw();

    }

    public Rectangle getCell() {
        return cell;
    }
}


