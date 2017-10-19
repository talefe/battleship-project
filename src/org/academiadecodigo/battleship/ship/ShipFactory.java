package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.Direction;
import org.academiadecodigo.battleship.grid.Position;

public class ShipFactory {

    private ShipType shiptype;
    private Ship[] navy;

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
            ship.setPositions(generatePosShip(ship.getShipType()));
        }

        return navy;
    }

    public Position[] generatePosShip(ShipType shipType) {

        boolean worked = false;
        Position[] positions = new Position[shipType.getNumPositions()];

        while (!worked) {

            worked = true;
            positions[0] = new Position(); // Obter 1º posição random

            switch (Direction.direction()) {

                case LEFT:
                    System.out.println("LEFT"); // decrementar uma casa a coluna

                    for (int i = 1; i < positions.length; i++) {

                        positions[i] = new Position((positions[i - 1].getCol() - 1), (positions[i - 1].getRow()));
                        if (positions[i].getCol() < 0)                               // SE Houver valores negativos
                            worked = false;                                     //significa q esta fora da grelha
                    }                                                           //volta a calcular random
                    break;

                case RIGHT:
                    System.out.println("RIGHT"); // incrementar uma casa a coluna

                    for (int i = 1; i < positions.length; i++) {

                        positions[i] = new Position((positions[i - 1].getCol() + 1), (positions[i - 1].getRow()));
                        if (positions[i].getCol() > 10)
                            worked = false;
                    }
                    break;

                case UP:
                    System.out.println("UP"); // decrementar  1 casa a row
                    for (int i = 1; i < positions.length; i++) {

                        positions[i] = new Position((positions[i - 1].getCol()), (positions[i - 1].getRow() - 1));
                        if (positions[i].getRow() < 0)
                            worked = false;
                    }
                    break;

                case DOWN:
                    System.out.println("DOWN"); // incrementar uma casa a row
                    for (int i = 1; i < positions.length; i++) {

                        positions[i] = new Position((positions[i - 1].getCol()), (positions[i - 1].getRow() + 1));
                        if (positions[i].getRow() > 10)
                            worked = false;
                    }
                    break;
            }
        }
        return positions;
    }
}
