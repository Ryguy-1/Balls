import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {

	Font bigFont;
	Font smallFont;

	int startX = 250;
	int startY= 700;
	
	ArrayList<Integer> keys = new ArrayList<>();

	Character character = new Character(startX, startY, 50, 50);

	ObjectManager manager = new ObjectManager();

	Timer timer;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = MENU_STATE;

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	GamePanel() {

		timer = new Timer(1000 / 60, this);

		bigFont = new Font("Arial", Font.PLAIN, 48);
		smallFont = new Font("Arial", Font.PLAIN, 22);

		manager.addObject(character);

	}

	void ActionPerformed() {

	}

	void StartGame() {

		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {

		manager.manageEnemies();
		manager.checkCollision();
		manager.getScore();

		if (character.isAlive == false) {

			currentState = END_STATE;
			character = new Character(250, 700, 50, 50);
			manager.reset();

		}
		manager.addObject(character);
		manager.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Runner.width, Runner.height);

		g.setColor(Color.ORANGE);
		g.setFont(bigFont);
		g.drawString("Balls", 75, 200);

		// g.setColor(Color.ORANGE);
		g.setFont(smallFont);
		g.drawString("Press Enter To Begin", 150, 650);
	}

	void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Runner.width, Runner.height);

		manager.draw(g);

	}

	void drawEndState(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(0, 0, Runner.width, Runner.height);

		g.setColor(Color.BLACK);
		g.setFont(bigFont);
		g.drawString("You Lost", 125, 200);

		g.setFont(smallFont);
		g.drawString("Press ENTER To Try Again", 150, 650);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		repaint();

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			//manager.addObject(new Projectile(character.x + 20, character.y, 10, 10, new Random().nextFloat()));

		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			currentState += 1;

		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if (currentState == GAME_STATE){
			
			int newX = startX-e.getX();
			int newY = startY-e.getY();
			float angle = 0;
			if(newX > 0){
				angle = (float)Math.atan((float)newX/ (float)newY );
			}else{
				angle = (float)Math.atan((float)newY/ (float)newX);
			}
			
			
		
			
			System.out.println(angle);
			manager.addObject(new Projectile(startX+20, startY+20, 10, 10, angle));
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
