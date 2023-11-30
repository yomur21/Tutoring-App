package frames;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import course.RegularCourse;
import exceptions.CannotRegisterToCourseException;
import student.Student;
import tutors.Tutor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.FlowLayout;

public class CourseTutorSelect extends JFrame{
private Student student;
private RegularCourse course;

public CourseTutorSelect(Student s, RegularCourse c) {
	/**
	 * I used a flow layout to display the tutors, which the code might not know the 
	 * exact number of. 
	 */
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	this.student=s;
	this.course=c;
	
	/**
	 * If the course has no tutors, it displays an error message.
	 * And the ButtonGroup makes sure that only one tutor is selected at a time.
	 */
	ButtonGroup bg= new ButtonGroup();
	if (course.getTutorsList().isEmpty()) {
		JLabel lbl= new JLabel("This course unfortunately has no tutors yet. Please check later.");
		getContentPane().add(lbl);
	}
	/**
	 * Else, it displays the tutors of the selected course. I set an action command
	 * to easily access the name of the selected tutor.
	 */
	for (Tutor t: course.getTutorsList()) {
		JRadioButton rb= new JRadioButton("<html> Tutor Name: " + t.getName());
		rb.setActionCommand(t.getName());
		rb.setBackground(new Color(251, 198, 249));
		bg.add(rb);
		getContentPane().add(rb);
	}
	
	JButton btn1= new JButton("Pick the selected tutor");
	btn1.addActionListener( e-> {
		/**
		 * If nothing is picked, throws an error.
		 */
		if (bg.getSelection().equals(null)) {
			JOptionPane.showMessageDialog(null, "Please pick a tutor!");
			return;
		}
		/**
		 * Finds the tutor that was picked by using the action command. 
		 * It first checks if the balance of the student is enough to afford
		 * the course. 
		 * If it is enough, it then urges the student to select
		 * a time to take the course. If it is not, it displays the error
		 * message of the thrown exception.
		 */
		for (Tutor t: course.getTutorsList()) {
		if (bg.getSelection().getActionCommand().equals(t.getName())) {
			try {
			this.student.checkBalance(c, t);
			StudentSelectTimeFrame frame1= new StudentSelectTimeFrame(course,student,t);
			frame1.setSize(500,183);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
			}
			catch (CannotRegisterToCourseException f) {
				JOptionPane.showMessageDialog(null, f);
				return;
		}
		}
		}
		
		
	});
	getContentPane().add(btn1);
	
	
}

}
