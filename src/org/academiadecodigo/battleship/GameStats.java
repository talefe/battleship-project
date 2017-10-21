package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.ship.ShipType;

public class GameStats {

    private boolean gameStart = false;
    private boolean gameFinished = false;
    private int liveships;

    public boolean isGameStart() {
        return gameStart;
    }

    public int getLiveships() {

        for (ShipType type : ShipType.values()) {
            liveships += type.getNumShips();
            System.out.println(liveships);
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
