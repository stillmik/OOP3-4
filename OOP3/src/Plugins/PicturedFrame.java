package Plugins;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class PicturedJFrame extends JFrame {

    PicturedJFrame() {
        setContentPane(new PicturedPanel());
        setBounds(500, 150, 550, 550);
        setLayout(null);
        setVisible(true);
        setResizable(false);
    }
}

class PicturedPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Image image = null;
        String pathToPicture = "C:\\Users\\User\\OneDrive\\Рабочий стол\\pikchi\\gray.jpg";
        try {
            image = ImageIO.read(new File(pathToPicture));
        } catch (IOException ignored) {
        }
        g.drawImage(image, 0, 0, 550, 550, null);
    }
}
