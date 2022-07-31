import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Panel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 700;
	static final int UNIT_SIZE = 25;
    static final int BOARD_WIDTH = 725;
    static final int BOARD_HEIGHT = 625;
	static final int GAME_UNITS = (BOARD_WIDTH*BOARD_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
	static final int DELAY = 175;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int snakeLength = 3;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
    boolean moving = false;
	Timer timer;
	Random random;

    ImageIcon apple;
    ImageIcon ImageBackground;
    ImageIcon background;
    ImageIcon nav;
    ImageIcon appleScore;
    ImageIcon trophy;
	
	Panel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {

        if (!moving) {
            x[0] = 125;
            x[1] = 100;
            x[2] = 75;

            y[0] = 100;
            y[1] = 100;
            y[2] = 100;
        }

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

        g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 20));
		g.drawString("" + applesEaten, 100, 55);
		g.drawString("" + snakeLength, 710, 55);
		
		if(running) {

            apple = new ImageIcon("img/apple2.png");
            apple.paintIcon(this, g, appleX, appleY);
		
			for(int i = 0; i< snakeLength; i++) {
				if(i == 0) {
					g.setColor(new Color(100, 227, 62));
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(new Color(45,180,0));
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}			
			}
		} else {
			gameOver(g);
		}
		
	}

	public void newApple(){
		appleX = random.nextInt((int)(BOARD_WIDTH/UNIT_SIZE))*UNIT_SIZE;
            while (appleX < 50) {
                appleX = random.nextInt((int)(BOARD_WIDTH/UNIT_SIZE))*UNIT_SIZE;
            }
		appleY = random.nextInt((int)(BOARD_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
            while (appleY < 75) {
                appleY = random.nextInt((int)(BOARD_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
            }
	}

	public void move(){
		for(int i = snakeLength; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			snakeLength++;
			applesEaten++;
			newApple();
		}
	}

	public void checkCollisions() {
		//checks if head collides with body
		for(int i = snakeLength; i>0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}

        if (direction == 'R') {

             for (int i = snakeLength; i>=0; i--) {

                if (x[i] > BOARD_WIDTH) {
                    x[i] = 50;
                }
            }           
        }

        if (direction == 'L') {
            
            for (int i = snakeLength; i>=0; i--) {

                if (x[i] < 50) {
                    x[i] = BOARD_WIDTH;
                }
            }           
        }

        if (direction == 'U') {

            for (int i = snakeLength; i>=0; i--) {

                if (y[i] < 75) {
                    y[i] = BOARD_HEIGHT;
                }
			}           
        }

        if (direction == 'D') {

            for (int i = snakeLength; i>=0; i--) {

                if (y[i] > BOARD_HEIGHT) {
                    y[i] = 75;
                }
            }           
        }


		// //check if head touches left border
		// if(x[0] < 0) {
		// 	running = false;
		// }
		// //check if head touches right border
		// if(x[0] > SCREEN_WIDTH) {
		// 	running = false;
		// }
		// //check if head touches top border
		// if(y[0] < 0) {
		// 	running = false;
		// }
		// //check if head touches bottom border
		// if(y[0] > SCREEN_HEIGHT) {
		// 	running = false;
		// }
		
		// if(!running) {
		// 	timer.stop();
		// }
	}
	
	public void gameOver(Graphics g) {
		//Score
		g.setColor(new Color(255, 233, 49));
		g.setFont( new Font("Baskerville Old Face",Font.BOLD, 40));
		g.drawString("Score: "+applesEaten, 320, 200);

		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Baskerville Old Face",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);

		//Restart text
		g.setColor(new Color(255, 233, 49));
        g.setFont(new Font("arial",Font.BOLD,20));
		g.drawString("Click space to RESTART", 290, 500);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
                moving = true;
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
                moving = true;
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
                moving = true;
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
                moving = true;
				if(direction != 'U') {
					direction = 'D';
				}
				break;
                case KeyEvent.VK_A:
                moving = true;
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_D:
                moving = true;
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_W:
                moving = true;
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_S:
                moving = true;
				if(direction != 'U') {
					direction = 'D';
				}
				break;
            case KeyEvent.VK_SPACE:
				moving = false;
                applesEaten = 0;
                snakeLength = 3;
                running = true;
                repaint();
				break;
			}
            
		}
	}
}
