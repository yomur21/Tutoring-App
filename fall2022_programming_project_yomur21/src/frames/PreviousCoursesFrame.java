package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;

import course.RegularCourse;
import student.Student;
import java.awt.FlowLayout;
import java.util.Map;
import java.awt.Color;
import java.awt.Font;

public class PreviousCoursesFrame extends JFrame {

	private Student student;
	public PreviousCoursesFrame(Student s) {
		getContentPane().setBackground(new Color(128, 128, 255));
		this.student=s;
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		/**
		 * If the student has no finished courses, this frame will only display
		 * the given JLabel below.
		 */
		if (student.getPreviousCourses().isEmpty()) {
			JLabel lbl= new JLabel("You have not finished any courses yet.");
			lbl.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
			getContentPane().add(lbl);
		}
		
		
		/**
		 * This code checks the previous courses list of the student. It 
		 * iterates over the HashMap, if the student passed, it will display "passed",
		 * if the student failed, it will display "failed". 
		 * 
		 * I then created a label containing information about the previous course and 
		 * added it to the panel. 
		 * 
		 */
		for (Map.Entry<RegularCourse,Boolean> entry: student.getPreviousCourses().entrySet()) {
			RegularCourse previousCourse= entry.getKey();
			String courseStatus="";
			
			if (entry.getValue()) {
				courseStatus= "Passed<html/>";
			}
			else {
				courseStatus= "Failed<html/>";
			}
			/**
			 * Note that to skip to the next line, I used a method I found from the internet.
			 * I have added this to my list of references.
			 */
			JLabel lbl= new JLabel("<html> Course Name: " + previousCourse.getCourseName() + "<br/> Course Tutor: " +
					student.getPreviousCoursesTutorList().get(previousCourse).getName() + "<br/> Course Status: " + courseStatus);
			lbl.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
			getContentPane().add(lbl);
		}
	}
	
	
}
