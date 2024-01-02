import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class BasicOpenWorldGame extends JFrame implements KeyListener {
    private int playerX = 50;
    private int playerY = 50;

    public BasicOpenWorldGame() {
        setTitle("Basic Open World Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw player
        g2d.setColor(Color.RED);
        g2d.fillRect(playerX, playerY, 30, 30);

        // Draw other elements (buildings, roads, etc.) - Simulated representation
        g2d.setColor(Color.BLACK);
        g2d.fillRect(200, 200, 100, 200);
        g2d.fillRect(400, 100, 150, 300);
        // ... other elements

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            playerX -= 5;
        } else if (key == KeyEvent.VK_RIGHT) {
            playerX += 5;
        } else if (key == KeyEvent.VK_UP) {
            playerY -= 5;
        } else if (key == KeyEvent.VK_DOWN) {
            playerY += 5;
        }

        repaint();
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            BasicOpenWorldGame game = new BasicOpenWorldGame();
            game.setVisible(true);
        });
    }
}
