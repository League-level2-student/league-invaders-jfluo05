
public class ObjectManager {
Rocketship rocketship;

ObjectManager(Rocketship rocketship){
	this.rocketship=rocketship;
}
void update() {
	rocketship.update();
}
}
