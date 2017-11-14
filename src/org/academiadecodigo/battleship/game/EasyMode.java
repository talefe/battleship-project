package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.grid.Direction;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.battleship.grid.PositionGenerator;

public class EasyMode extends PositionGenerator {

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

            for (int i = 0; i < positions.length; i++) {
                x += direction.getCol();
                y += direction.getY();

                if (x < 0 || y < 0 || x > Grid.COLS - 1 || y > Grid.ROWS - 1)
                    worked = false;

                positions[i] = new Position(x, y);

                if (lookAroundYou(positions[i])) {
                    return generate(size);
                }
            }
        }

        return checkIfOccupied(positions);
    }

    public boolean lookAroundYou(Position pos) {

        boolean aroundYou = false;

        for (int i = 0; i < Direction.values().length; i++) {

            int x = pos.getCol() + Direction.values()[i].getCol();
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

    public Position[] checkIfOccupied(Position[] positions) {

        Position[] temporaryPositions = new Position[positions.length];

        for (int i = 0; i < positions.length; i++) {

            for (int j = 0; j < occupiedPositions.length; j++) {

                if (occupiedPositions[0] != null) {

                    if (occupiedPositions[j] != null) {
                        if (positions[i].getCol() == occupiedPositions[j].getCol() && positions[i].getRow() == occupiedPositions[j].getRow()) {

                            return generate(positions.length);
                        }
                    }

                }
            }

            temporaryPositions[i] = positions[i];

        }

        int counter = 0;

        for (int i = 0; i < occupiedPositions.length; i++) {

            if (occupiedPositions[i] == null) {

                occupiedPositions[i] = temporaryPositions[counter];

                counter++;

                if (counter > temporaryPositions.length - 1) {
                    break;
                }
            }
        }
        return positions;
    }
}
