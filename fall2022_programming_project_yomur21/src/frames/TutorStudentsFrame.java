package frames;

import java.awt.Color;
import java.util.Map;


import javax.swing.JFrame;
import javax.swing.JLabel;


import course.RegularCourse;
import student.Student;
import tutors.Tutor;
import java.awt.FlowLayout;

public class TutorStudentsFrame extends JFrame{
private Tutor tutor;
public TutorStudentsFrame(Tutor t) {
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	this.tutor=t;
	
	
	/**
	 * I use a flow layout to iteratively add students.
	 */
	for (Student s: tutor.getTutorStudentsList()) {
		String a= "";
		/**
		 * If the student has no previous courses, I add this information to
		 * the toString return value of the student and add it as a label.
		 */
		if (s.getPreviousCourses().isEmpty()) {
			JLabel lbl2= new JLabel(s.toString() + "<br/> The student has not finished any courses yet.");
			getContentPane().add(lbl2);
			continue;
		}
		/**
		 * If the student has passes courses before, it displays all the previous courses
		 * and specifies if they were passed or failed. This String is then added
		 * to the toString method's return value. 
		 */
		for (Map.Entry<RegularCourse,Boolean> ent: s.getPreviousCourses().entrySet()) {
			a= a.concat(ent.getKey().getCourseName() + ((ent.getValue()) ? "(Passed), " : "(Failed), "));
		}
		
		JLabel lbl= new JLabel(s.toString()+ "<br/> Previous Courses: " + a);
		getContentPane().add(lbl);

	}
}
}
