package frames;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;

import course.RegularCourse;
import tutors.Tutor;

public class AdminTutorAvailableSlotsScheduleFrame extends JFrame {

	private Tutor tutor;
	
	public AdminTutorAvailableSlotsScheduleFrame(Tutor t) {
		this.tutor=t;
		
		/**
		 * This works very similar to the TutorScheduleFrame. The only difference
		 * is that if there is a student mapped to the given time, 
		 * then the code skips that time slot and only displays
		 * the information where there is an available time slot, with no
		 * student.
		 */
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		getContentPane().setBackground(new Color(128, 128, 255));
		for (Map.Entry<String,RegularCourse> entry: tutor.getCourseSchedule().entrySet()) {
			String time= entry.getKey();
			RegularCourse currentCourse= entry.getValue();
			if (!t.getStudentSchedule().containsKey(time)) {
				JLabel lbl= new JLabel("<html> Course Name: " + currentCourse.getCourseName() + "<br/> Course Time: " + time + "<html/>");
				lbl.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
				getContentPane().add(lbl);
			}
		}
	}
}
