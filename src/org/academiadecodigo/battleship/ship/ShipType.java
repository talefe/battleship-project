package org.academiadecodigo.battleship.ship;

public enum ShipType {

    BATTLESHIP("Battleship", 1, 5),
    CRUISER("Cruiser", 2, 4),
    SUBMARINE("Submarine", 2, 3),
    CARRIER("Carrier", 2, 2);

    private String name;
    private int numShips;
    private int numPositions;

    ShipType(String name, int numShips, int numPositions) {
        this.name = name;
        this.numShips = numShips;
        this.numPositions = numPositions;
    }

    public String getName() {
        return name;
    }

    public int getNumShips() {
        return numShips;
    }

    public int getNumPositions() {
        return numPositions;
    }
}
