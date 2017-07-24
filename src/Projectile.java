import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	int speed;
	float angle = 0;
	int numberOfProjectiles = 4;

	public Projectile(int x, int y, int width, int height, float angle) {
		super(x, y, width, height);
		this.speed = 8;
		this.angle=angle;
	}

	void draw(Graphics g) {

		g.setColor(Color.BLUE);
		g.drawOval(x, y, width, height);

	}

	void update() {

		super.update();

		x+=Math.cos(angle)*speed;
		y+=Math.sin(angle)*speed;
	}

}
