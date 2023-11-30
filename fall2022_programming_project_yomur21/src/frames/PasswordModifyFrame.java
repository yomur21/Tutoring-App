package frames;

import javax.swing.JFrame;

import user.User;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PasswordModifyFrame extends JFrame{
User user;
private JTextField textField;

public PasswordModifyFrame(User u) {
	getContentPane().setBackground(new Color(128, 128, 255));
	this.user=u;
	getContentPane().setLayout(null);
	/**
	 * I creates some JLabels and a JTextField.
	 */
	JLabel lblNewLabel = new JLabel("Modify password: ");
	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel.setBounds(149, 20, 135, 13);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Password: ");
	lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel_1.setBounds(67, 50, 83, 13);
	getContentPane().add(lblNewLabel_1);
	
	textField = new JTextField();
	textField.setBounds(149, 48, 116, 19);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	/**
	 * The button, when clicked, first checks if the password is not a blank space or not.
	 * If it is, it throws an error message. 
	 * 
	 * If not, the password of the user is set to the new password. 
	 */
	JButton btnNewButton = new JButton("Modify");
	btnNewButton.setBackground(new Color(253, 200, 249));
	btnNewButton.setForeground(new Color(0, 0, 0));
	btnNewButton.setBounds(163, 77, 85, 21);
	getContentPane().add(btnNewButton);
	btnNewButton.addActionListener(e-> {
		if (textField.getText().matches("\\w+")==false) {
			JOptionPane.showMessageDialog(null, "Please enter a valid password! Your password cannot contain any whitespaces.");
			return;
		}
		
		String password= textField.getText();
		user.setPassword(password);
		JOptionPane.showMessageDialog(null, "Successfully changed password! Please log in again.");
		this.dispose();
		
	});
}
}
