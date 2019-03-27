import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	int speed;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
	}
	void update() {
		
	}
	void draw(Graphics g) {
		 g.setColor(Color.BLUE);

	        g.fillRect(x, y, width, height);
	}
	void moveUp () {
		y=y-speed;
	}
	void moveDown () {
		y=y+speed;
	}
	void moveLeft () {
		x=x-speed;
	}
	void moveRight () {
		x=x-speed;
	}
}
