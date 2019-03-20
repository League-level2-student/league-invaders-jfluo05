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

final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState=MENU_STATE;


GamePanel(){
titleFont= new Font("Arial",Font.PLAIN,48);
}

void updateMenuState() {
	
}
void updateGameState() {
	
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);

	g.fillRect(0, 0, 500, 800);  
	g.setColor(Color.YELLOW);
	g.setFont(titleFont);
    g.drawString("LEAGUE INVADERS", 20, 100);
}
void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);

	g.fillRect(0, 0, 500, 800);   
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);

	g.fillRect(0, 0, 500, 800);   
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
