import javax.swing.*;
import Minesweeper.*;
import Packman.*;
import brickbreaker.*;
import Snake.Frame;

import java.awt.*;
import java.awt.event.*;

class TabbedPaneDemo extends JPanel {
    JPanel panel1 = new JPanel(null), panel2 = new JPanel(null), panel3 = new JPanel(null), panel4 = new JPanel(null),
            panel5 = new JPanel(null), panel6 = new JPanel(null), panels[] = { panel1, panel2, panel3, panel4, panel5 };

    String route = "C:/Users/Lux/Documents/Projects/Ui/";
    String text[] = { "Home", "Minesweeper", "Packman", "BrickBreaker", "Snake" };
    String paths[] = { route + "arcade.png", route + "minesweeper.png", route + "pacman .png", route + "brickb.png",
            route + "snake.png" };

    public TabbedPaneDemo() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("C:/Users/Lux/Documents/Projects/Ui/pacman.png");
        tabbedPane.addTab("Home", icon, panel1, "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        tabbedPane.addTab("Minesweeper", icon, panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        tabbedPane.addTab("Pacman", icon, panel3);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        tabbedPane.addTab("Brick Breaker", icon, panel4);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        tabbedPane.addTab("Snake", icon, panel5);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);
        setColor(panel1, panel2, panel3, panel4, panel5);
        add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private void setColor(JPanel... panels) {
        int i = 0;
        for (JPanel p : panels) {
            p.setBackground(Color.black);
            p.setPreferredSize(new Dimension(400, 400));
            p.add(newButton(text[i], paths[i]));
            JLabel label = new JLabel();
            label.setText("<html><span style='font-size:20px;color:white;font-family:Georgia, serif;'>" + text[i]
                    + "</span></html>");
            label.setBounds(250, 400, 200, 160);
            label.setForeground(Color.white);
            p.add(label);
            i++;
        }
    }

    private JButton newButton(String name, String path) {

        JButton btn = new JButton();
        btn.setBounds(140, 100, 300, 300);
        btn.setBackground(Color.white);
        btn.setActionCommand(name);
        btn.setIcon(new ImageIcon(path));
        btn.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                if (e.getActionCommand() == "Minesweeper") {
                    MINESWEEPER f = new MINESWEEPER();
                    f.setVisible(true);
                } else if (e.getActionCommand() == "Packman") {
                    new PackmanDriver();
                } else if (e.getActionCommand() == "BrickBreaker") {
                    new Main();
                } else if (e.getActionCommand() == "Snake") {
                    new Frame();
                }
            }
        });
        return btn;
    }

    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}

/**
 * Pane
 */
public class Pane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TabbedPaneDemo(), BorderLayout.CENTER);

        frame.getContentPane().setBackground(Color.black);
        frame.setSize(new Dimension(600, 600));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}