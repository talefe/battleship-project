package org.academiadecodigo.battleship.game;

import org.academiadecodigo.battleship.grid.PositionGenerator;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


// THIS IS NOT WORKING!
// TRYING TO ASK FOR INPUT TO CHOSE HARD OR EASY MODE OF POSITION GENERATOR..


// NOT SURE IF THIS SHOULD BE IMPLEMENTED IN SEPARATE CLASS LIKE THIS OR IN GAME


public class PickMode implements KeyboardHandler {

    private Keyboard keyboard = new Keyboard(this);
    private PositionGenerator generator;

    public void init() {

        KeyboardEvent h = new KeyboardEvent();
        h.setKey(KeyboardEvent.KEY_H);
        h.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(h);

        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_H);
        e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(e);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == keyboardEvent.KEY_E) {
            generator = new EasyMode();

        } else if (keyboardEvent.getKey() == keyboardEvent.KEY_H) {
            generator = new HardMode();

        } else {
            System.out.println("not a valid key");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
