package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.Controller;
import org.academiadecodigo.battleship.grid.Graphics;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.PositionGenerator;
import org.academiadecodigo.battleship.ship.Ship;
import org.academiadecodigo.battleship.ship.ShipFactory;
import org.academiadecodigo.battleship.sound.SoundManager;
import org.academiadecodigo.battleship.sound.SoundType;

public class Game {

    private Graphics graphics = new Graphics();
    private SoundManager soundManager = new SoundManager();
    private Grid grid = new Grid();
    private GameStats gameStats = new GameStats();
    private ShipFactory shipFactory = new ShipFactory();

    private Ship[] ships;


    public void init() {

        Controller mc = new Controller(this, gameStats);

        graphics.startScreen();

        soundManager.loop(SoundType.START);
    }

    public void start(PositionGenerator generator) {

        gameStats.startGame();

        soundManager.stop(SoundType.START);

        grid.gridInit();

        shipFactory.setGenerator(generator);
        ships = shipFactory.createNavy();

        graphics.gameInfo();

    }

    public void hitGuess(int x, int y) {

        boolean outOfBounds = x < 0 || y < 0 || x >= Grid.COLS || y >= Grid.ROWS;

        if (outOfBounds) {
            return;
        }

        for (Ship ship : ships) {

            if (ship.isHit(x, y)) {

                ship.hit(x, y);

                graphics.drawHit(x, y);

                graphics.setGameInfo(ship.getShipType().getName() + " HIT");

                gameStats.shipTypeLife(ship.getShipType());

                if(ship.isDestroyed()){

                    gameStats.killShip();
                    graphics.setGameInfo(ship.getShipType().getName() + " DESTROYED!");
                }

                if (gameStats.isGameFinished()) {
                    endGame();
                }
                return;
            }
        }

        graphics.drawMiss(x, y);

        soundManager.play(SoundType.MISS);

        graphics.setGameInfo("MISS");
    }

    public void endGame() {
        graphics.endScreen();
        soundManager.loop(SoundType.END);
    }

    public Grid getGrid() {
        return grid;
    }
}


