import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	int speed;

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 8;

	}

	void draw(Graphics g) {

		g.setColor(Color.BLUE);
		g.drawOval(x, y, width, height);

	}

	void update() {

		super.update();
		y -= speed;

		if (y < 0) {

			isAlive = false;

		}

	}

}
