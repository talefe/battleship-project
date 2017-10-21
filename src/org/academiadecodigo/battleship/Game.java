package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.grid.Graphics;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.ship.Ship;
import org.academiadecodigo.battleship.ship.ShipFactory;
import org.academiadecodigo.battleship.sound.SoundManager;
import org.academiadecodigo.battleship.sound.SoundType;

/**
 * Created by codecadet on 14/10/17.
 */
public class Game {

    private GameStats gameStats = new GameStats();
    private Grid grid = new Grid();
    private SoundManager soundManager = new SoundManager();
    private ShipFactory shipFactory = new ShipFactory();
    private Graphics graphics = new Graphics();

    private Ship[] ships;

    public void init() {

        MouseController mc = new MouseController(this, gameStats);

        graphics.startScreen();
        soundManager.play(SoundType.START);
    }

    public void start() {

        gameStats.setGameStart(true);

        soundManager.stop(SoundType.START);

        grid.gridInit();

        ships = shipFactory.createNavy();

        graphics.shipsLeft();

        graphics.gameInfo();
    }

    public void endGame() {
        graphics.endScreen();
        soundManager.play(SoundType.END);
    }

    public void hitGuess(int x, int y) {

        boolean outOfBounds = x < 0 || y < 0 || x >= Grid.COLS || y >= Grid.ROWS;

        if (outOfBounds) {
            return;
        }

        for (Ship ship : ships) {

            if (ship.isHit(x, y)) {
                ship.hit(x, y);
            }

            if (gameStats.isGameFinished()) {
                endGame();
            }

            return;
        }

        graphics.drawMiss(x, y);
    }

    public boolean started() {
        return gameStats.isGameStart();
    }

    public Grid getGrid() {
        return grid;
    }
}


