package org.academiadecodigo.battleship.ship;

import org.academiadecodigo.battleship.grid.Graphics;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.battleship.sound.SoundManager;
import org.academiadecodigo.battleship.sound.SoundType;

public class Ship {

    private ShipType shipType;
    private Position[] positions;
    private int life;
    private boolean destroyed = false;
    private SoundManager soundManager = new SoundManager();
    private Graphics graphics;


    public Ship(ShipType shipType) {
        this.shipType = shipType;
        destroyed = false;
        life = shipType.getNumPositions();
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public boolean containsPosition(int x, int y) {
        for (Position pos : positions) {
            if (pos.areCoordinatesEqual(x, y)) {
                return true;
            }
        }

        return false;
    }

    public void hit(int x, int y) {

        for (Position pos : positions) {

            if (pos.areCoordinatesEqual(x, y)) {

                life--;
                soundManager.play(SoundType.HIT);

                if (life == 0) {

                    destroyed = true;
                    soundManager.play(SoundType.DESTROYED);
                }
            }
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
