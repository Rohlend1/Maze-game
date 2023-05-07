import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartGame {
    public static void main(String[] args) {
        JFrame frame = MainPanel.getFrame();
        MainPanel panel = MainPanel.getPanel();
        Hero hero = Hero.getInstance();
        frame.setResizable(false);
        frame.setTitle("Maze Game");
        frame.getContentPane().add(panel);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT -> hero.moveLeft();
                    case KeyEvent.VK_UP -> hero.moveUp();
                    case KeyEvent.VK_RIGHT -> hero.moveRight();
                    case KeyEvent.VK_DOWN -> hero.moveDown();
                }
            }
        });
        frame.setFocusable(true);
        frame.requestFocus();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}