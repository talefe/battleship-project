package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseController implements MouseHandler {

    private Game game;

    public MouseController(Game g) {

        game = g;

        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!game.started()) {
            game.start();
            return;
        }

        int x = game.getGrid().pixelToCol((int) e.getX() - Grid.PADDING);
        int y = game.getGrid().pixelToRow((int) e.getY() - Grid.PADDING - Grid.MOUSESHIT);

        if (e.getX() < Grid.PADDING) {
            x = -1;
        } else if (e.getY() < Grid.PADDING + 23) {
            y = -1;
        }
        for (int i = 0; i <Game.index ; i++) {

            if(x ==game.getHitPositions()[i].getCol() && y == game.getHitPositions()[i].getRow()){
                return;
            }

        }


        if(!game.isGameFinished()) {
            game.hitGuess(x, y);
        }
    }

    //added method hitShip
    public void hitShip() {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
