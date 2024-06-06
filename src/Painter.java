import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Painter {

    public Rectangle painter;
    private int limitDown = Grid.ROWS * Grid.SIZE + Grid.PADDING - Grid.SIZE;
    private int limitRight = Grid.COLS * Grid.SIZE + Grid.PADDING - Grid.SIZE;


    public Painter() {
        this.painter = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.SIZE, Grid.SIZE);
        painter.setColor(Color.BLACK);
        painter.fill();
    }

    public void paint(Color color) {
        for (int i = 0; i < Grid.CELLS.length; i++) {
            if (Grid.CELLS[i].rect.getX() == painter.getX() && Grid.CELLS[i].rect.getY() == painter.getY()) {
                if (!Grid.CELLS[i].isPainted()) {
                    Grid.CELLS[i].rect.setColor(color);
                    Grid.CELLS[i].setColor(color);
                    Grid.CELLS[i].rect.fill();
                    Grid.CELLS[i].setPainted(true);
                } else {
                    Grid.CELLS[i].rect.delete();
                    Grid.CELLS[i].rect.setColor(Color.BLACK);
                    Grid.CELLS[i].rect.draw();
                    Grid.CELLS[i].setPainted(false);
                }
            }
        }
    }


    public void moveUp() {
        if (painter.getY() == Grid.PADDING) {
            return;
        }
        painter.translate(0, -Grid.SIZE);
    }

    public void moveDown() {
        if (painter.getY() == limitDown) {
            return;
        }
        painter.translate(0, Grid.SIZE);
    }

    public void moveLeft() {
        if (painter.getX() == Grid.PADDING) {
            return;
        }
        painter.translate(-Grid.SIZE, 0);
    }

    public void moveRight() {
        if (painter.getX() == limitRight) {
            return;
        }
        painter.translate(Grid.SIZE, 0);
    }

}