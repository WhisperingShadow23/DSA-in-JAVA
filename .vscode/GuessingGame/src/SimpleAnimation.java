// public import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimpleAnimation extends JPanel implements ActionListener {
    private int x = 0;
    private int y = 0;
    private int xVelocity = 1;
    private int yVelocity = 1;

    public void actionPerformed(ActionEvent e) {
        x += xVelocity;
        y += yVelocity;

        if (x >= getWidth() || x < 0) {
            xVelocity = -xVelocity;
        }

        if (y >= getHeight() || y < 0) {
            yVelocity = -yVelocity;
        }

        repaint(); // Request repainting the panel
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Animation");
        SimpleAnimation animation = new SimpleAnimation();
        frame.add(animation);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(10, animation); // Trigger animation every 10 milliseconds
        timer.start();
    }
}
