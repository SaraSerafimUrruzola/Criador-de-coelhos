package Classes;

import javax.swing.*;
import java.awt.*;

public class Imagem extends JPanel {

    private Image image;

    public Imagem(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}