import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	int speed;
	float angle = 0;
	static int numberOfProjectiles = 4;
	static int previousNumberOfProjectiles = numberOfProjectiles;

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

		
			
		
		
		if(x>Runner.width-15){
			
			angle -= Math.PI/2;
			
			//angle-=angle;
			
			
		}
		if(x<15){
			
			angle += Math.PI/2;
			//angle+=angle;
			
		}
		if(y<0&&x<250){
			
			angle -= Math.PI/8;
			
		}else if(y<0&&x>250){
			
			angle += Math.PI/8;
			
		}
		if (y>Runner.height-10){
			
			isAlive=false;
			
		}
			

	x+=Math.cos(angle)*speed;
	y+=Math.sin(angle)*speed;

}

	void bounce(Block b){
		
		//if(angle>Math.PI/2){
			
			angle -= Math.PI/2;
			
			if(b.collisionBox.intersects(collisionBox)){
				
				
				
				
				
				//Freezes game
				
				x+=Math.cos(angle)*speed;
				y+=Math.sin(angle)*speed;
				
			}
			
			
			
		//}
		
		
	}
	
	
	}


