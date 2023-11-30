package frames;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import course.Equipment;
import course.RegularCourse;
import exceptions.InvalidTutorException;
import system.TutoringSystem;
import tutors.Tutor;

public class TutorCourseSelectFrame extends JFrame {

	private Tutor tutor;
	private TutoringSystem tsystem;
	public TutorCourseSelectFrame(Tutor t, TutoringSystem ts) {
		this.tutor= t;
		this.tsystem=ts;
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		/**
		 * I first created a ButtonGroup so that the courses can be picked
		 * one at a time. I used a flow layout again to stack the courses.
		 */
		ButtonGroup bg= new ButtonGroup();
		/**
		 * Iterates over each course.
		 */
		for (RegularCourse c: tsystem.getAllCoursesList()) {
	
			/**
			 * Creates a JRadioButton, and uses the toString method to display
			 * the information about the course.
			 */
			/**
			 * I set the action command of each JRadioButton to be the name of the course,
			 * so that I can access it easily later.
			 */
			JRadioButton rb= new JRadioButton(c.toString()) ;
			rb.setActionCommand(c.getCourseName());
			rb.setBackground(new Color(251, 198, 249));
			bg.add(rb);
			getContentPane().add(rb);
		}
		
		JButton btn1= new JButton("Pick the selected course");
		getContentPane().add(btn1);
		btn1.addActionListener(e-> {
			/**
			 * If nothing is picked, throws an error message.
			 */
			if (bg.getSelection()==null) {
				JOptionPane.showMessageDialog(null, "Please pick a course!");
				return;
			}
			/**
			 * Finds the course that has the same name as the selected one.
			 * 
			 * If the tutors' list of the course has 5 people, no one else can be added.
			 * Thus, throws an error message and terminates.
			 */
			
			String selection= bg.getSelection().getActionCommand();
			for (RegularCourse c: tsystem.getAllCoursesList()) {
				if (selection.equals(c.getCourseName())) {
					if (c.getTutorsList().size()==5) {
						JOptionPane.showMessageDialog(null, "Cannot pick this course! This course already has 5 tutors.");
						return;
					}
					/**
					 * Tries to use the selectCourse method of the tutor. 
					 * If the method throws an InvalidTutorException, an error message
					 * is displayed.
					 * 
					 * If everything is alright, the course is selected, but not added
					 * to the tutor's list of courses yet, as the next frame
					 * will ask the tutor for the time of the course.
					 * 
					 * Opens the CourseTimeSelectFrame.
					 */
					try {
						tutor.selectCourse(c);
						CourseTimeSelectFrame frame1= new CourseTimeSelectFrame(tutor, c);
						frame1.setSize(400,200);
						frame1.setVisible(true);
						frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						this.dispose();
					}
					catch (InvalidTutorException f) {
						JOptionPane.showMessageDialog(null, f);
						return;
					}
					
					
				}
			}
		});
	}
}
