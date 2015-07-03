package combine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PlayerDetails extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JRadioButton rad1,rad2;
	JButton formed,error;
	JTextField defenders, mid, strikers;
	static String str;
	
	public static String toss() {
		int rand;
		rand = (int) (Math.random() * 2);
		if (rand % 2 == 0)
			str = "Heads";
		else
			str = "Tails";
		return str;
	}

	
	public void pFormation()
	{
		//JButton formation = new JButton("Formation");
		error = new JButton("Error! Invalid formation");
		formed = new JButton("OK");
		formed.addActionListener(this);
		defenders = new JTextField(10);
		mid = new JTextField(10);
		strikers = new JTextField(10);
		defenders.setBounds(50, 50, 5, 5);
		/*add(formation);
		add(defenders);
		add(mid);
		add(strikers);
		add(formed);
		add(error).setVisible(false);*/
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==formed)
		{
			String data = defenders.getText();
			String data1 = mid.getText();
			String data2 =strikers.getText();
			int d = Integer.parseInt(data);
			int d1 = Integer.parseInt(data1);
			int d2 = Integer.parseInt(data2);
			int total = d + d1 + d2;
			if(total!=10 || d>6 || d<3 || d1 >6 || d1<3 || d2<1 || d2>4)
				add(error).setVisible(true);
			else
				System.out.println("");	//go to the game
			//System.out.println(data);
		}
		
	}
}