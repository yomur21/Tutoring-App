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

public class AdminEditCourseFrame extends JFrame{
private TutoringSystem tsystem;

public AdminEditCourseFrame(TutoringSystem ts) {
	this.tsystem=ts;
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	/**
	 * I used a flow layout here to add course information iteratively. I set the action
	 * command of each JRadioButton as the course name, so that I can access
	 * it later.
	 */
	ButtonGroup bg= new ButtonGroup();
	for (RegularCourse c: tsystem.getAllCoursesList()) {
		JRadioButton rb= new JRadioButton(c.toString() + "</html>") ;
		rb.setActionCommand(c.getCourseName());
		rb.setBackground(new Color(251, 198, 249));
		bg.add(rb);
		getContentPane().add(rb);
	}
	
	JButton btn1= new JButton("Edit the selected course's information");
	getContentPane().add(btn1);
	/**
	 * If nothing is selected, displays an error message.
	 */
	btn1.addActionListener(e-> {
		if (bg.getSelection()==null) {
			JOptionPane.showMessageDialog(null, "Please pick a course!");
			return;
		}
		
		/**
		 * If a course is selected, accesses the course in the background, 
		 * and opens an AdminEditCourseNameFrame. 
		 */
		String selection= bg.getSelection().getActionCommand();
		for (RegularCourse c: tsystem.getAllCoursesList()) {
			if (selection.equals(c.getCourseName())) {
				AdminEditCourseNameFrame frame1 = new AdminEditCourseNameFrame(c,tsystem);
				frame1.setSize(700,220);
				frame1.setVisible(true);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
		}
	});
}
}
