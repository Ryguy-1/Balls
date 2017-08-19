import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Block extends GameObject {

	int speed;
	int turn;
	Random random = new Random();
	int value;
	int printValue;

	public Block(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 55;
		value = random.nextInt(9);
		printValue=value+1;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
		g.setFont(GamePanel.smallFont);
		g.drawString("" + printValue, x + 20, y + 20);

	}

	void update() {

		super.update();
		//turn = (turn + 1) % 60;
		
		//	y += speed;

			if (y > 750) {

				GamePanel.currentState = GamePanel.END_STATE;

			}

		}
			
		

	void collision(){
		printValue--;
		value--;
		
		if (value<=0){
			
			isAlive=false;
			
		}
		
	
}
}

