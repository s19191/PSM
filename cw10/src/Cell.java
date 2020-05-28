import javax.swing.*;
import java.awt.*;

public class Cell {
    Color color;
    JButton jButton;

    public Cell() {
        jButton = new JButton();
        this.setColor(Color.BLACK);
        jButton.addActionListener(e -> {
            if (color.equals(Color.BLACK)) {
                this.setColor(Color.RED);
            } else {
                this.setColor(Color.BLACK);
            }
        });
    }

    public Cell(Color color) {
        jButton = new JButton();
        this.setColor(color);
        jButton.addActionListener(e -> {
            if (color.equals(Color.BLACK)) {
                this.setColor(Color.RED);
            } else {
                this.setColor(Color.BLACK);
            }
        });
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        jButton.setBackground(color);
    }

    public JButton getjButton() {
        return jButton;
    }
}
