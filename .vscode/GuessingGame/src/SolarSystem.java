import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SolarSystem extends JPanel {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    private static final int SUN_RADIUS = 50;
    private static final int MERCURY_RADIUS = 10;
    private static final int VENUS_RADIUS = 15;
    private static final int EARTH_RADIUS = 15;
    private static final int MARS_RADIUS = 12;

    private static final int MERCURY_ORBIT = 80;
    private static final int VENUS_ORBIT = 140;
    private static final int EARTH_ORBIT = 200;
    private static final int MARS_ORBIT = 280;

    private int angle = 0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        drawOrbit(g2d, centerX, centerY, MERCURY_ORBIT);
        drawOrbit(g2d, centerX, centerY, VENUS_ORBIT);
        drawOrbit(g2d, centerX, centerY, EARTH_ORBIT);
        drawOrbit(g2d, centerX, centerY, MARS_ORBIT);

        drawPlanet(g2d, centerX, centerY, SUN_RADIUS, Color.YELLOW, 0);
        drawPlanet(g2d, centerX, centerY, MERCURY_RADIUS, Color.GRAY, MERCURY_ORBIT);
        drawPlanet(g2d, centerX, centerY, VENUS_RADIUS, Color.ORANGE, VENUS_ORBIT);
        drawPlanet(g2d, centerX, centerY, EARTH_RADIUS, Color.BLUE, EARTH_ORBIT);
        drawPlanet(g2d, centerX, centerY, MARS_RADIUS, Color.RED, MARS_ORBIT);

        // Animation
        angle++;
        if (angle >= 360) {
            angle = 0;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    private void drawOrbit(Graphics2D g2d, int centerX, int centerY, int radius) {
        Ellipse2D orbit = new Ellipse2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        g2d.draw(orbit);
    }

    private void drawPlanet(Graphics2D g2d, int centerX, int centerY, int radius, Color color, int orbitRadius) {
        double radian = Math.toRadians(angle);
        int x = (int) (centerX + orbitRadius * Math.cos(radian));
        int y = (int) (centerY + orbitRadius * Math.sin(radian));

        g2d.setColor(color);
        g2d.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System");
        SolarSystem solarSystem = new SolarSystem();
        frame.add(solarSystem);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
