
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	
	private int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}
	
	public void update() {
		
		
		
		
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		
		purgeObjects();	
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies(){
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
			addObject(new Block(new Random().nextInt(Runner.width), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
				if(o1.collisionBox.intersects(o2.collisionBox)){
					if((o1 instanceof Block && o2 instanceof Projectile) ||
					   (o2 instanceof Block && o1 instanceof Projectile)){
						if(o1 instanceof Block){
							((Block) o1).collision();
							((Projectile) o2).bounce();
						}else if(o2 instanceof Block){
							((Block) o2).collision();
						}else{
						score++;
						//System.out.println(score);
						o1.isAlive = false;
						o2.isAlive = false;
					}
					}
					
					else if((o1 instanceof Block && o2 instanceof Character) ||
							(o2 instanceof Block && o1 instanceof Character)){
						
						o1.isAlive = false;
						o2.isAlive = false;
					}
	
				}
			}
			}
		}
	

	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
