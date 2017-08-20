
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	// ArrayList<GameObject> objects;
	ArrayList<Block> blocks;
	ArrayList<Projectile> projectiles;
	ArrayList<Character> characters;
	static int score = 0;
	static int highScore = 0;
	static int turn = 1;
	

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public ObjectManager() {
		// objects = new ArrayList<GameObject>();
		blocks = new ArrayList<Block>();
		projectiles = new ArrayList<Projectile>();
		characters = new ArrayList<Character>();
	}

	public void addBlock(Block b) {
		blocks.add(b);
	}

	public void addProjectile(Projectile p) {
		projectiles.add(p);

	}

	public void addCharacter(Character c) {
		characters.add(c);

	}

	public void update() {

		 //for (int i = 0; i < blocks.size(); i++) {
		 //Block b = blocks.get(i);
		// b.update();
		 //}
		
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			p.update();

		}
		for (int i = 0; i < characters.size(); i++) {
			Character c = characters.get(i);
			c.update();
		}

		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			b.draw(g);

		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			p.draw(g);
		}
		for (int i = 0; i < characters.size(); i++) {
			Character c = characters.get(i);
			c.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < blocks.size(); i++) {
			if (!blocks.get(i).isAlive) {
				blocks.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
			if (Projectile.numberOfProjectiles == 0 && projectiles.size() == 0) {
				Projectile.numberOfProjectiles = Projectile.previousNumberOfProjectiles;
				Projectile.numberOfProjectiles += 1;
				Projectile.previousNumberOfProjectiles+=1;
				manageEnemies();

			}
		}
		for (int i = 0; i < characters.size(); i++) {
			if (!characters.get(i).isAlive) {
				characters.remove(i);
			}
		}

	}

	public void manageEnemies() {

		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			b.update();

		}

		
		if (projectiles.size() == 0) {
			int randy = new Random().nextInt(10);

			for (int i = 0; i < randy; i++) {

				int blockX = new Random().nextInt(10) * 50;
				int blockY = 0;
				ArrayList<Integer> xpos = new ArrayList<Integer>();
				for (int j = 0; j < blocks.size(); j++) {
					if(blocks.get(j).y==blockY){
					xpos.add(blocks.get(j).x);
					}
					
				
			}
				while(xpos.contains(blockX)){
					
					blockX = new Random().nextInt(10) * 50;
					
					
				}
				addBlock(new Block(blockX, blockY, 50, 50));
			}
			turn+=1;
		}

	}

	public void checkCollision() {
		for (int i = 0; i < blocks.size(); i++) {
			for (int j = 0; j < projectiles.size(); j++) {

				Projectile p = projectiles.get(j);
				Block b = blocks.get(i);
				Character c = characters.get(i);

				if (p.collisionBox.intersects(b.collisionBox)) {
					System.out.println("collision");
					b.collision();
					p.bounce(b);
					

				}
				if (b.collisionBox.intersects(c.collisionBox)) {

					GamePanel.currentState = GamePanel.END_STATE;
					reset();
				}
				
			}
		}
	}

	public int getScore() {
		return score;
	}



	public void reset() {
		blocks.clear();
		projectiles.clear();
		characters.clear();
	}
}
