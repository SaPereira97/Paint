import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class Grid {

    public static final int PADDING = 10;
    public static final int SIZE = 30;
    private int cols = 30;
    private int rows = 30;
    private final Cell[] cells = new Cell[cols * rows];
    private Painter painter;


    public Grid(Painter painter) {
        this.painter = painter;
        int counter = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[counter] = new Cell(i * cols + PADDING, j * rows + PADDING, SIZE, SIZE);
                cells[counter].rect.setColor(Color.BLACK);
                cells[counter].rect.draw();
                counter++;
            }
        }
    }

    public void save() throws IOException {

        FileOutputStream outputStream = new FileOutputStream("/Users/codecadet/Documents/MyExercises/Paint/src/save.txt");

        String fill = "1";
        String empty = "0";

        byte[] pos = fill.getBytes();
        byte[] neg = empty.getBytes();

        for (int i = 0; i < cells.length; i++) {
            if (cells[i].isPainted()) {
                outputStream.write(pos);
            } else {
                outputStream.write(neg);
            }
        }
        outputStream.close();
    }

    public void load() throws IOException {

        FileReader reader = new FileReader("/Users/codecadet/Documents/MyExercises/Paint/src/save.txt");

        int c;
        int index = 0;
        while ((c = reader.read()) != -1 && index < cells.length) {
            char character = (char) c;
            if (character == '1') {
                cells[index].rect.setColor(Color.BLACK);
                cells[index].rect.fill();
                cells[index].setPainted(true);
            } else if (character == '0') {
                cells[index].rect.draw();
                cells[index].setPainted(false);
            }
            index++;
        }
        reader.close();
    }

    public void paint() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].rect.getX() == painter.getX() && cells[i].rect.getY() == painter.getY()) {
                cells[i].rect.setColor(Color.BLACK);
                if (cells[i].isPainted() == false) {
                    cells[i].rect.fill();
                    cells[i].setPainted(true);
                } else {
                    cells[i].rect.delete();
                    cells[i].rect.draw();
                    cells[i].setPainted(false);
                }
            }
        }
    }

    public void erase() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].isPainted() == true) {
                cells[i].rect.delete();
                cells[i].rect.draw();
                cells[i].setPainted(false);
            }
        }
    }
}



