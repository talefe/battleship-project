package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Ship {

    private Position position;
    private boolean destroyed;

    public Ship() {
        position = new Position();
        destroyed = false;

        Rectangle ship = new Rectangle(Grid.colToPixel(position.getCol()), Grid.rowToPixel(position.getRow()), Grid.CELLSIZE, Grid.CELLSIZE);
        ship.fill();
    }

    public Position getPosition() {
        return position;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
