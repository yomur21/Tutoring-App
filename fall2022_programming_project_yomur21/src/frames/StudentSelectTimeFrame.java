package frames;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import course.RegularCourse;
import exceptions.CannotRegisterToCourseException;
import student.Student;
import tutors.Tutor;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Map;

public class StudentSelectTimeFrame extends JFrame {
private Student student;
private Tutor tutor;
private RegularCourse course;


public StudentSelectTimeFrame (RegularCourse c, Student s, Tutor t) {
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	this.student=s;
	this.tutor=t;
	this.course=c;
	/**
	 * I do not know the number of times a tutor is teaching a course, therefore
	 * I again decided to use a flow layout for this GUI.
	 */
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	/**
	 * The button group makes sure only one time is picked. It creates radio buttons
	 * for each time slot of the given course.
	 */
	
	/**
	 * I also added an action command to access the time more easily.
	 */
	ButtonGroup bg= new ButtonGroup();
	for (Map.Entry<String,RegularCourse> entry: tutor.getCourseSchedule().entrySet()) {
		if (course.equals(entry.getValue())) {
			String time= entry.getKey();
			JRadioButton rb= new JRadioButton(time) ;
			rb.setActionCommand(time);
			rb.setBackground(new Color(251, 198, 249));
			bg.add(rb);
			getContentPane().add(rb);
		}

	}
	
	/**
	 * If nothing is picked, returns an error message.
	 */
	JButton btn1= new JButton("Select a time");
	btn1.addActionListener(e-> {
		
		if (bg.getSelection()==null) {
			JOptionPane.showMessageDialog(null, "Please pick a time!");
			return;
		}
		
		/**
		 * First tries to register the student into the course, however, if the student
		 * is taking another class at this time, it will display an error message.
		 * 
		 * Thus, when this frame is done. The student will successfully enroll into a course.
		 */
		String courseTime= bg.getSelection().getActionCommand();
		try {
		student.registerCourse(course, tutor, courseTime);
		JOptionPane.showMessageDialog(null, "Successfully enrolled into course!");
		}
		catch(CannotRegisterToCourseException f) {
			JOptionPane.showMessageDialog(null, f);
			return;
		}
		
		
	});
	getContentPane().add(btn1);
}
}
