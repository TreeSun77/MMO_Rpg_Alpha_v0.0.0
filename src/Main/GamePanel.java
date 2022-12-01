package Main;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	// SCREEN SETTINGS

	final  int originalTileSize = 16;

	final  int scale = 3;

	final  int tileSize = originalTileSize * scale; //48

	final int maxScreenCol = 16;
	final int maxScreenRow = 12;

	final int screenWidth = tileSize * maxScreenCol; // 768
	final int screenHeight = tileSize * maxScreenRow; // 576

	public GamePanel (){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
	}
}
