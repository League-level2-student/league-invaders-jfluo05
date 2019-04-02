import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener{
Timer timer= new Timer(1000/60, this);
GameObject gameObject;
Font titleFont;
Font pressEnterToStartFont;
Font spaceForInstructionsFont;
Font gameOver;
Font numOfEnemiesKilledFont;
Font restartFont;

Rocketship rocketship= new Rocketship(250, 700, 50, 50);
ObjectManager oM= new ObjectManager(rocketship);

final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState=MENU_STATE;


GamePanel(){
titleFont= new Font("Arial",Font.PLAIN,48);
pressEnterToStartFont= new Font("Arial", Font.PLAIN, 30);
spaceForInstructionsFont=new Font("Arial", Font.PLAIN, 30);
gameOver=new Font("Arial",Font.BOLD,48);
numOfEnemiesKilledFont= new Font("Arial", Font.PLAIN, 44);
restartFont= new Font("Arial", Font.PLAIN, 44);
}

void updateMenuState() {
	
}
void updateGameState() {
oM.update();
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {

	g.setColor(Color.BLUE);

	g.fillRect(0, 0, 500, 800); 
	
	g.setColor(Color.YELLOW);
	g.setFont(titleFont);
    g.drawString("LEAGUE INVADERS", 20, 100);
    
    g.setColor(Color.YELLOW);
	g.setFont(pressEnterToStartFont);
    g.drawString("Press ENTER to start", 86, 370);
    
    g.setColor(Color.YELLOW);
	g.setFont(spaceForInstructionsFont);
    g.drawString("Press SPACE for instructions", 50, 500);
  
}
void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);

	g.fillRect(0, 0, 500, 800);
	
	oM.draw(g);
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);

	g.fillRect(0, 0, 500, 800);  
	g.setColor(Color.BLACK);
	g.setFont(gameOver);
    g.drawString("GAME OVER", 100, 100);
    
    g.setColor(Color.BLACK);
	g.setFont(pressEnterToStartFont);
    g.drawString("You killed 0 enemies", 90, 300);
    
    g.setColor(Color.BLACK);
	g.setFont(restartFont);
    g.drawString("Press ENTER to restart", 20, 450);
}

void startGame() {
	timer.start();
}
@Override

public void paintComponent(Graphics g){
//	gameObject.draw(g);
	 if(currentState == MENU_STATE){

         drawMenuState(g);

 }else if(currentState == GAME_STATE){

	 drawGameState(g);

 }else if(currentState == END_STATE){

	 drawEndState(g);

 }
        }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
//	gameObject.update();
	
	 if(currentState == MENU_STATE){

         updateMenuState();

 }else if(currentState == GAME_STATE){

         updateGameState();

 }else if(currentState == END_STATE){

         updateEndState();

 }
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("keyTyped");
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		rocketship.x=rocketship.x-rocketship.speed;
	}
	else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		rocketship.x=rocketship.x+rocketship.speed;
	}
	else if(e.getKeyCode()==KeyEvent.VK_UP) {
		rocketship.moveUp();
	}
	else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		rocketship.y=rocketship.y+rocketship.speed;
	}
	else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
		oM.addProjectile (new Projectile(rocketship.x, rocketship.y, 10, 10));
	}
	
	System.out.println("keyPressed");
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {

		if(currentState == MENU_STATE){

            currentState = GAME_STATE;

    }
		else if(currentState == GAME_STATE){

            currentState = END_STATE;

    }
		else if(currentState == END_STATE){

            currentState = MENU_STATE;

    }
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("keyReleased");
}
}
