package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.game.EasyMode;
import org.academiadecodigo.battleship.game.Game;
import org.academiadecodigo.battleship.game.GameStats;
import org.academiadecodigo.battleship.game.HardMode;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Controller implements MouseHandler, KeyboardHandler {

    private GameStats gameStats;
    private Game game;

    public Controller(Game game, GameStats gameStats) {

        this.game = game;
        this.gameStats = gameStats;
        init();
    }

    public void init() {

        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent h = new KeyboardEvent();
        h.setKey(KeyboardEvent.KEY_H);
        h.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(h);

        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_E);
        e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = game.getGrid().pixelToCol((int) e.getX() - Grid.PADDING);
        int y = game.getGrid().pixelToRow((int) e.getY() - Grid.PADDING - Grid.MOUSESHIT);

        Position pos = new Position(x, y);

        if (e.getX() < Grid.PADDING) {
            x = -1;
        } else if (e.getY() < Grid.PADDING + 23) {
            y = -1;
        }


        // FIX THIS
        if (pos.isClicked()) {
            return;
        }

        if (!gameStats.isGameFinished()) {
            game.hitGuess(x, y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == keyboardEvent.KEY_E) {
            if (!gameStats.isGameStarted()) {

                game.start(new EasyMode());
            }

        } else if (keyboardEvent.getKey() == keyboardEvent.KEY_H) {
            if (!gameStats.isGameStarted()) {

                game.start(new HardMode());
            }

        } else {
            System.out.println("not a valid key");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
