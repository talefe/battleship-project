package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.grid.Direction;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.battleship.grid.PositionGenerator;

public class EasyMode extends PositionGenerator {

    private int size;
    public Position[] occupiedPositions = new Position[20];
    private boolean worked = false;
    private Direction direction;


    @Override
    public Position[] generate(int size) {

        worked = false;
        Position[] positions = new Position[size];

        while (!worked) {

            worked = true;
            positions[0] = new Position();
            direction = Direction.randomDirection();

            int x = positions[0].getCol();
            int y = positions[0].getRow();

            for (int i = 1; i < positions.length; i++) {
                x += direction.getX();
                y += direction.getY();

                if (x < 0 || y < 0 || x > Grid.COLS - 1 || y > Grid.ROWS - 1)
                    worked = false;

                positions[i] = new Position(x, y);

                if (lookAroundYou(positions[i])) {
                    return generate(size);
                }
            }
        }

        return super.checkIfOccupied(positions);
    }


    public boolean lookAroundYou(Position pos) {

        boolean aroundYou = false;

        for (int i = 0; i < Direction.values().length; i++) {

            int x = pos.getCol() + Direction.values()[i].getX();
            int y = pos.getRow() + Direction.values()[i].getY();

            for (int j = 0; j < occupiedPositions.length; j++) {

                if (occupiedPositions[j] != null) {

                    if (x == occupiedPositions[j].getCol() && y == occupiedPositions[j].getRow()) {

                        aroundYou = true;

                    }
                }
            }
        }

        return aroundYou;
    }
}
