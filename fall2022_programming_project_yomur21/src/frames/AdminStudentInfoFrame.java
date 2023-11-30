package frames;

import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;

import course.RegularCourse;
import student.Student;
import system.TutoringSystem;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

public class AdminStudentInfoFrame extends JFrame{


	private RegularCourse course;
	
	public AdminStudentInfoFrame(RegularCourse c) {
		getContentPane().setBackground(new Color(128, 128, 255));
		this.course=c;
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		/**
		 * If the course has no enrolled students, simply adds a JLabel stating
		 * that the course is empty.
		 */
		if (course.getStudentsList().isEmpty()) {
			JLabel noStudentsLabel= new JLabel ("This course currently has no enrolled students.");
			noStudentsLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
			getContentPane().add(noStudentsLabel);
			
		}
		
		/**
		 * First sorts the students list by the defined criteria. Then displays
		 * the information of each student as a JLabel.
		 */
		Collections.sort(course.getStudentsList());
		for(Student s: course.getStudentsList()) {
			JLabel lbl= new JLabel(s.toString());
			lbl.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
			getContentPane().add(lbl);
			
		}
	}
}
