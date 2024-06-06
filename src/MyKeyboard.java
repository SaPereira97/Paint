import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import java.io.IOException;

public class MyKeyboard implements KeyboardHandler {

    private final Keyboard keyboard = new Keyboard(this);

    private Color color = Color.BLACK;
    private Engine engine;
    private Painter painter;
    private boolean pressed;


    public MyKeyboard(Painter painter, Engine engine) {
        this.painter = painter;
        this.engine = engine;
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

        KeyboardEvent release = new KeyboardEvent();
        release.setKey(KeyboardEvent.KEY_SPACE);
        release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(release);

        KeyboardEvent black = new KeyboardEvent();
        black.setKey(KeyboardEvent.KEY_1);
        black.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(black);

        KeyboardEvent blue = new KeyboardEvent();
        blue.setKey(KeyboardEvent.KEY_2);
        blue.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(blue);

        KeyboardEvent magenta = new KeyboardEvent();
        magenta.setKey(KeyboardEvent.KEY_3);
        magenta.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(magenta);

        KeyboardEvent green = new KeyboardEvent();
        green.setKey(KeyboardEvent.KEY_4);
        green.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(green);

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

        KeyboardEvent exit = new KeyboardEvent();
        exit.setKey(KeyboardEvent.KEY_ESC);
        exit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(exit);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        if (key == 38) {
            if (pressed) {
                painter.moveUp();
                painter.paint(color);
            } else {
                painter.moveUp();
            }
        }

        if (key == 40) {
            if (pressed) {
                painter.moveDown();
                painter.paint(color);
            } else {
                painter.moveDown();
            }
        }

        if (key == 37) {
            if (pressed) {
                painter.moveLeft();
                painter.paint(color);
            } else {
                painter.moveLeft();
            }
        }

        if (key == 39) {
            if (pressed) {
                painter.moveRight();
                painter.paint(color);
            } else {
                painter.moveRight();
            }
        }

        if (key == 32) {
            painter.paint(color);
            pressed = true;
        }

        if(key == 49){
            setColor(Color.BLACK);
            painter.painter.delete();
            painter.painter.setColor(color);
            painter.painter.fill();
        }

        if(key == 50){
            setColor(Color.BLUE);
            painter.painter.delete();
            painter.painter.setColor(color);
            painter.painter.fill();
        }

        if(key == 51){
            setColor(Color.MAGENTA);
            painter.painter.delete();
            painter.painter.setColor(color);
            painter.painter.fill();
        }

        if(key == 52){
            setColor(Color.GREEN);
            painter.painter.delete();
            painter.painter.setColor(color);
            painter.painter.fill();
        }

        if (key == 67) {
            engine.erase();
        }

        if (key == 83) {
            try {
                engine.save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (key == 76) {
            try {
                engine.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (key == 27) {
            try {
                engine.quit();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        if (key == 32) {
            pressed = false;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}


