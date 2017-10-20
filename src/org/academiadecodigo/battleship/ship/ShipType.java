package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum ShipType {

    BATTLESHIP(5, Color.RED),
    CRUISER(4,Color.RED),
    SUBMARINE(3, Color.RED),
    CARRIER(2, Color.RED);

    private int numPositions;
    private Color color;


    ShipType(int numPositions, Color color) {
        this.numPositions = numPositions;
        this.color = color;

    }

    public int getNumPositions() {
        return numPositions;
    }

    public Color getColor(){
        return color;
    }
}
