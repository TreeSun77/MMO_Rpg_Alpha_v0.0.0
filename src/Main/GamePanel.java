package Main;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

	// SCREEN SETTINGS
	final  int originalTileSize = 16;

	final  int scale = 3;

	final  int tileSize = originalTileSize * scale; //48

	final int maxScreenCol = 16;
	final int maxScreenRow = 12;

	final int screenWidth = tileSize * maxScreenCol; // 768
	final int screenHeight = tileSize * maxScreenRow; // 576

	// PLAYER POSITION
	int playerX = 110;
	int playerY = 110;
	int playerSpeed = 4;

	int FPS = 60;

	KeyHandler keyH = new KeyHandler();





	Thread gameThread;

	public GamePanel (){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	public void  startGameThread(){
		gameThread = new Thread( this);
		gameThread.start();
	}
	//RUN
	@Override
	public void run() {
		while (gameThread!= null){
			double drawInterval = 1000000000/FPS;
			double nextDrawTime = System.nanoTime() + drawInterval;
			update();
			repaint();

			try {
					double remainingTime = nextDrawTime - System.nanoTime();
					remainingTime = remainingTime/1000000;
					if (remainingTime < 0){
						remainingTime = 0;
					}
					Thread.sleep((long) remainingTime);
					nextDrawTime += drawInterval;
			}catch (InterruptedException e){
				throw new RuntimeException(e);

			}

		}
	}

	public  void update(){
		if (keyH.upPressed){
			playerY -= playerSpeed;
		}
		else if (keyH.downPressed){
			playerY += playerSpeed;
		}

		if (keyH.leftPressed){
			playerX -= playerSpeed;
		}
		else if (keyH.rightPressed){
			playerX += playerSpeed;
		}

	}
	// PAINT WORLD
	public  void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.green);
		g2.fillRect(playerX,playerY, tileSize, tileSize);
		g2.dispose();

	}


}
