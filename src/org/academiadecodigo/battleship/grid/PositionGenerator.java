package org.academiadecodigo.battleship.grid;

public abstract class PositionGenerator {

    public Position[] occupiedPositions = new Position[20];
    private boolean isShipPlaceable = false;
    private Direction direction;

    public Position[] generate(int size) {

        isShipPlaceable = false;
        Position[] positions = new Position[size];

        while (!isShipPlaceable) {

            positions[0] = new Position();
            direction = Direction.randomDirection();

            int col = positions[0].getCol();
            int row = positions[0].getRow();

            for (int i = 0; i < positions.length; i++) {
                col += direction.getCol();
                row += direction.getRow();

                if (!(col < 0 || row < 0 || col > Grid.COLS - 1 || row > Grid.ROWS - 1)) {
                    isShipPlaceable = true;
                }
                positions[i] = new Position(col, row);
            }
        }

        return checkIfOccupied(positions);
    }

    public Position[] checkIfOccupied(Position[] positions) {

        Position[] temporaryPositions = new Position[positions.length];

        for (int i = 0; i < positions.length; i++) {

            for (int j = 0; j < occupiedPositions.length; j++) {

                if (occupiedPositions[j] != null) {
                    if (positions[i].getCol() == occupiedPositions[j].getCol() && positions[i].getRow() == occupiedPositions[j].getRow()) {

                        return generate(positions.length);
                    }
                }

            }

            temporaryPositions[i] = positions[i];
        }

        int counter = 0;
        for (int i = 0; i < occupiedPositions.length; i++) {

            if (occupiedPositions != null) {
                continue;
            }

            occupiedPositions[i] = temporaryPositions[counter];
            counter++;

            if (counter > temporaryPositions.length - 1) {
                break;
            }
        }
        return positions;
    }
}
