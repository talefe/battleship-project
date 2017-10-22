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


                // trying to iterate over enum of ShipType to create ships according to numShips

                /* for (ShipType type : ShipType.values()) {

                    for (int i = 0; i < type.getNumShips(); i++) {

                        new Ship(type);
                    }
                } */


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
