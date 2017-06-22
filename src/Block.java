import java.awt.Graphics;

public class Block extends GameObject {

	int speed;
	int turn = 0;

	public Block(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 55;

	}

	void draw(Graphics g) {

		g.drawRect(x, y, width, height);

	}

	void update() {

		super.update();
		turn = (turn + 1) % 60;
		if (turn == 0) {

			y += speed;
		}

	}

}
