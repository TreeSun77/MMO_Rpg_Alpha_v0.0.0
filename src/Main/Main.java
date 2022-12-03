package Main;

import javax.swing.*;

public class Main {
	public static void main (String[] args) {
		JFrame windows = new JFrame();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setResizable(false);
		windows.setTitle("MMO_Rpg_Alpha_v0.0.0");

		GamePanel gamePanel = new GamePanel();
		windows.add(gamePanel);
		windows.pack();


		windows.setLocationRelativeTo(null);
		windows.setVisible(true);


		gamePanel.startGameThread();

	}

}
