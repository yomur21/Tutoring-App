package frames;

import javax.swing.JFrame;

import user.BalanceSetter;
import user.User;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BalanceModifyFrame extends JFrame{
	/**
	 * I use polymorphism here to refer to Tutors and Students by using an interface.
	 */
private BalanceSetter user;
private JTextField textField;

public BalanceModifyFrame(BalanceSetter u) {
	/**
	 * I created some JLabels and JTextFields here. 
	 */
	getContentPane().setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	getContentPane().setBackground(new Color(128, 128, 255));
	this.user= u;
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Modify your balance: ");
	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel.setBounds(144, 21, 156, 13);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Balance: ");
	lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel_1.setBounds(84, 64, 81, 13);
	getContentPane().add(lblNewLabel_1);
	
	textField = new JTextField();
	textField.setBounds(150, 62, 115, 19);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	/**
	 * I created a button.
	 */
	JButton btnNewButton = new JButton("Modify");
	btnNewButton.setBackground(new Color(249, 198, 253));
	btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton.setBounds(165, 95, 85, 21);
	getContentPane().add(btnNewButton);
	/**
	 * I used a regex here to check if the input value matches a number or not. 
	 * If it does, it uses the parseInt method of the Integer class, and the user's 
	 * new balance is set. If not, displays an error message.
	 */
	btnNewButton.addActionListener(e-> {
		if (textField.getText().matches("\\d+")== false) {
			JOptionPane.showMessageDialog(null, "Please enter a valid balance!");
			return;
		}
		
		int balance= Integer.parseInt(textField.getText());
		user.setBalance(balance);
		JOptionPane.showMessageDialog(null, "Successfully changed balance! Please log in again.");
		this.dispose();
	}
	
			);
}
}
