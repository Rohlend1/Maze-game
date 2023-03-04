import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main { // стартовый класс
    public static void main(String[] args) {
        JFrame frame = MainPanel.getFrame();
        MainPanel panel = MainPanel.getPanel();
        Hero hero = Hero.getInstance();
        frame.setResizable(false);
        frame.setTitle("413н");//переименуй потом это
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
        frame.setFocusable(true); // необходимо для того чтобы фокус всегда оставался на фрейме, чтобы была возможность управлять персонажем
        frame.requestFocus();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack(); // т.к. мы указали в конструкторе панели ширину и высоту, чтобы окно подстроилось под размер панели необходим этот метод
        frame.setVisible(true);
    }
}