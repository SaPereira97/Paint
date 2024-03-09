import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Painter {

    private Rectangle paint;
    private Grid grid;

    public Painter() {
        this.paint = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.SIZE, Grid.SIZE);
        paint.setColor(Color.GREEN);
        paint.fill();
    }


    public void moveUp() {
        paint.translate(0, -30);
    }

    public void moveDown() {
        paint.translate(0, 30);
    }

    public void moveLeft() {
        paint.translate(-30, 0);
    }

    public void moveRight() {
        paint.translate(30, 0);
    }

    public int getX() {
        return paint.getX();
    }

    public int getY() {
        return paint.getY();
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}