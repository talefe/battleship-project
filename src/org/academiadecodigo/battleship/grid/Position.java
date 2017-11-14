package org.academiadecodigo.battleship.grid;

import org.academiadecodigo.battleship.representation.PositionRepresentation;
import org.academiadecodigo.battleship.ship.Ship;

public class Position {

    private int col;
    private int row;

    private PositionRepresentation representation;
    private Ship ship;

    private boolean hit = false;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
        representation = new PositionRepresentation(col, row);
        representation.draw();
    }

    public void putShip(Ship ship) {
        this.ship = ship;
    }

    public boolean isHit() {
        return hit;
    }

    public void hit() {
        hit = true;
        representation.hit(ship != null);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean areCoordinatesEqual(int x, int y) {
        return this.col == x && this.row == y;
    }

}

