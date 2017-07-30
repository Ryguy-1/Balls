import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	int speed;
	float angle = 0;
	static int numberOfProjectiles = 4;
	static int previousNumberOfProjectiles = numberOfProjectiles;
	double xBounce = Math.PI/2;
	double yBounce = Math.PI/8;
	public Projectile(int x, int y, int width, int height, float angle, int speed) {
		super(x, y, width, height);
		this.speed = speed;
		this.angle = angle;

	}

	void draw(Graphics g) {

		g.setColor(Color.BLUE);
		g.drawOval(x, y, width, height);

	}

	void update() {

		super.update();
		double xVelocity = Math.cos(angle) * speed;
		double yVelocity = Math.sin(angle) * speed;
		x += Math.cos(angle) * speed;
		y += Math.sin(angle) * speed;
		
		if(y>0){
			
			
		}
		
		if (x > Runner.width - 0) {

			angle -= xBounce;

			// angle-=angle;

		}

		if (y < 0 && x < Runner.width / 2) {

			angle -= yBounce;

		} else if (y < 0 && x >= Runner.width / 2) {

			angle += yBounce;

		}
		if (y > Runner.height - 10) {

			isAlive = false;

		}
		if (x < 0) {

			angle += xBounce;
			// angle+=angle;

		}

		

	}

	void bounce(Block b) {

		// if(angle>Math.PI/2){

		angle -= xBounce;

		if (b.collisionBox.intersects(collisionBox)) {

			// Freezes game

			x += Math.cos(angle) * speed;
			y += Math.sin(angle) * speed;

		}

		// }

	}

}
