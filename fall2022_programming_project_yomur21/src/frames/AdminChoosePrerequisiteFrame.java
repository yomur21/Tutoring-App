package frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import course.Equipment;
import course.RegularCourse;
import exceptions.InvalidPrereqException;
import system.TutoringSystem;

public class AdminChoosePrerequisiteFrame extends JFrame{
private RegularCourse course;
private TutoringSystem tsystem;
private JTextField textField;

public AdminChoosePrerequisiteFrame(RegularCourse c, TutoringSystem ts) {
	this.course=c;
	this.tsystem=ts;
	/**
	 * All prerequisites of the course are reset here. In order to create just one frame
	 * for both setting prerequisites and modifying prerequisites, I decided
	 * to use this option. The user is notified of this.
	 */
	c.resetPrereqList();
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(null);
	

	/**
	 * I added some JLabels and JTextFields.
	 */
	JLabel lblNewLabel = new JLabel("<html> Enter the name of a prerequisite: (Note that the <br/> prerequisites list of the course has been reset, so add all the courses needed)</html>");
	lblNewLabel.setBounds(10,10,544,28);
	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Prerequisite Name: ");
	lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel_1.setBounds(64, 74, 137, 13);
	getContentPane().add(lblNewLabel_1);
	
	textField = new JTextField();
	textField.setBounds(211, 72, 164, 19);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	JButton btnNewButton = new JButton("Add Prerequisite");
	btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton.setBounds(114, 116, 164, 21);
	/**
	 * First accesses the list of all courses, if the input name is equal to 
	 * the course name of a course, then tries
	 * to add it to the course's prerequisite list by calling the
	 * addPrerequisite method. If the method throws an InvalidPrereqException,
	 * it shows an error message. 
	 * 
	 * If the course is not found, it also displays an error message.
	 * 
	 * If everything is alright, it adds the course to the prerequisite list of the course.
	 */
	btnNewButton.addActionListener(e-> {
		for (RegularCourse prereq: tsystem.getAllCoursesList()) {
			if (textField.getText().equals(prereq.getCourseName())) {
				try {
				this.course.addPreRequisite(prereq);
				JOptionPane.showMessageDialog(null, "Prerequisite added to course! If you want to add more, please continue, or exit.");
				return;
				
				}
				catch(InvalidPrereqException f) {
					JOptionPane.showMessageDialog(null, f);
					return;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "Prerequisite not found! Please enter a valid prerequisite.");
		return;
	});
	getContentPane().add(btnNewButton);
	
	/**
	 * If the user cancels, the frame is closed.
	 */
	JButton btnNewButton_2 = new JButton("Cancel");
	btnNewButton_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton_2.addActionListener(e-> {
		this.dispose();
	});
	
	btnNewButton_2.setBounds(300, 116, 164, 21);
	getContentPane().add(btnNewButton_2);

}
}
