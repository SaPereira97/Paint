
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Engine {

    private Grid grid;
    private Painter painter;
    private MyKeyboard keyboard;


    public Engine() {
        Canvas.limitCanvasWidth(910);
        Canvas.limitCanvasHeight(910);
    }

    public void start() {
        this.painter = new Painter();
        this.grid = new Grid(painter);
        painter.setGrid(grid);
        keyboard = new MyKeyboard(painter, grid);
    }
}
