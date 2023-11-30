package frames;

import javax.swing.JFrame;

import course.RegularCourse;
import exceptions.InvalidTutorException;
import exceptions.InvalidTutoringCostException;
import tutors.Tutor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CourseFeeSelectFrame extends JFrame {
private String time;
private Tutor tutor;
private RegularCourse course;
private JTextField textField;

public CourseFeeSelectFrame(Tutor t, RegularCourse c, String time) {
	this.time=time;
	this.tutor= t;
	this.course= c;
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Please enter an hourly fee in TL for the course.");
	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel.setBounds(71, 23, 319, 13);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Course Fee: ");
	lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel_1.setBounds(23, 73, 141, 13);
	getContentPane().add(lblNewLabel_1);
	
	textField = new JTextField();
	textField.setBounds(126, 71, 178, 19);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	JButton btnNewButton = new JButton("Enter");
	btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton.setBounds(169, 109, 85, 21);
	getContentPane().add(btnNewButton);
	/**
	 * I used a regex to check if the input value is not a number, if not,
	 * it displays an error message.
	 * 
	 * If it is a number, it uses the parseInt method of the Integer class to
	 * turn the hourly fee into an integer. 
	 * 
	 * The code tries to call the method "setCourseCost". If the method throws an InvalidTutoringException,
	 * or an InvalidTutorException, then the particular error message is displayed.
	 * 
	 * If everything is alright, the course will be successfully added to the
	 * tutor.
	 */
	btnNewButton.addActionListener(e-> {
		if (textField.getText().matches("[0-9]+")==false) {
			JOptionPane.showMessageDialog(null, "Please enter a course fee in TL!");
			return;
		}
		
		int courseFee= Integer.parseInt(textField.getText());
		
		try {
			tutor.setCourseCost(course, this.time, courseFee);
			JOptionPane.showMessageDialog(null, "Course successfully added. Please log in again to see your new schedule.");
			this.dispose();
		}
		
		catch (InvalidTutoringCostException f) {
			JOptionPane.showMessageDialog(null, f);
			return;
		}
		
		catch(InvalidTutorException g) {
			JOptionPane.showMessageDialog(null, g);
		}
		
		
		
		
		
	});
	
	
}
}
