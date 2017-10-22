package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.ship.ShipType;

public class GameStats {

    private boolean gameStarted = false;
    private boolean gameFinished = false;
    private int liveShips = getLiveShips();

    private int battleship = ShipType.BATTLESHIP.getNumShips();
    private int cruiser = ShipType.CRUISER.getNumShips();
    private int submarine = ShipType.SUBMARINE.getNumShips();
    private int smallShip = ShipType.SMALL_SHIP.getNumShips();

    private int shots = 0;
    private int misses = 0;
    private int score = 0;

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void startGame() {
        gameStarted = true;
    }

    public int getLiveShips() {

        for (ShipType type : ShipType.values()) {
            liveShips += type.getNumShips();
        }

        return liveShips;
    }

    public boolean isGameFinished() {

        if (liveShips == 0) {

            gameFinished = true;
            return gameFinished;
        }

        return false;
    }

    public void shipTypeLife(ShipType type) {

        switch (type) {
            case BATTLESHIP:
                battleship--;
                break;
            case CRUISER:
                cruiser--;
                break;
            case SUBMARINE:
                submarine--;
                break;
            case SMALL_SHIP:
                smallShip--;
                break;
        }
    }

    public void killShip() {
        liveShips--;
    }

    public int shipsRemaining(){

        return liveShips;
    }

    public int getBattleship() {
        return battleship;
    }
}
