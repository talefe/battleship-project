package org.academiadecodigo.battleship.ship;

public enum ShipType {

    BATTLESHIP(4),
    CRUISER(3),
    SUBMARINE(2),
    CARRIER(1);

    private int numPositions;

    ShipType(int numPositions) {
        this.numPositions = numPositions;
    }

    public int getNumPositions() {
        return numPositions;
    }
}
