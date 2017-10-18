package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.grid.Grid;
import org.academiadecodigo.battleship.ship.Ship;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 14/10/17.
 */
public class Game {

    private Grid grid = new Grid();
    private Rectangle cell;
    Ship ship1 = new Ship();
    Ship ship2 = new Ship();
    private Ship[] ships = new Ship[2];
    //private Ship[] ships = new Ship[2];

    public void init() {

        ships[0] = ship1;
        grid.gridInit();
    }

    public Grid getGrid() {
        return grid;
    }

    public void drawCell(int x, int y) {

        if (x < 0 || y < 0) {
            System.out.println("x out of bounds");
            System.out.println("y out of bounds");
            return;
        } else if (x >= grid.getCols() || y >= grid.getRows()) {
            System.out.println("x out of bounds");
            System.out.println("y out of bounds");
            return;
        }

        System.out.println("x:" + x);
        System.out.println("y:" + y);

        Rectangle cell = new Rectangle(grid.colToPixel(x), grid.rowToPixel(y), grid.getCellSize(), grid.getCellSize());

        for (int i = 0; i < ships.length; i++) {

            if (x == ships[i].getFirstPosition().getCol() && y == ships[i].getFirstPosition().getRow()) {
                cell.setColor(Color.RED);
                System.out.println(("hit--"));
                cell.fill();
                break;


            } else {

                System.out.println("miss");
                cell.setColor(Color.BLUE);
                cell.fill();

            }
        }


    }

    public Rectangle getCell() {
        return cell;
    }
}


