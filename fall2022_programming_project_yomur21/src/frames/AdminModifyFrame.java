package frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import system.TutoringSystem;
import user.Administrator;

public class AdminModifyFrame extends JFrame{
private Administrator admin;
private TutoringSystem tsystem;

public AdminModifyFrame(Administrator a, TutoringSystem ts) {
	this.admin=a;
	this.tsystem=ts;
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Which information would you like to modify?");
	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel.setBounds(98, 23, 280, 15);
	getContentPane().add(lblNewLabel);
	
	/**
	 * I created some JCheckBoxes, which I gained insight from a YouTube video
	 * which I added on my references.
	 */
	JCheckBox chckbxNewCheckBox = new JCheckBox("Name and Surname");
	chckbxNewCheckBox.setBackground(new Color(160, 248, 231));
	chckbxNewCheckBox.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	chckbxNewCheckBox.setBounds(154, 68, 154, 21);
	getContentPane().add(chckbxNewCheckBox);
	
	
	JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Username");
	chckbxNewCheckBox_3.setBackground(new Color(160, 248, 231));
	chckbxNewCheckBox_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	chckbxNewCheckBox_3.setBounds(154, 91, 154, 21);
	getContentPane().add(chckbxNewCheckBox_3);
	
	JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Password");
	chckbxNewCheckBox_4.setBackground(new Color(160, 248, 231));
	chckbxNewCheckBox_4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	chckbxNewCheckBox_4.setBounds(154, 114, 154, 21);
	getContentPane().add(chckbxNewCheckBox_4);
	
	JButton btnNewButton = new JButton("Modify");
	btnNewButton.setBackground(new Color(249, 198, 237));
	btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton.setBounds(154, 141, 154, 21);
	btnNewButton.addActionListener(e-> {
		/**
		 * If the admin wants to modify their name, the NameModifyFrame is opened.
		 */
		if (chckbxNewCheckBox.isSelected()) {
			NameModifyFrame frame1= new NameModifyFrame(admin);
			frame1.setSize(500,183);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
		}
		
		
		/**
		 * If the admin wants to modify their username, the UsernameModifyFrame
		 * is opened.
		 */
		
		else if (chckbxNewCheckBox_3.isSelected()) {
			UsernameModifyFrame frame4= new UsernameModifyFrame(admin,tsystem);
			frame4.setSize(420,190);
			frame4.setVisible(true);
			frame4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
		}
		/**
		 * If the admin wants to modify their password, the PasswordModifyFrame is opened.
		 */
		else if (chckbxNewCheckBox_4.isSelected()) {
			PasswordModifyFrame frame5= new PasswordModifyFrame(admin);
			frame5.setSize(420,190);
			frame5.setVisible(true);
			frame5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
		}
	}
	
			);
	getContentPane().add(btnNewButton);
	
	/**
	 * I added every checkbox into a ButtonGroup so that they are picked once at a time.
	 */
	ButtonGroup bg= new ButtonGroup();
	bg.add(chckbxNewCheckBox);
	bg.add(chckbxNewCheckBox_3);
	bg.add(chckbxNewCheckBox_4);
}
}

