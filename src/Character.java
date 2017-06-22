import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject {

	int speed;

	public Character(int x, int y, int width, int height) {
		super(x, y, width, height);

		this.speed = 8;
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);

	}

	void update() {

		super.update();

	}

}
