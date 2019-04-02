import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
Rocketship rocketship;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

ObjectManager(Rocketship rocketship){
	this.rocketship=rocketship;
}
void update() {
	rocketship.update();
	for(Projectile p : projectiles){
		p.update();
	}
}
void draw(Graphics g) {
	rocketship.draw(g);
	for(Projectile p : projectiles){
		p.draw(g);
	}
}
void addProjectile(Projectile p) {
	for(int i = 0; i < projectiles.size(); i++){
		Projectile prjtle = projectiles.get(i);
	}
	
}
}
