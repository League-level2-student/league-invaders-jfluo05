import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame frame;
	final int width=500;
	final int height= 800;
	GamePanel gamePanel;
	
	LeagueInvaders(){
		frame= new JFrame();
		gamePanel= new GamePanel();
	}
	
public static void main(String[] args) {
	LeagueInvaders li= new LeagueInvaders();
	li.setup();
}
void setup() {
	frame.add(gamePanel);
	frame.setVisible(true);
	frame.setSize(width, height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));

    frame.pack();
    
    gamePanel.startGame();
    frame.addKeyListener(gamePanel);
}
}
