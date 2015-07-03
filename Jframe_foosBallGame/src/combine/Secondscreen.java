package combine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Secondscreen extends JFrame implements ActionListener {
	/**
* 
*/
	JButton bt = new JButton("Error");
	private static final long serialVersionUID = 1L;
	String Heads = "Heads";
	String Tails = "Tails";
	String data, data1, data2, data3;
	static int d, d1, d2, d3, total;
	static boolean flag = false;
	static int sins = 0;
	JButton but, error, formed, error1;
	JTextField defenders, mid, strikers, lev;

	public Secondscreen() {
		secondscreen();
	}

	public void secondscreen() {
		JButton but1, l1;
		setSize(1000, 600);
		setResizable(true);// We can adjust size
		setDefaultCloseOperation(EXIT_ON_CLOSE);// Optional to use
		setLocationRelativeTo(null);
		JLabel background = new JLabel(new ImageIcon("FD2.jpg"));
		add(background);
		
		background.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		// setContentPane(new JLabel(new
		// ImageIcon("/home/nano/Desktop/background.jpg")));
		setLayout(new FlowLayout());
		l1 = new JButton("SinglePlayer");
		but1 = new JButton("MultiPlayer");
		// l1.addActionListener(this);
		but1.addActionListener(this);
		l1.setActionCommand("SinglePlayer");
		but1.setActionCommand("MultiPlayer");
		setBackground(Color.RED);
		add(l1);
		add(but1);
		Toss();
		pFormation();
		setVisible(true);
		// setVisible(false);
	}

	public void Toss() {
		JRadioButton rad1 = new JRadioButton("Heads");
		JRadioButton rad2 = new JRadioButton("Tails");
		ButtonGroup bg = new ButtonGroup();
		bg.add(rad1);
		bg.add(rad2);
		add(rad1);
		add(rad2);
		but = new JButton("Toss done\n. Coin shows: " + PlayerDetails.toss());
		add(but).setVisible(false);
		add(bt).setVisible(false);
		rad1.addActionListener(this);
		rad2.addActionListener(this);
	}

	public void pFormation() {
		JButton formation = new JButton("Formation");
		JButton level = new JButton("Levels 1,2,3");
		error = new JButton("Error! Invalid formation");
		error1 = new JButton("Error! Invalid Level");
		formed = new JButton("OK");
		formed.addActionListener(this);
		defenders = new JTextField(12);
		mid = new JTextField(12);
		strikers = new JTextField(12);
		defenders.setBounds(50, 50, 5, 5);
		lev = new JTextField(10);
		add(formation);
		add(defenders);
		add(mid);
		add(strikers);
		add(level);
		add(lev);
		add(formed);
		add(error).setVisible(false);
		add(error1).setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String value = e.getActionCommand();
		if (value.equals(PlayerDetails.str)) {
			flag = true;
			sins = 1;
			add(but).setVisible(true);
		} else {
			flag = false;
			add(but).setVisible(true);
		}
		if (e.getSource() == formed) {
			data = defenders.getText();
			data1 = mid.getText();
			data2 = strikers.getText();
			data3 = lev.getText();
			try {
				if (data.equals("") || data1.equals("") || data2.equals("")
						|| data3.equals(""))
				{
					add(bt).setVisible(true);
					throw new IllegalArgumentException("Input is wrong");
					
				}

			} catch (IllegalArgumentException E) {
				add(bt).setVisible(true);

			}
			d = Integer.parseInt(data);

			d1 = Integer.parseInt(data1);
			d2 = Integer.parseInt(data2);
			d3 = Integer.parseInt(data3);
			total = d + d1 + d2;
			if (total != 10 || d > 6 || d < 3 || d1 > 6 || d1 < 3 || d2 < 1
					|| d2 > 4)
				add(error).setVisible(true);
			else if (d3 > 3 || d3 < 1) {
				add(error1).setVisible(true);
			} else {
				setVisible(false);
				BounceBall b = new BounceBall();
				b.ma();

			}
			// System.out.println(""); //go to the game
			// System.out.println(data);
		}
	}

}