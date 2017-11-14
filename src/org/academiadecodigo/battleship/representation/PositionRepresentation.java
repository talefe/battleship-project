package org.academiadecodigo.battleship.representation;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PositionRepresentation implements Representation {

    private Rectangle cell;

    public PositionRepresentation(int col, int row) {
        cell = new Rectangle(col * Grid.CELLSIZE + Grid.PADDING,
                row * Grid.CELLSIZE + Grid.PADDING,
                Grid.CELLSIZE,
                Grid.CELLSIZE);
        cell.setColor(Color.GREEN);
    }

    @Override
    public void draw() {
        cell.draw();
    }

    public void hit(boolean hasShip) {
        if (hasShip) {
            // draw cross
        }

        // draw rectangle
    }

}
