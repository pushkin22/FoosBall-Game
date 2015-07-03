package combine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoadingFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	static int BOX_HEIGHT = 600;
	static int BOX_WIDTH = 1001;
	static boolean visible;
	Image bigimage = null;

	public LoadingFrame() {

		JLabel background = new JLabel(new ImageIcon("FD.jpg"));
		add(background);
		background.setLayout(new FlowLayout());

		startScreen();
	}

	public static int boxheight() {
		return BOX_HEIGHT;
	}

	public static int boxwidth() {
		return BOX_WIDTH;
	}

	public void Basicscreen() {
		frame = new JFrame("Foosball");
		setSize(BOX_WIDTH, BOX_HEIGHT);
		setResizable(true);// We can adjust size
		setDefaultCloseOperation(EXIT_ON_CLOSE);// Optional to use
		setLocationRelativeTo(null);

	}

	public void startScreen() {
		Basicscreen();
		JButton button = new JButton("LOADING......");
		JButton button1 = new JButton("LOADING......");
		button.setFont(new Font("Sans Serif", Font.ITALIC, 25));
		button1.setFont(new Font("Sans Serif", Font.BOLD, 30));
		// image1 = new ImageIcon(getClass().getResource("animated.gif"));
		// lab = new JLabel(image1);
		add(button, BorderLayout.NORTH);
		add(button1, BorderLayout.SOUTH);
		// add(lab);
		setVisible(true);

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		visible = false;
		setVisible(false);

	}

}
