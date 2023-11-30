package frames;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import system.TutoringSystem;
import user.Administrator;
import user.User;
import java.awt.Font;
import java.awt.Color;


public class AdminSignUpFrame extends JFrame {

	
	private JPanel panel;
	private JButton btn1;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JTextField field1;
	private JTextField field2;
	private JTextField passwordfield;
	private TutoringSystem system;
	
	
	public AdminSignUpFrame(TutoringSystem s) {
		/**
		 * The AdminSignUpFrame is almost the same code as the StudentSignUpFrame.
		 */
		super("Admin Sign-Up");
		this.system= s;
		/**
		 * I created some components and added them to the panel. 
		 */
		panel= new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setLayout(null);
		getContentPane().add(panel);
		lbl1= new JLabel("Please enter your information.");
		lbl1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl1.setBounds(100,15,200,25);
		lbl2= new JLabel("Real Name:");
		lbl2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl2.setBounds(10,50,80,25);
		lbl3= new JLabel("Username:");
		lbl3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl3.setBounds(10,80,80,25);
		lbl4= new JLabel("Password:");
		lbl4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl4.setBounds(10,110,80,25);
		field1= new JTextField();
		field1.setBounds(100,50,165,25);
		field2= new JTextField();
		field2.setBounds(100,80,165,25);
		passwordfield= new JTextField();
		passwordfield.setBounds(100,110,165,25);
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);
		panel.add(lbl4);
		panel.add(field1);
		panel.add(field2);
		panel.add(passwordfield);
		btn1= new JButton("Enter");
		btn1.setBackground(new Color(132, 251, 209));
		btn1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btn1.setBounds(143,145,80,25);
		panel.add(btn1);
		btn1.addActionListener(e -> {
			/**
			 * I made sure by using regex that the input values were
			 * in the formats that I wanted. A username and password should not contain
			 * any blank spaces,
			 * 
			 * and a user's name must be split into two words. I assumed that each user
			 * has only one name and surname. 
			 */
			if (field1.getText().matches("[a-zA-Z]+" + " " + "[a-zA-Z]+")== false) {
				JOptionPane.showMessageDialog(null,"Please enter your name and surname with a space between them!");
				return;
			}
			
			else if (field2.getText().matches("\\w+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid username! Your username cannot contain any whitespaces.");
				return;
			}
			
			
			else if (passwordfield.getText().matches("\\w+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid password! Your password cannot contain any whitespaces");
				return;
			}
			
			else {
				
				/**
				 * Also, it checks if the username already exists in the system. If so,
				 * throws an error message. 
				 */
				for (User user: system.getAllUsersList()) {
					if (field2.getText().equals(user.getUsername())) {
						JOptionPane.showMessageDialog(null, "Please enter a valid username! This username already exists!");
						return;
					}
				}
				
				/**
				 * Finally, an administrator object is created with the input 
				 * arguments, and added to the system.
				 */
				String name= field1.getText();
				String username= field2.getText();
				String password= passwordfield.getText();
				Administrator admin= new Administrator (username,password,name);
				this.system.addAdmin(admin);
				JOptionPane.showMessageDialog(null, "Successfully signed up!", "Success", JOptionPane.PLAIN_MESSAGE);
			}

			
			
		});

		
		
		
		
		
	}
	
}
