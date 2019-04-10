import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		y=y+3;
		  super.update();
	}
	void draw(Graphics g) {
		 g.setColor(Color.CYAN);

	        g.drawRect(x, y, width, height);
	}
}
