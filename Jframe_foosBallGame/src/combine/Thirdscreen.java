package combine;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Thirdscreen {

	/**
	 * @param args
	*/
	JFrame fra = new JFrame("Winner:");

	public Thirdscreen(){

		fra.setSize(1200, 900);
		JLabel l = new JLabel();
		l.setText("WINNER : Player 1 ");
		l.setPreferredSize(new Dimension(100,100));
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setVerticalAlignment(JLabel.CENTER);
		fra.add(l);
		fra.setVisible(true);
	}
	
	
}
