package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.Direction;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;

public class ShipFactory {

    private int size;
    private Ship[] navy;
    private boolean worked = false;
    public Position[] occupiedPositions = new Position[20];
    private Direction direction;


    public Ship[] createNavy() {

        Ship[] navy = new Ship[]{
                new Ship(ShipType.BATTLESHIP),
                new Ship(ShipType.CRUISER),
                new Ship(ShipType.CRUISER),
                new Ship(ShipType.SUBMARINE),
                new Ship(ShipType.SUBMARINE),
                new Ship(ShipType.CARRIER),
                new Ship(ShipType.CARRIER)

        };

        for (Ship ship : navy) {
            size = ship.getShipType().getNumPositions();

            ship.setPositions(generateShipPositions(size));
        }

        return navy;
    }

    public Position[] generateShipPositions(int size) {

        worked = false;
        Position[] positions = new Position[size];

        while (!worked) {

            worked = true;
            positions[0] = new Position();
            direction = Direction.direction();

            int x = positions[0].getCol();
            int y = positions[0].getRow();

            for (int i = 1; i < positions.length; i++) {
                x += direction.getX();
                y += direction.getY();

                if (x < 0 || y < 0 || x > Grid.COLS - 1 || y > Grid.ROWS - 1)
                    worked = false;

                positions[i] = new Position(x, y);

                if (lookAroundYou(positions[i])){
                    return generateShipPositions(size);
                }

            }
        }

        return checkIfOccupied(positions);
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

    private Position[] checkIfOccupied(Position[] positions) {

        Position[] temporaryPositions = new Position[positions.length];

        for (int i = 0; i < positions.length; i++) {

            //checking if new ship positions are already inside of occupiedPositions array
            for (int j = 0; j < occupiedPositions.length; j++) {

                if (occupiedPositions[0] != null) {

                    if (occupiedPositions[j] != null) {
                        if (positions[i].getCol() == occupiedPositions[j].getCol() && positions[i].getRow() == occupiedPositions[j].getRow()) {
                            System.out.println("igual" + " col : " + positions[i].getCol() + " row : " + positions[i].getRow());

                            return generateShipPositions(positions.length);
                        }
                    }

                }
            }

            temporaryPositions[i] = positions[i];

        }

        //place validated position inside occupiedPositions array

        int counter = 0;

        for (int i = 0; i < occupiedPositions.length; i++) {

            if (occupiedPositions[i] == null) {

                occupiedPositions[i] = temporaryPositions[counter];

                counter++;

                if (counter > temporaryPositions.length - 1) {///avoids getting out of temporary array index bound
                    break;
                }
            }
        }
        return positions;
    }
}
