import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame implements Constant {

    
    public Frame() {
        JFrame f = new JFrame();

        f.setTitle("Snake Game");
        f.setBounds(10, 10, SCREEN_WIDTH, SCREEN_HEIGHT);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.DARK_GRAY);
        f.setLocationRelativeTo(null);
       // GamePlay gm = new GamePlay();
        f.add(new Panel());

    }
}
