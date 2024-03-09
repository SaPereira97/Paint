import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class MyKeyboard implements KeyboardHandler {

    private final Keyboard keyboard = new Keyboard(this);

    private Painter painter;
    private Grid grid;


    public MyKeyboard(Painter painter, Grid grid) {
        this.painter = painter;
        this.grid = grid;
        addKeyboard();
    }

    public void addKeyboard() {
        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_SPACE);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paint);

        KeyboardEvent erase = new KeyboardEvent();
        erase.setKey(KeyboardEvent.KEY_C);
        erase.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(erase);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        if (key == 38) {
            if (painter.getY() == 10) {
                return;
            }
            this.painter.moveUp();
        }
        int key2 = keyboardEvent.getKey();
        if (key2 == 40) {
            if (painter.getY() == 880) {
                return;
            }
            this.painter.moveDown();
        }
        int key3 = keyboardEvent.getKey();
        if (key3 == 37) {
            if (painter.getX() == 10) {
                return;
            }
            this.painter.moveLeft();
        }
        int key4 = keyboardEvent.getKey();
        if (key4 == 39) {
            if (painter.getX() == 880) {
                return;
            }
            this.painter.moveRight();
        }
        int key5 = keyboardEvent.getKey();
        if (key5 == 32) {
            grid.paint();
        }
        int key6 = keyboardEvent.getKey();
        if (key6 == 67) {
            grid.erase();
        }
        int key7 = keyboardEvent.getKey();
        if (key7 == 83) {
            try {
                grid.save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int key8 = keyboardEvent.getKey();
        if (key8 == 76) {
            try {
                grid.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
