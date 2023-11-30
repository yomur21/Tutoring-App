package frames;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import course.RegularCourse;
import system.TutoringSystem;

public class AdminInquireCourseStudentFrame extends JFrame {

	private TutoringSystem tsystem;
	
	public AdminInquireCourseStudentFrame(TutoringSystem ts) {
	this.tsystem=ts;
	getContentPane().setBackground(new Color(128, 128, 255));
	/**
	 * I used the flow layout to add course information iteratively.
	 */
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	/**
	 * I used a button group so that only one course is selected at a time.
	 */
	ButtonGroup bg= new ButtonGroup();
	/**
	 * Creates a JRadioButton containing the information of every course. 
	 */
	for (RegularCourse c: tsystem.getAllCoursesList()) {
		JRadioButton rb= new JRadioButton(c.toString() + "</html>") ;
		/**
		 * I added an action command to access the selected course later.
		 */
		rb.setActionCommand(c.getCourseName());
		rb.setBackground(new Color(251, 198, 249));
		bg.add(rb);
		getContentPane().add(rb);
	}
	
	JButton btn1= new JButton("Inquire Course Student Information");
	getContentPane().add(btn1);
	btn1.addActionListener(e-> {
		/**
		 * If no course is selected, throws an error message. 
		 */
		if (bg.getSelection()==null) {
			JOptionPane.showMessageDialog(null, "Please pick a course!");
			return;
		}
		
		/**
		 * If a course is selected, the code first finds it on the background, 
		 * and calls the AdminStudentInfo frame with the course as the parameter.
		 */
		String selection= bg.getSelection().getActionCommand();
		for (RegularCourse c: tsystem.getAllCoursesList()) {
			if (selection.equals(c.getCourseName())) {
				AdminStudentInfoFrame frame1 = new AdminStudentInfoFrame(c);
				frame1.setSize(700,220);
				frame1.setVisible(true);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
		}
	});
	
	
	}
	
}
