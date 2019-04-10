import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	
int speed= 10;

	public Projectile(int x,int y, int width,int height) {
		// TODO Auto-generated constructor stub
		super(x+20,y,width,height);
	}
void update() {
		y=y-speed;
		  super.update();
	if(y<0) {
		isAlive=false;
	}
	}
	void draw(Graphics g) {
		 g.setColor(Color.RED);

	        g.drawRect(x, y, width, height);
	}
}
