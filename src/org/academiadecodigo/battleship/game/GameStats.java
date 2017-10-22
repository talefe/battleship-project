package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.ship.ShipType;

// MAKE THIS BETTER, ADD MORE VARIABLES

public class GameStats {

    private boolean gameStart = false;
    private boolean gameFinished = false;
    private int liveships = getLiveships();

    private int battleship = ShipType.BATTLESHIP.getNumShips();
    private int cruiser = ShipType.CRUISER.getNumShips();
    private int submarine = ShipType.SUBMARINE.getNumShips();
    private int smallShip = ShipType.SMALL_SHIP.getNumShips();

    public GameStats(){

    }

    public boolean isGameStart() {
        return gameStart;
    }

    public int getLiveships() {

        for (ShipType type : ShipType.values()) {
            liveships += type.getNumShips();
        }

        return liveships;
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

    public void setLiveships() {
        liveships--;
    }

    public int shipsRemaining(){

        return liveships;
    }

    public int getBattleship() {
        return battleship;
    }
}
