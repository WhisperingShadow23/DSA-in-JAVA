import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeGame extends JFrame implements ActionListener {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = (WIDTH * HEIGHT) / (DOT_SIZE * DOT_SIZE);
    private final int DELAY = 140;

    private ArrayList<Integer> snakeX;
    private ArrayList<Integer> snakeY;
    private int dots;
    private int appleX;
    private int appleY;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;

    public SnakeGame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        snakeX = new ArrayList<>();
        snakeY = new ArrayList<>();
        dots = 3; // Initial length of the snake

        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);

        initGame();
    }

    private void initGame() {
        for (int i = 0; i < dots; i++) {
            snakeX.add(WIDTH / 2 - i * DOT_SIZE);
            snakeY.add(HEIGHT / 2);
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void locateApple() {
        Random rand = new Random();
        appleX = rand.nextInt((WIDTH / DOT_SIZE)) * DOT_SIZE;
        appleY = rand.nextInt((HEIGHT / DOT_SIZE)) * DOT_SIZE;
    }

    private void checkApple() {
        if (snakeX.get(0).equals(appleX) && snakeY.get(0).equals(appleY)) {
            dots++;
            locateApple();
        }
    }

    private void move() {
        for (int i = dots - 1; i > 0; i--) {
            snakeX.set(i, snakeX.get(i - 1));
            snakeY.set(i, snakeY.get(i - 1));
        }

        if (leftDirection) {
            snakeX.set(0, snakeX.get(0) - DOT_SIZE);
        }
        if (rightDirection) {
            snakeX.set(0, snakeX.get(0) + DOT_SIZE);
        }
        if (upDirection) {
            snakeY.set(0, snakeY.get(0) - DOT_SIZE);
        }
        if (downDirection) {
            snakeY.set(0, snakeY.get(0) + DOT_SIZE);
        }
    }

    private void checkCollision() {
        for (int i = dots - 1; i > 0; i--) {
            if (snakeX.get(0).equals(snakeX.get(i)) && snakeY.get(0).equals(snakeY.get(i))) {
                inGame = false;
            }
        }

        if (snakeX.get(0) >= WIDTH || snakeX.get(0) < 0 || snakeY.get(0) >= HEIGHT || snakeY.get(0) < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    private void draw(Graphics g) {
        if (inGame) {
            g.setColor(Color.RED);
            g.fillRect(appleX, appleY, DOT_SIZE, DOT_SIZE);

            for (int i = 0; i < dots; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.YELLOW);
                }
                g.fillRect(snakeX.get(i), snakeY.get(i), DOT_SIZE, DOT_SIZE);
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font font = new Font("Arial", Font.BOLD, 20);
        FontMetrics metrics = getFontMetrics(font);

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(msg, (WIDTH - metrics.stringWidth(msg)) / 2, HEIGHT / 2);
    }

    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && !rightDirection) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && !leftDirection) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && !downDirection) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && !upDirection) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SnakeGame game = new SnakeGame();
            game.setVisible(true);
        });
    }
}
