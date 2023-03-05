import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class MainPanel extends JPanel { // главная панель
    private static final int WIDTH = 900;
    private static final int HEIGHT = 900;
    private static final JFrame frame = new JFrame();
    private static final MainPanel panel = getNewMainPanel();
    private static final Hero hero = Hero.getInstance();
    private static JButton jButton;
    private static boolean flag = false;
    private static long time = System.currentTimeMillis();

    private MainPanel(){ // генерируем панель
        setLayout(null);
        jButton = new JButton("Заново");
        jButton.setBounds(WIDTH/2-60,HEIGHT/2-35,150,25);
        jButton.setVisible(false);
        jButton.addActionListener(e -> restart());
        add(jButton);
        revalidate(); // проверяет все компоненты на корректность, чтобы все кнопки, слои и пр. при изменении не влияли на основной объект и ничего не сломали
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public static MainPanel getPanel(){
        return panel;
    }
    public static JFrame getFrame(){
        return frame;
    }

    public static MainPanel getNewMainPanel(){
        return new MainPanel();
    }
    public static void restart(){ //перезапуск игры
        flag = false;
        Maze.setCurrentLevel(Level.LEVEL1);
        time = System.currentTimeMillis();
        Maze.setLevelId(0);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(getNewMainPanel());
        frame.revalidate();
        frame.setFocusable(true);
        frame.requestFocus();
    }
    @Override
    protected void paintComponent(Graphics g){ //общий метод отрисовки
        if(!flag){
            super.paintComponent(g);
            AttributedString attributedString = new AttributedString("Уровень: " + Maze.getCurrentLevel().toString());
            attributedString.addAttribute(TextAttribute.FONT, new Font("Times New Roman", Font.BOLD, 16));
            g.drawString(attributedString.getIterator(), WIDTH - 100, 35);
            Maze.draw(g);
            hero.draw(g);
            repaint();
        }
        else {
            fin(g);
        }
    }
    public static void setFlag(boolean flag){ // устанавливаем флаг, пока он false игра продолжается
        MainPanel.flag = flag;
    }
    public static void fin(Graphics g){ // отрисовка кнопки заново и строки с общим временем прохождения
        jButton.setVisible(true);
        AttributedString attributedString = new AttributedString(String.format("Время прохождения: %.2f c.",(System.currentTimeMillis()-time)*0.001f));
        attributedString.addAttribute(TextAttribute.FONT, new Font("Times New Roman", Font.BOLD, 16));
        g.drawString(attributedString.getIterator(),WIDTH/2-80,HEIGHT/2-50);
    }

}
