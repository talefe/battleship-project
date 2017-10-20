package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum ShipType {

    BATTLESHIP(5, new Color(102,0,0)),
    CRUISER(4, new Color(204,0,0)),
    SUBMARINE(3, new Color(255,51,51)),
    CARRIER(2, new Color(255,102,102));

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
