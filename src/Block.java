import java.awt.Graphics;

public class Block extends GameObject {

	int speed;
	int turn;

	public Block(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 55;

	}

	void draw(Graphics g) {

		g.drawRect(x, y, width, height);

	}

	void update() {
		
		
		//if(turn==0){
			
			//y+=speed;
			
			//turn+=1;
		//}else if(turn==1){
			
			//y+=speed;
			
			//turn+=1;
			//turnBefore+=1;
			
		//}
		
		
		super.update();
		turn = (turn + 1) % 60;
		if (turn == 0) {

		y += speed;
			
		
			
		
			
			
			
		}

	}

}
