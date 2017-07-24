
import javax.swing.JFrame;

public class Runner {

	GamePanel panel;

	JFrame frame;

	static int width = 500;
	static int height = 800;

	public static void main(String[] args) {

		Runner runner = new Runner();

	}

	Runner() {

		frame = new JFrame();

		panel = new GamePanel();

		frame.add(panel);

		frame.addKeyListener(panel);

		frame.addMouseListener(panel);
		setup();

	}

	void setup() {

		frame.setVisible(true);
		frame.setSize(500, 800);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.StartGame();

	}

}
