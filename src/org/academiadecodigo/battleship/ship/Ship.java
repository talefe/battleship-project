package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Ship {

    private int numPos;
    private Position firstPosition;
    private boolean destroyed;

    public Ship() {
        firstPosition = new Position();

        destroyed = false;

        Rectangle ship = new Rectangle(Grid.colToPixel(firstPosition.getCol()), Grid.rowToPixel(firstPosition.getRow()), Grid.CELLSIZE, Grid.CELLSIZE);
        ship.fill();
    }

    public Position getFirstPosition() {
        return firstPosition;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
