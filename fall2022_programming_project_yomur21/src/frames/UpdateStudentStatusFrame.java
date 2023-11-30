package frames;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import course.RegularCourse;
import student.Student;
import tutors.Tutor;
import java.awt.FlowLayout;
import java.awt.Font;

public class UpdateStudentStatusFrame extends JFrame {
private Tutor tutor;

public UpdateStudentStatusFrame(Tutor t) {
	getContentPane().setBackground(new Color(128, 128, 255));
	this.tutor= t;
	
	
	/**
	 * The button group makes sure that only one student is selected at a time.
	 */
	ButtonGroup bg= new ButtonGroup();
	/**
	 * Iterates through the HashMap of the course-arraylist of students pair and displays
	 * information regarding students. A student can be seen twice if they are
	 * taking different classes from the tutor.
	 */
	
	
	/**
	 * I used an action command to access the student object that is
	 * taking a specific course more easily later.
	 */
	for (Map.Entry<RegularCourse,ArrayList<Student>> entry: tutor.getStudentsList().entrySet()) {
		RegularCourse course= entry.getKey();
		ArrayList<Student> courseStudents= entry.getValue();
		for (Student student: courseStudents) {
		JRadioButton rb= new JRadioButton(student.toString() + "<br/> Taking Course: " + course.getCourseName() + "<br/> At time: " + student.getCourseSchedule().get(course) + "</html>");
		rb.setActionCommand(student.getName() + course.getCourseName());
		rb.setBackground(new Color(251, 198, 249));
		bg.add(rb);
		getContentPane().add(rb);
		}
	}
	
	JButton btn1= new JButton("Select a student to update course status: ");
	btn1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btn1.addActionListener(e-> {
		/**
		 * If no one is picked, throws an error.
		 */
		if (bg.getSelection()==null) {
			JOptionPane.showMessageDialog(null, "Please pick a student if you want to update their status!");
			return;
		}
		
		/**
		 * Iterates over the HashMap again and finds the selected student. When the
		 * student is found in the HashMap, the UpdateStudentStatusFrame2 is opened.
		 */
		for (Map.Entry<RegularCourse,ArrayList<Student>> entry: tutor.getStudentsList().entrySet()) {
			for (Student s: entry.getValue()) {
			if (bg.getSelection().getActionCommand().equals(s.getName() + entry.getKey().getCourseName())) {
				UpdateStudentStatusFrame2 frame= new UpdateStudentStatusFrame2(tutor, s, entry.getKey());
				frame.setSize(400,150);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}
			}
		}
	});
	
	/**
	 * I used a flow layout as it is easier to add components when we do not know how
	 * many elements there will be.
	 */
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	getContentPane().add(btn1);
	/**
	 * Exits when the Cancel button is clicked.
	 */
	JButton btn2= new JButton("Cancel");
	btn2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btn2.addActionListener(e-> {
		this.dispose();
	});
	getContentPane().add(btn2);
}
}
