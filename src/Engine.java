import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class Engine {


    public Engine() {
        Canvas.limitCanvasWidth(Grid.SIZE * Grid.COLS + Grid.PADDING);
        Canvas.limitCanvasHeight(Grid.SIZE * Grid.ROWS + Grid.PADDING);
        start();
    }

    public void start() {
        new Grid();
        Painter painter = new Painter();
        new MyKeyboard(painter, this);
    }

    public void save() throws IOException {

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getAbsolutePath();

            // Ensure the filename ends with .txt extension
            if (!fileName.toLowerCase().endsWith(".txt")) {
                fileName += ".txt";
            }

            // Write the grid state to the file
            FileWriter writer = new FileWriter(fileName);

            String empty = "0";
            String black = "1";
            String blue = "2";
            String magenta = "3";
            String green = "4";

            for (int i = 0; i < Grid.CELLS.length; i++) {
                if (Grid.CELLS[i].isPainted()) {
                    if (Grid.CELLS[i].getColor().equals(Color.BLACK)) {
                        writer.write(black);
                    } else if (Grid.CELLS[i].getColor().equals(Color.BLUE)) {
                        writer.write(blue);
                    } else if (Grid.CELLS[i].getColor().equals(Color.MAGENTA)) {
                        writer.write(magenta);
                    } else if (Grid.CELLS[i].getColor().equals(Color.GREEN)) {
                        writer.write(green);
                    }
                } else {
                    writer.write(empty);
                }
            }
            writer.close();
        }
    }

    public void load() throws IOException {

        erase();

        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getAbsolutePath();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            int c;
            int index = 0;

            while ((c = reader.read()) != -1 && index < Grid.CELLS.length) {
                char character = (char) c;
                if (character == '1') {
                    Grid.CELLS[index].rect.setColor(Color.BLACK);
                    Grid.CELLS[index].rect.fill();
                    Grid.CELLS[index].setPainted(true);
                } else if (character == '2') {
                    Grid.CELLS[index].rect.setColor(Color.BLUE);
                    Grid.CELLS[index].rect.fill();
                    Grid.CELLS[index].setPainted(true);
                } else if (character == '3') {
                    Grid.CELLS[index].rect.setColor(Color.MAGENTA);
                    Grid.CELLS[index].rect.fill();
                    Grid.CELLS[index].setPainted(true);
                } else if (character == '4') {
                    Grid.CELLS[index].rect.setColor(Color.GREEN);
                    Grid.CELLS[index].rect.fill();
                    Grid.CELLS[index].setPainted(true);
                } else {
                    Grid.CELLS[index].rect.draw();
                    Grid.CELLS[index].setPainted(false);
                }
                index++;
            }
            reader.close();
        }
    }

    public void erase() {
        for (int i = 0; i < Grid.CELLS.length; i++) {
            if (Grid.CELLS[i].isPainted()) {
                Grid.CELLS[i].rect.delete();
                Grid.CELLS[i].rect.setColor(Color.BLACK);
                Grid.CELLS[i].rect.draw();
                Grid.CELLS[i].setPainted(false);
            }
        }
    }

    public void quit() throws IOException {

        int choice = JOptionPane.showConfirmDialog(null, "Do you want to save before quitting?", "Quit", JOptionPane.YES_NO_CANCEL_OPTION);

        switch (choice) {
            case JOptionPane.YES_OPTION:
                save();
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
                break;
            default:
                // If the user chooses Cancel, do nothing
                break;
        }
    }
}
