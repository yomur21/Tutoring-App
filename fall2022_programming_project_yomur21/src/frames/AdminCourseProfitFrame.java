package frames;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import course.RegularCourse;
import system.TutoringSystem;


public class AdminCourseProfitFrame extends JFrame{

	private TutoringSystem tsystem;
	
	public AdminCourseProfitFrame(TutoringSystem ts) {
		this.tsystem= ts;
		
		/**
		 * I used the flow layout to iteratively add each course as a JLabel.
		 */
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		
		/**
		 * For each course in the course list of the system, calculates
		 * the equipment profit by calling the "calculateCourseEquipmentsProfit
		 * method, and then calculates the tutoring profit by calling the
		 * calculateCourseTutoringProfit method. It displays
		 * the two profits, and adds them to display the total profit of the course.
		 */
		for (RegularCourse c: tsystem.getAllCoursesList()) {
			JLabel lbl= new JLabel("<html> Course Name: " + c.getCourseName() +"<br/>Course's Equipment Profit: " + (int)tsystem.calculateCourseEquipmentsProfit(c)+ " TL" + 
		"<br/> Course's Tutoring Profit: " + (int)tsystem.calculateCourseTutoringProfit(c) + " TL" +
					"<br/>Course's Total Profit: " + (int)(tsystem.calculateCourseEquipmentsProfit(c)+tsystem.calculateCourseTutoringProfit(c)) + " TL</html>");
			lbl.setBackground(new Color(251, 198, 249));
			getContentPane().add(lbl);
		}
	}
}
