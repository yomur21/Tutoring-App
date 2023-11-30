package frames;

import javax.swing.JFrame;

import student.Student;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentModifyFrame1 extends JFrame {

	private Student student;
	private JTextField textField;
	public StudentModifyFrame1(Student s) {
		getContentPane().setBackground(new Color(128, 128, 255));
		this.student= s;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modify your age: ");
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel.setBounds(148, 33, 138, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age: ");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(110, 69, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(148, 67, 110, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.setBackground(new Color(250, 211, 252));
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(158, 104, 85, 21);
		/**
		 * I used a regex here to make sure the input text matches a number. If not,
		 * it throws an error message. 
		 * If it matches a number, then the code uses the parseInt method
		 * of Integer to turn the String into an integer, and sets the age of the student
		 * to the input age.
		 */
		btnNewButton.addActionListener(e-> {
			if (textField.getText().matches("\\d+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid age!");
				return;
			}
			
			int age= Integer.parseInt(textField.getText());
			student.setAge(age);
			JOptionPane.showMessageDialog(null, "Successfully changed age! Please log in again.");
			this.dispose();
			
		}
		
				);
		getContentPane().add(btnNewButton);
		
		
	}
	
}
