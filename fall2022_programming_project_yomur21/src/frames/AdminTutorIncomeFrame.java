package frames;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import system.TutoringSystem;
import tutors.Tutor;
import java.awt.FlowLayout;

public class AdminTutorIncomeFrame extends JFrame {

	private TutoringSystem tsystem;
	
	public AdminTutorIncomeFrame(TutoringSystem ts) {
		getContentPane().setBackground(new Color(128, 128, 255));
		/**
		 * I used a flow layout to iteratively add tutors.
		 */
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		this.tsystem= ts;
		/**
		 *Iterates over all tutors and displays their balance. I start each tutor
		 *with 0 initial balance, thus their balance will be their income, and the 
		 *income is displayed for each tutor. 
		 */
		for (Tutor t: tsystem.getAllTutorsList()) {
			JLabel lbl= new JLabel("<html> Tutor Name: " + t.getName() + "<br/>Tutor Income: " + t.getBalance() + " TL</html>");
			lbl.setBackground(new Color(251, 198, 249));
			getContentPane().add(lbl);
		}
	}
}
