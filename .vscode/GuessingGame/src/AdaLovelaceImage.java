import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;

public class AdaLovelaceImage extends JFrame {

    public AdaLovelaceImage() {
        setTitle("Ada Lovelace");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Drawing Ada Lovelace
        g.setColor(Color.BLACK);
        g.drawOval(100, 50, 100, 100); // Head
        g.drawLine(150, 150, 150, 250); // Body
        g.drawLine(150, 170, 120, 200); // Left arm
        g.drawLine(150, 170, 180, 200); // Right arm
        g.drawLine(150, 250, 130, 300); // Left leg
        g.drawLine(150, 250, 170, 300); // Right leg
        g.drawString("Ada Lovelace", 100, 30); // Name label
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AdaLovelaceImage image = new AdaLovelaceImage();
            image.setVisible(true);
        });
    }
}
