package frames;

import javax.swing.JFrame;

import user.User;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import system.TutoringSystem;

import javax.swing.JButton;

public class UsernameModifyFrame extends JFrame{

	private User user;
	private TutoringSystem tsystem;
	private JTextField textField;
	public UsernameModifyFrame(User u, TutoringSystem ts) {
		getContentPane().setBackground(new Color(128, 128, 255));
		this.user=u;
		this.tsystem=ts;
		getContentPane().setLayout(null);
		
		/**
		 * I created some JLabels and a JTextField.
		 */
		JLabel lblNewLabel = new JLabel("Modify your username:");
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel.setBounds(141, 23, 167, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(71, 57, 97, 13);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(151, 55, 120, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 * The button, when clicked, checks if the username isn't a blank space or not.
		 * If the input username is a blank space, It throws an error message.
		 * 
		 * If not, it also checks if the given username is already used by some other user.
		 * If it is used, it throws an error message.
		 * 
		 * Finally, if everything is alright, the code sets the user's username.
		 */
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.setBackground(new Color(253, 225, 252));
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(167, 84, 85, 21);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(e -> {
			if (textField.getText().matches("\\w+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid username! Your username cannot contain any whitespaces.");
				return;
			}
			
			for (User user: ts.getAllUsersList()) {
				if (textField.getText().equals(user.getUsername())) {
					JOptionPane.showMessageDialog(null, "Please enter a valid username! This username already exists!");
					return;
				}
			}
			
			String username= textField.getText();
			user.setUsername(username);
			JOptionPane.showMessageDialog(null, "Successfully changed username! Please log in again.");
			this.dispose();
		}
		);
	}
}
