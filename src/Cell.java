import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    public Rectangle rect;
    private Color color;
    private boolean isPainted;


    public Cell(int x, int y, int size) {
        rect = new Rectangle(x, y, size, size);
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
