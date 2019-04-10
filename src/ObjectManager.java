import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
Rocketship rocketship;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();

ObjectManager(Rocketship rocketship){
	this.rocketship=rocketship;
}
void update() {
	rocketship.update();
	for(Projectile p : projectiles){
		p.update();
	}
	for(Alien a : aliens){
		a.update();
	}
}
void draw(Graphics g) {
	rocketship.draw(g);
	for(Projectile p : projectiles){
		p.draw(g);
	}
	for(Alien a : aliens){
		a.draw(g);
	}
}
void addProjectile(Projectile p) {
		projectiles.add(p);
}
void addAlien(Alien a) {
	
	aliens.add(a);


}
void manageEnemies() {
	
}
void checkCollision() {
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
}
}
