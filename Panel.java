import java.awt.*;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;

public class Panel extends JPanel implements Constant {

    Random random = new Random();
    ImageIcon background;
    ImageIcon ImageBackground;
    ImageIcon nav;
    ImageIcon apple;
    ImageIcon appleScore;
    ImageIcon trophy;

    int[] appleX= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675};

    int[] appleY = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525};

    int xpos = random.nextInt(27);
	int ypos = random.nextInt(19);

    public Panel() {
        
        

        // this.addKeyListener(new MyKeyAdapter());
    }

    public void startGame() {

    }

    public void paint(Graphics g) {
        
        
        background = new ImageIcon("background.jpg");
        background.paintIcon(this, g, 0, 0);

        ImageBackground = new ImageIcon("game-background-21.png");
        ImageBackground.paintIcon(this, g, 25, 50);

        nav = new ImageIcon("nav.png");
        nav.paintIcon(this, g, 25, 0);
        
        appleScore = new ImageIcon("apple3.png");
        appleScore.paintIcon(this, g, 40, 20);

        trophy = new ImageIcon("trophy.png");
        trophy.paintIcon(this, g, 650, 20);

        // for (int i = 0; i<SCREEN_HEIGHT/UNIT_SIZE; i++) {
        //     g.drawLine(i*UNIT_SIZE, 80, i*UNIT_SIZE, SCREEN_HEIGHT);
        //     g.drawLine(50, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
        // }

        apple = new ImageIcon("apple2.png");
        apple.paintIcon(this, g, appleX[xpos], appleY[ypos]);
        
        

    }

    
    public void move() {

    }

    public void checkApple() {

    }

    public void checkCollision() {

    }

    public void gameOVer() {

    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    // // TODO Auto-generated method stub

    // }

}
