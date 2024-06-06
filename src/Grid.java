import org.academiadecodigo.simplegraphics.graphics.Color;

public class Grid {

    public static final int PADDING = 10;
    public static final int SIZE = 25;
    public static final int COLS = 25;
    public static final int ROWS = 25;
    public static final Cell[] CELLS = new Cell[COLS * ROWS];


    public Grid() {
        int counter = 0;
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                CELLS[counter] = new Cell(i * SIZE + PADDING, j * SIZE + PADDING, SIZE);
                CELLS[counter].rect.setColor(Color.BLACK);
                CELLS[counter].rect.draw();
                counter++;
            }
        }
    }
}



