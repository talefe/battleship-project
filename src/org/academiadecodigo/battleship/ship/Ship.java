package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Ship {

    private ShipType shipType;
    private Position[] positions;
    private boolean destroyed;


    public Ship(ShipType shipType) {
        this.shipType = shipType;
        destroyed = false;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public void fillShip() {

        for (Position pos : positions) {

            Rectangle ship = new Rectangle(Grid.colToPixel(pos.getCol()), Grid.rowToPixel(pos.getRow()), Grid.CELLSIZE, Grid.CELLSIZE);
            ship.setColor(Color.GREEN);
            ship.fill();
        }
    }

    public Position[] getPositions() {
        return positions;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public boolean isHit(int x, int y) {

        for (Position pos : positions) {

            if (pos.areCoordinatesEqual(x, y)) {
                return true;
            }
        }

        return false;
    }

    public void hit(int x, int y) {

        for (Position pos : positions) {

            if (pos.areCoordinatesEqual(x, y)) {
                pos.hit();
            }
        }
    }
}
