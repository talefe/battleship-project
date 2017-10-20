package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Ship {

    private ShipType shipType;
    private Position[] positions;
    private int life;
    private boolean destroyed = false;


    public Ship(ShipType shipType) {
        this.shipType = shipType;
        destroyed = false;
        life = shipType.getNumPositions();
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
                life--;
                System.out.println(this.shipType + " HIT");
                Rectangle cell = new Rectangle(Grid.colToPixel(x) +1, Grid.rowToPixel(y) +1, Grid.CELLSIZE -1, Grid.CELLSIZE-1);
                cell.setColor(this.shipType.getColor());
                cell.fill();

                if(life == 0){
                    System.out.println(this.shipType + " DESTROYED");
                    destroyed = true;

                }
            }
        }
    }

    public boolean isDestroyed(){
        return destroyed;
    }


}
