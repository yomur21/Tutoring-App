package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;

import system.TutoringSystem;
import tutors.Tutor;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

public class TutorInfoFrame extends JFrame{
private TutoringSystem system;
public TutorInfoFrame(TutoringSystem s) {
	getContentPane().setBackground(new Color(128, 128, 255));
	this.system=s;
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	
	/**
	 * Displays the information of every tutor. Since I assumed that the system does not
	 * know the number of tutors, I decided to use a flow layout, to
	 * add each tutor as a stack. The code calls the toString method of each
	 * tutor and creates a JLabel. 
	 */
	for (Tutor t: system.getAllTutorsList()) {
		JLabel lbl= new JLabel(t.toString() + "</html>");
		lbl.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		getContentPane().add(lbl);
	}
	}
}
