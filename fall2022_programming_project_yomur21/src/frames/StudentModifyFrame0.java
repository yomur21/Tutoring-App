package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

import student.Student;
import system.TutoringSystem;
import user.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class StudentModifyFrame0 extends JFrame{
	private Student student;
	private TutoringSystem tsystem;

	
	public StudentModifyFrame0(Student s, TutoringSystem ts) {
		getContentPane().setBackground(new Color(128, 128, 255));
		this.student=s;
		this.tsystem=ts;
		getContentPane().setLayout(null);
		
		/**
		 * I first created the interface. I have consulted a YouTube video
		 * to understand how JCheckBoxes work, which I have added to my references.
		 */
		JLabel lblNewLabel = new JLabel("Which information would you like to modify?");
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel.setBounds(98, 23, 280, 15);
		getContentPane().add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Name and Surname");
		chckbxNewCheckBox.setBackground(new Color(160, 248, 231));
		chckbxNewCheckBox.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		chckbxNewCheckBox.setBounds(154, 68, 154, 21);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Age: ");
		chckbxNewCheckBox_1.setBackground(new Color(160, 248, 231));
		chckbxNewCheckBox_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		chckbxNewCheckBox_1.setBounds(154, 90, 154, 21);
		getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Current Balance: ");
		chckbxNewCheckBox_2.setBackground(new Color(160, 248, 231));
		chckbxNewCheckBox_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		chckbxNewCheckBox_2.setBounds(154, 113, 154, 21);
		getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Username");
		chckbxNewCheckBox_3.setBackground(new Color(160, 248, 231));
		chckbxNewCheckBox_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		chckbxNewCheckBox_3.setBounds(154, 136, 154, 21);
		getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Password");
		chckbxNewCheckBox_4.setBackground(new Color(160, 248, 231));
		chckbxNewCheckBox_4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		chckbxNewCheckBox_4.setBounds(154, 159, 154, 21);
		getContentPane().add(chckbxNewCheckBox_4);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.setBackground(new Color(249, 198, 237));
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(154, 187, 154, 21);
		btnNewButton.addActionListener(e-> {
				
			if (chckbxNewCheckBox.isSelected()) {
				/**
				 * If the user wants to modify their name, the NameModifyFrame
				 * is opened.
				 */
				NameModifyFrame frame1= new NameModifyFrame(student);
				frame1.setSize(500,183);
				frame1.setVisible(true);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			else if (chckbxNewCheckBox_1.isSelected()) {
				/**
				 * If the user wants to modify their age, the StudentModifyFrame1
				 * is opened (I named it this way since only students have
				 * an age in my implementation.)
				 */
				StudentModifyFrame1 frame2= new StudentModifyFrame1(student);
				frame2.setSize(420,196);
				frame2.setVisible(true);
				frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			/**
			 * If the student wants to change their balance, the BalanceModifyFrame
			 * is opened.
			 */
			else if (chckbxNewCheckBox_2.isSelected()) {
				BalanceModifyFrame frame3= new BalanceModifyFrame(student);
				frame3.setSize(420,190);
				frame3.setVisible(true);
				frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			
			/**
			 * If the student wants to change their username, the UsernameModifyFrame
			 * is opened.
			 */
			else if (chckbxNewCheckBox_3.isSelected()) {
				UsernameModifyFrame frame4= new UsernameModifyFrame(student,tsystem);
				frame4.setSize(420,190);
				frame4.setVisible(true);
				frame4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			/**
			 * If the student wants to change their password, the PasswordModifyFrame
			 * is opened.
			 */
			else if (chckbxNewCheckBox_4.isSelected()) {
				PasswordModifyFrame frame5= new PasswordModifyFrame(student);
				frame5.setSize(420,190);
				frame5.setVisible(true);
				frame5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
		}
		
				);
		getContentPane().add(btnNewButton);
		
		
		/**
		 * In my GUI, the student can only choose one at a time, thus I added each 
		 * JCheckBox into a ButtonGroup.
		 */
		ButtonGroup bg= new ButtonGroup();
		bg.add(chckbxNewCheckBox);
		bg.add(chckbxNewCheckBox_1);
		bg.add(chckbxNewCheckBox_2);
		bg.add(chckbxNewCheckBox_3);
		bg.add(chckbxNewCheckBox_4);
		
	}
}
