package frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import course.AdvancedCourse;
import course.BeginnerCourse;
import course.RegularCourse;
import system.TutoringSystem;

public class AdminEditCourseNameFrame extends JFrame {

	private RegularCourse course;
	private TutoringSystem tsystem;
	private JTextField textField;
	
	public AdminEditCourseNameFrame(RegularCourse c, TutoringSystem ts) {
		this.course=c;
		this.tsystem=ts;
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the new name of the course (If not, click on the other buttons.)");
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel.setBounds(91, 21, 496, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Course Name: ");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(123, 67, 116, 13);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(275, 65, 211, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Edit the Course Name");
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(29, 118, 195, 21);
		/**
		 * If the edit button is clicked, the code first checks if the input is a space
		 * character or not. If it is, throws an error message.
		 */
		btnNewButton.addActionListener(e-> {
			if (textField.getText().matches("\\s*")) {
				JOptionPane.showMessageDialog(null, "Please enter a course name that is not blank!");
				return;
			}
			/**
			 * Else, it sets the course name as the input name.
			 */
			course.setCourseName(textField.getText());
			JOptionPane.showMessageDialog(null, "Successfully changed the name of the course!");
			
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset and Add Equipments");
		btnNewButton_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_1.setBounds(234, 118, 202, 21);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(e-> {
			/**
			 * If the equipments button is clicked, opens the AdminChooseEquipmentFrame.
			 */
			AdminChooseEquipmentFrame frame2 = new AdminChooseEquipmentFrame(c,tsystem);
			frame2.setSize(700,220);
			frame2.setVisible(true);
			frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
			
		});

		JButton btnNewButton_2 = new JButton("Reset and Add Prerequisites");
		btnNewButton_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_2.setBounds(446, 118, 216, 21);
		getContentPane().add(btnNewButton_2);
		/**
		 * If the prerequisite button is clicked, opens the AdminChoosePrerequisiteFrame. 
		 */
		btnNewButton_2.addActionListener(e-> {
			AdminChoosePrerequisiteFrame frame1= new AdminChoosePrerequisiteFrame(course, tsystem);
			frame1.setSize(550, 250);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
		});
		
		JButton btnNewButton_3 = new JButton("Cancel");
		/**
		 * If the cancel button is clicked, closes the frame. 
		 */
		btnNewButton_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_3.setBounds(294, 155, 85, 21);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(e-> {
			this.dispose();
			
		});
		
		
		
		
		
	}
}
