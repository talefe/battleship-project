package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseController implements MouseHandler {

    private Game game = new Game();
    private int x;
    private int y;

    public MouseController() {
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        game.init();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        x = game.getGrid().pixelToCol((int) e.getX() - Grid.PADDING);
        y = game.getGrid().pixelToRow((int) e.getY() - Grid.PADDING - Grid.MOUSESHIT);

        if(e.getX() < Grid.PADDING) {
            x = - 1;
        } else if(e.getY() < Grid.PADDING + 23) {
            y = -1;
        }

        game.drawCell(x, y);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public int getX() {
        return x + Grid.PADDING;
    }

    public int getY() {
        return y;
    }
}
