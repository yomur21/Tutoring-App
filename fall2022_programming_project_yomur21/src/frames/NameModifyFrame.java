package frames;

import javax.swing.JFrame;

import student.Student;
import user.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NameModifyFrame extends JFrame {

	private User user;
	private JTextField textField;
	public NameModifyFrame(User u) {
		getContentPane().setBackground(new Color(128, 128, 255));
		this.user= u;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modify your name and surname: ");
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel.setBounds(143, 24, 228, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(90, 81, 68, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(168, 80, 162, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.setBackground(new Color(225, 173, 248));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(203, 115, 85, 21);
		getContentPane().add(btnNewButton);
		/**
		 * I used a regex here to make sure the user enters a set of letters.
		 * I also assume that everyone in the system has only one name and a surname.
		 * If the user does not match this criterion, the code will display
		 * an error message. Else, the name of the User will be set to the new
		 * input name. 
		 */
		btnNewButton.addActionListener( e-> {
			if (textField.getText().matches("[a-zA-Z]+" + " " + "[a-zA-Z]+")== false) {
				JOptionPane.showMessageDialog(null,"Please enter your name and surname with a space between them!");
				return;
			}
			
			String newName= textField.getText();
			user.setName(newName);
			JOptionPane.showMessageDialog(null, "Successfully changed name! Please log in again.");
			this.dispose();
			
		}
		);
	}
}
