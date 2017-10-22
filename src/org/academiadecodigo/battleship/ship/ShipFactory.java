package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.PositionGenerator;

public class ShipFactory {

    private PositionGenerator generator;
    private Ship[] navy;


    public Ship[] createNavy() {

        navy = new Ship[]{
                new Ship(ShipType.BATTLESHIP),
                new Ship(ShipType.CRUISER),
                new Ship(ShipType.CRUISER),
                new Ship(ShipType.SUBMARINE),
                new Ship(ShipType.SUBMARINE),
                new Ship(ShipType.SMALL_SHIP),
                new Ship(ShipType.SMALL_SHIP)
        };

        for (Ship ship : navy) {

            int size = ship.getShipType().getNumPositions();
            ship.setPositions(generator.generate(size));
        }

        return navy;
    }

    public void setGenerator(PositionGenerator generator) {
        this.generator = generator;
    }

}
