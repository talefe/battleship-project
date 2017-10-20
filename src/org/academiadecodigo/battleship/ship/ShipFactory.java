package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.Direction;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;

public class ShipFactory {

    private int size;
    private Ship[] navy;
    public Position[] validPositions = new Position[20];


    public Ship[] createNavy() {

        Ship[] navy = new Ship[]{
                new Ship(ShipType.BATTLESHIP),
                new Ship(ShipType.CRUISER),
                new Ship(ShipType.CRUISER),
                new Ship(ShipType.SUBMARINE),
                new Ship(ShipType.SUBMARINE),
                new Ship(ShipType.SUBMARINE),
                new Ship(ShipType.CARRIER),
                new Ship(ShipType.CARRIER),
                new Ship(ShipType.CARRIER),
                new Ship(ShipType.CARRIER)

        };

        for (Ship ship : navy) {
            size = ship.getShipType().getNumPositions();

            ship.setPositions(generatePosShip(size));
        }

        return navy;
    }

    public Position[] generatePosShip(int size) {

        Position[] positions = new Position[size];
        boolean worked = false;

        while (!worked) {

            worked = true;
            positions[0] = new Position();

            switch (Direction.direction()) {

                case LEFT:

                    for (int i = 1; i < positions.length; i++) {

                        positions[i] = new Position((positions[i - 1].getCol() - 1), (positions[i - 1].getRow()));
                        if (positions[i].getCol() < 0)
                            worked = false;
                    }
                    break;

                case RIGHT:

                    for (int i = 1; i < positions.length; i++) {

                        positions[i] = new Position((positions[i - 1].getCol() + 1), (positions[i - 1].getRow()));
                        if (positions[i].getCol() > Grid.COLS - 1)
                            worked = false;
                    }
                    break;

                case UP:

                    for (int i = 1; i < positions.length; i++) {

                        positions[i] = new Position((positions[i - 1].getCol()), (positions[i - 1].getRow() - 1));
                        if (positions[i].getRow() < 0)
                            worked = false;
                    }
                    break;

                case DOWN:

                    for (int i = 1; i < positions.length; i++) {

                        positions[i] = new Position((positions[i - 1].getCol()), (positions[i - 1].getRow() + 1));
                        if (positions[i].getRow() > Grid.ROWS - 1)
                            worked = false;
                    }
                    break;
            }
        }

        return checkValid(positions);
    }

    private Position[] checkValid(Position[] positions) {

        Position[] temporaryValidPositions = new Position[positions.length];

        for (int i = 0; i < positions.length; i++) {

            //checking if new ship positions are already inside of validPositions array
            for (int j = 0; j < validPositions.length; j++) {

                if (validPositions[0] != null) {

                    if(validPositions[j] != null) {
                        if (positions[i].getCol() == validPositions[j].getCol() && positions[i].getRow() == validPositions[j].getRow()) {
                            System.out.println("igual" + " col : " + positions[i].getCol() + " row : " + positions[i].getRow());

                            return generatePosShip(positions.length);
                        }
                    }

                }
            }

            temporaryValidPositions[i] = positions[i];

        }

        //place validated position inside validPositions array

        int counter = 0;

        for (int i = 0; i < validPositions.length; i++) {

            if (validPositions[i] == null) {

                validPositions[i] = temporaryValidPositions[counter];

                counter++;

                if (counter > temporaryValidPositions.length - 1) {///avoids getting out of temporary array index bound
                    break;
                }
            }
        }
        return positions;
    }
}
