package frames;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import course.RegularCourse;
import exceptions.CannotRegisterToCourseException;
import student.Student;
import system.TutoringSystem;
import java.awt.Color;
import java.awt.FlowLayout;

public class RegisterCourseFrame extends JFrame{
private TutoringSystem tsystem;
private Student student;

public RegisterCourseFrame(Student s, TutoringSystem ts) {
	this.tsystem=ts;
	this.student= s;
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	/**
	 * I used the flow layout, since I assumed that the system does not know
	 * how many courses are in it. I researched different layouts to use (included
	 * in references), and I thought that the flow layout would be the best one
	 * for this. 
	 * 
	 * The "ButtonGroup" ensures that only a single JRadioButton can be chosen.
	 */
	ButtonGroup bg= new ButtonGroup();
	for (RegularCourse c: tsystem.getAllCoursesList()) {
		JRadioButton rb= new JRadioButton(c.toString() + "</html>") ;
		/**
		 * I added an action command which was the course name here to easily
		 * access the name of the course later. I got inspiration 
		 * from a video about JRadioButtons, which I will include in my references.
		 */
		rb.setActionCommand(c.getCourseName());
		rb.setBackground(new Color(251, 198, 249));
		bg.add(rb);
		getContentPane().add(rb);
	}
	
	/**
	 * The button when clicked first gets the ActionCommand of the button which
	 * was selected, and finds the course which has the same name as the one selected.
	 * 
	 * In this part, the method calls the "tentativeRegisterCourse" method
	 * and checks if the student can take the chosen class or not. If not, an error message
	 * is thrown. If the student can take the class, the student moves
	 * on to pick a tutor, and the "CourseTutorSelectFrame" is opened. 
	 */
	JButton btn1= new JButton("Pick the selected course");
	getContentPane().add(btn1);
	btn1.addActionListener(e-> {
		/**
		 * Gives an error message if nothing is selected.
		 */
		if (bg.getSelection().equals(null)) {
			JOptionPane.showMessageDialog(null, "Please pick a course!");
			return;
		}
		String selection= bg.getSelection().getActionCommand();
		for (RegularCourse c: tsystem.getAllCoursesList()) {
			if (selection.equals(c.getCourseName())) {
				try {
				this.student.tentativeRegisterCourse(c);
				CourseTutorSelect frame1= new CourseTutorSelect(student,c);
				frame1.setSize(400,400);
				frame1.setVisible(true);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
				catch (CannotRegisterToCourseException f) {
					JOptionPane.showMessageDialog(null, f);
				}
			}
		}
	});
	
}
}
