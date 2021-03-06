package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.ship.ShipType;

public class GameStats {

    private boolean gameStarted = false;
    private boolean gameFinished = false;
    private int totalShips = getTotalShips();

    private int battleship = ShipType.BATTLESHIP.getNumShips();
    private int cruiser = ShipType.CRUISER.getNumShips();
    private int submarine = ShipType.SUBMARINE.getNumShips();
    private int carrier = ShipType.SMALL_SHIP.getNumShips();

    private int shots = 0;
    private int misses = 0;
    private int score = 100;

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void startGame() {
        gameStarted = true;
    }

    public int getTotalShips() {

        for (ShipType type : ShipType.values()) {
            totalShips += type.getNumShips();
        }

        return totalShips;
    }

    public boolean isGameFinished() {

        if (shipsRemaining() == 0) {

            gameFinished = true;
            return gameFinished;
        }

        return false;
    }

    public void kill(ShipType type) {

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
                carrier--;
                break;
        }
    }

    public int shipsRemaining(){
        return battleship + cruiser + submarine + carrier;
    }

    public int getBattleship() {
        return battleship;
    }

    public int getCruiser() {
        return cruiser;
    }

    public int getSubmarine() {
        return submarine;
    }

    public int getCarrier() {
        return carrier;
    }

    public void setShots() {
        shots++;
    }

    public void setMisses(){
        score--;
        misses++;
    }

    public int getScore() {
        return score;
    }

    public int getShots() {
        return shots;
    }

    public int getMisses() {
        return misses;
    }
}

