import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
Rocketship rocketship;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
Random random= new Random();
int score=0;

ObjectManager(Rocketship rocketship){
	this.rocketship=rocketship;
}
public int getScore() {
	return score;
	
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
void purgeObjects() {
	for(int i=0;i<aliens.size();i++) {
		if(!aliens.get(i).isAlive) {
			score=score+1;
			aliens.remove(i);
		}
	}for(int i=0;i<projectiles.size();i++) {
		if(projectiles.get(i).y<-30) {
			projectiles.remove(i);
			System.out.println("PURGED PROJECTILE");
		}
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

	void checkCollision() {

		for (int i=0;i<aliens.size();i++) {

			if (rocketship.collisionBox.intersects(aliens.get(i).collisionBox)) {

				rocketship.isAlive = false;
				
				break;

			}
			for (int j=0;j<projectiles.size();j++) {
				if (aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {

					aliens.get(i).isAlive = false;

				}
			}
		}
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addAlien(new Alien(random.nextInt(LeagueInvaders.width), 0, 50, 50));
}
}
