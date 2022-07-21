import java.awt.*;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;

public class Panel extends JPanel implements Constant {

    Timer timer;
    Random random = new Random();
    ImageIcon background;
    ImageIcon ImageBackground;
    ImageIcon nav;
    ImageIcon apple;
    ImageIcon appleScore;
    ImageIcon trophy;

    ImageIcon snakeheadup;
    ImageIcon snakeheaddown;
    ImageIcon snakeheadleft;
    ImageIcon snakeheadright;
    ImageIcon snakebody;

    int[] appleX= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675};
    int[] appleY = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525};

    int xpos = random.nextInt(27);
	int ypos = random.nextInt(19);

    int[] x = new int[GAME_UNIT];
    int[] y = new int[GAME_UNIT];

    int snakelength = 1;

    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    boolean moving = false;

    public Panel() {
        
        restartMove();

        // this.addKeyListener(new MyKeyAdapter());
    }

    public void startGame() {

    }

    public void paint(Graphics g) {
        
        
        background = new ImageIcon("img/background.jpg");
        background.paintIcon(this, g, 0, 0);

        ImageBackground = new ImageIcon("img/game-background-21.png");
        ImageBackground.paintIcon(this, g, 25, 50);

        nav = new ImageIcon("img/nav.png");
        nav.paintIcon(this, g, 25, 0);
        
        appleScore = new ImageIcon("img/apple3.png");
        appleScore.paintIcon(this, g, 40, 20);

        trophy = new ImageIcon("img/trophy.png");
        trophy.paintIcon(this, g, 650, 20);

        // for (int i = 0; i<SCREEN_HEIGHT/UNIT_SIZE; i++) {
        //     g.drawLine(i*UNIT_SIZE, 80, i*UNIT_SIZE, SCREEN_HEIGHT);
        //     g.drawLine(50, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
        // }

        apple = new ImageIcon("img/apple2.png");
        apple.paintIcon(this, g, appleX[xpos], appleY[ypos]);
        
        snakeheadright = new ImageIcon("img/snakehead-right.png");
        snakeheadright.paintIcon(this, g, x[0], y[0]);

        snakebody = new ImageIcon("img/snakebody.png");
        snakebody.paintIcon(this, g, x[1], y[1]);

        for (int i=0; i<snakelength; i++) {
            
            if (i==0 && right) {
                snakeheadright = new ImageIcon("img/snakehead-right.png");
                snakeheadright.paintIcon(this, g, x[i], y[i]);
            }

            if (i==0 && left) {
                snakeheadleft = new ImageIcon("img/snakehead-left.png");
                snakeheadleft.paintIcon(this, g, x[i], y[i]);
            }

            if (i==0 && up) {
                snakeheadup = new ImageIcon("img/snakehead-up.png");
                snakeheadup.paintIcon(this, g, x[i], y[i]);
            }

            if (i==0 && down) {
                snakeheaddown = new ImageIcon("img/snakehead-down.png");
                snakeheaddown.paintIcon(this, g, x[i], y[i]);
            }

            if (i!=0) {
                snakebody = new ImageIcon("img/snakebody.png");
                snakebody.paintIcon(this, g, x[i], y[i]);
            }
        }

    }

    public void restartMove() {
        if (!moving) {
            x[0] = 145;
            x[1] = 119;
            

            y[0] = 94;
            y[1] = 94;
           
        }
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
