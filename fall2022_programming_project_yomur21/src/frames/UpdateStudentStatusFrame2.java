package frames;

import javax.swing.JFrame;

import course.RegularCourse;
import student.Student;
import tutors.Tutor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

public class UpdateStudentStatusFrame2 extends JFrame{
Student student;
Tutor tutor;
RegularCourse course;
public UpdateStudentStatusFrame2(Tutor t, Student s, RegularCourse c) {
	this.tutor=t;
	this.student=s;
	this.course=c;
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Did " + student.getName() + "pass or fail " + c.getCourseName() + "?");
	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel.setBounds(48, 10, 340, 13);
	getContentPane().add(lblNewLabel);
	
	JButton btnNewButton = new JButton("Pass");
	btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton.setBounds(88, 49, 99, 33);
	getContentPane().add(btnNewButton);
	/**
	 * If the tutor clicks on "pass" the previously selected student will have
	 * passed the course, and the "updateStudentStatus" method will be called.
	 */
	btnNewButton.addActionListener(e-> {
		tutor.updateStudentStatus(course, student, "pass");
		JOptionPane.showMessageDialog(null, "Successfully updated the course status of the student!");
		return;
		
	});
	
	JButton btnNewButton_1 = new JButton("Fail");
	/**
	 * If the tutor clicks on "Fail" the previously selected student will have failed
	 * the course, and the "updateStudentStatus" method will be called.
	 */
	btnNewButton_1.addActionListener(e-> {
		tutor.updateStudentStatus(course, student, "fail");
		JOptionPane.showMessageDialog(null, "Successfully updated the course status of the student!");
		return;
		
	});
	btnNewButton_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton_1.setBounds(224, 49, 99, 33);
	getContentPane().add(btnNewButton_1);
	
	
}
}
