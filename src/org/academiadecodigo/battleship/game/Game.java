package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.Controller;
import org.academiadecodigo.battleship.grid.Graphics;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.battleship.grid.PositionGenerator;
import org.academiadecodigo.battleship.ship.Ship;
import org.academiadecodigo.battleship.ship.ShipFactory;
import org.academiadecodigo.battleship.sound.SoundManager;
import org.academiadecodigo.battleship.sound.SoundType;

public class Game {

    private Graphics graphics = new Graphics();
    private SoundManager soundManager = new SoundManager();
    private Grid grid = new Grid();
    private ShipFactory shipFactory = new ShipFactory();
    private Position[] alredyHit = new Position[23];
    private int index = 0;

    private Ship[] ships;

    public void init() {

        Controller mc = new Controller(this, graphics.getGameStats());
        soundManager.loop(SoundType.START);
        graphics.startScreen();

    }

    public void start(PositionGenerator generator) {

        graphics.getGameStats().startGame();

        soundManager.stop(SoundType.START);

        grid = new Grid(cols, rows);
        shipFactory.setGenerator(generator);
        ships = shipFactory.createNavy();

        graphics.gameInfo();
        graphics.shipsLeft();
    }

    public void hitGuess(int x, int y) {

        boolean outOfBounds = x < 0 || y < 0 || x >= Grid.COLS || y >= Grid.ROWS;

        if (outOfBounds) {
            return;
        }
        graphics.getGameStats().setShots();
        for (Ship ship : ships) {

            if (ship.containsPosition(x, y)) {

                alreadyHit(x, y);//MUdança

                ship.hit(x, y);
                graphics.setGameInfo(ship.getShipType().getName() + " HIT");

                if (ship.isDestroyed()) {
                    updateHUD(ship);
                }

                if (graphics.getGameStats().isGameFinished()) {
                    endGame();
                }
                return;
            }
        }

        graphics.drawMiss(x, y);

        soundManager.play(SoundType.MISS);

        graphics.setGameInfo("MISS");
        graphics.getGameStats().setMisses();
    }

    private void updateHUD(Ship ship) {
        graphics.getGameStats().kill(ship.getShipType());
        graphics.setGameInfo(ship.getShipType().getName() + " DESTROYED!");

        graphics.setShipsStats();
        graphics.getGameStats().shipsRemaining();
        graphics.setShipsLeftText();
    }

    private void alreadyHit(int x, int y) {//Mudança

        Position pos = new Position(x, y);
        alredyHit[index] = pos;
        index++;
    }

    public void endGame() {
        graphics.endScreen();
        graphics.gameResults();
        soundManager.loop(SoundType.END);
    }

    public Grid getGrid() {
        return grid;
    }

    public Position[] getAlredyHit() {//Mudança
        return alredyHit;
    }
}


