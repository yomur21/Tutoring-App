package frames;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;

import course.RegularCourse;
import student.Student;
import tutors.Tutor;

public class TutorScheduleFrame extends JFrame {

	private Tutor tutor;
	
	public TutorScheduleFrame(Tutor t) {
		this.tutor= t;
		/**
		 * I used a flow layout here to add the courses iteratively.
		 */
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		getContentPane().setBackground(new Color(128, 128, 255));
		/**
		 * Iterates over the courseSchedule TreeMap of the tutor
		 * and displays information regarding the course. 
		 */
		for (Map.Entry<String,RegularCourse> entry: tutor.getCourseSchedule().entrySet()) {
			String time= entry.getKey();
			RegularCourse currentCourse= entry.getValue();
			/**
			 * I used the method that skips to the next line that I learned from the Internet here.
			 * I have linked it on my references.
			 */
			JLabel lbl= new JLabel("<html> Course Name: " + currentCourse.getCourseName() + "<br/> Course Student: " +
					/**
					 * This part shows the student's name if there is a student, and displays "no students"
					 * when there is none. I used the ? : operator here.
					 */
					((tutor.getStudentSchedule().get(time)!=null)  ? tutor.getStudentSchedule().get(time) : "No students yet.") + "<br/> Course Time: " + time + "<html/>");
			lbl.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
			getContentPane().add(lbl);
		}
		
	}
}
