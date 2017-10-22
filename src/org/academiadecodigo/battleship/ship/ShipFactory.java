package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.PositionGenerator;

public class ShipFactory {

    private PositionGenerator generator;
    private Ship[] navy = new Ship[getTotalShips()];


    public Ship[] createNavy() {

        int index = 0;

        for (ShipType type : ShipType.values()) {

            for (int i = 0; i < type.getNumShips(); i++) {

                navy[index] = new Ship(type);
                index++;
            }
        }

        for (Ship ship : navy) {

            int size = ship.getShipType().getNumPositions();
            ship.setPositions(generator.generate(size));
        }

        return navy;
    }

    public void setGenerator(PositionGenerator generator) {
        this.generator = generator;
    }


    public int getTotalShips() {

        int total = 0;

        for (int i = 0; i < ShipType.values().length; i++) {

            total += ShipType.values()[i].getNumShips();
        }
        return total;
    }
}
