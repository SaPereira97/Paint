import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    public Rectangle rect;
    private boolean isPainted;

    public Cell(int x, int y, int size, int size2) {
        rect = new Rectangle(x, y, size, size2);
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }
}
