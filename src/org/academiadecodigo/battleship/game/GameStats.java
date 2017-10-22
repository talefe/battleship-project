package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.ship.ShipType;

// MAKE THIS BETTER, ADD MORE VARIABLES

public class GameStats {

    private boolean gameStart = false;
    private boolean gameFinished = false;
    private int liveships = getLiveships();  // need to decrement liveships when ships are destroyed

    public boolean isGameStart() {
        return gameStart;
    }

    public int getLiveships() {

        for (ShipType type : ShipType.values()) {
            liveships += type.getNumShips();
        }

        return liveships;
    }

    public boolean isGameFinished() {

        if (liveships == 0) {
            gameFinished = true;
            return gameFinished;
        }
        return false;
    }

    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }
}
