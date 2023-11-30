package frames;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;

import course.RegularCourse;
import student.Student;
import tutors.Tutor;
import java.awt.Color;

public class CurrentCoursesFrame extends JFrame{
private Student student;
public CurrentCoursesFrame(Student s) {
	getContentPane().setBackground(new Color(128, 128, 255));
	this.student=s;
	/**
	 * The number of current courses is subject to change. Thus I decided 
	 * to use a flow layout here to create JLabels by using a for loop and adding
	 * them to the panel.
	 */
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	/**
	 * Iterates through the HashMap which contains the current courses
	 * of the student. It displays some information regarding the course. And then
	 * the label is added to the panel.
	 */
	for (Map.Entry<RegularCourse,Tutor> entry: student.getCurrentCourses().entrySet()) {
		RegularCourse currentCourse= entry.getKey();
		Tutor courseTutor= entry.getValue();
		JLabel lbl= new JLabel("<html> Course Name: " + currentCourse.getCourseName() + "<br/> Course Tutor: " +
				courseTutor.getName() + "<br/> Course Time: " + student.getCourseSchedule().get(currentCourse)+ "<html/>");
		lbl.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		getContentPane().add(lbl);
	}
}
}
