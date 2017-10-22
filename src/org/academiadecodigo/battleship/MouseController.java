package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.game.Game;
import org.academiadecodigo.battleship.game.GameStats;
import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.grid.Position;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseController implements MouseHandler {

    private GameStats gameStats;
    private Game game;

    public MouseController(Game game, GameStats gameStats) {

        this.game = game;
        this.gameStats = gameStats;

        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!gameStats.isGameStarted()) {
            game.start();
            return;
        }

        int x = game.getGrid().pixelToCol((int) e.getX() - Grid.PADDING);
        int y = game.getGrid().pixelToRow((int) e.getY() - Grid.PADDING - Grid.MOUSESHIT);

        Position pos = new Position(x, y);

        if (e.getX() < Grid.PADDING) {
            x = -1;
        } else if (e.getY() < Grid.PADDING + 23) {
            y = -1;
        }

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
}
