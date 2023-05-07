import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class MainPanel extends JPanel {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 900;
    private static final JFrame frame = new JFrame();
    private static final MainPanel panel = getNewMainPanel();
    private static final Hero hero = Hero.getInstance();
    private static JButton jButton;
    private static boolean flag = false;
    private static final long time = System.currentTimeMillis();

    private MainPanel(){
        setLayout(null);
        jButton = new JButton("Заново");
        jButton.setBounds(WIDTH/2-60,HEIGHT/2-35,150,25);
        jButton.setVisible(false);
        jButton.addActionListener(e -> restart());
        add(jButton);
        revalidate();
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
    public static void restart(){
        flag = false;
        Maze.setCurrentLevel(Level.LEVEL1);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(getNewMainPanel());
        frame.revalidate();
        frame.setFocusable(true);
        frame.requestFocus();
    }
    @Override
    protected void paintComponent(Graphics g){
        if(!flag){
            super.paintComponent(g);
            AttributedString attributedString = new AttributedString("Уровень: " + Maze.getCurrentLevel().toString());
            attributedString.addAttribute(TextAttribute.FONT, new Font("Times New Roman", Font.BOLD, 16));
            g.drawString(attributedString.getIterator(), WIDTH - 100, 35);
            Maze.draw(g);
            hero.drawHero(g);
            repaint();
        }
        else {
            endGame(g);
        }
    }
    public static void setFlag(boolean flag){
        MainPanel.flag = flag;
    }
    public static void endGame(Graphics g){
        jButton.setVisible(true);
        AttributedString attributedString = new AttributedString(String.format("Время прохождения: %.2f c.",(System.currentTimeMillis()-time)*0.001f));
        attributedString.addAttribute(TextAttribute.FONT, new Font("Times New Roman", Font.BOLD, 16));
        g.drawString(attributedString.getIterator(),WIDTH/2-80,HEIGHT/2-50);
    }

}
