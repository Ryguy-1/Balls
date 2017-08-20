import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Block extends GameObject {

	int speed;
	Random random = new Random();
	int value;
	int printValue;
	int randomValue = 9 * ObjectManager.turn;

	public Block(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 55;
		value = random.nextInt(randomValue);
		printValue=value+1;
	}

	void draw(Graphics g) {
		
		g.setColor(Color.GRAY);
		
		g.fillRect(x, y, width, height);
		g.setFont(GamePanel.smallFont);
		g.setColor(Color.RED);
		g.drawString("" + printValue, x + 20, y + 20);

	}

	void update() {

		super.update();
		
			y += speed;

			if (y > 750) {

				GamePanel.currentState = GamePanel.END_STATE;

			}
			collisionBox.setBounds(x, y, width, height);

		}
			
		

	void collision(){
		printValue--;
		value--;
		
		if (value<=0){
			
			isAlive=false;
			ObjectManager.score+=1;
			
		}
		
	
}
}

