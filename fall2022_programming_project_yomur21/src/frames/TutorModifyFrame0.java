package frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import system.TutoringSystem;
import tutors.Tutor;

public class TutorModifyFrame0 extends JFrame {
private Tutor tutor;
private TutoringSystem tsystem;

	public TutorModifyFrame0(Tutor t, TutoringSystem ts) {
		this.tutor=t;
		this.tsystem=ts;
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(null);
		/**
		 * 
		 * I created a JLabel and some JCheckBoxes. I used a YouTube video to learn
		 * more about JCheckBoxes, which I added to my references.
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
		
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Current Balance: ");
		chckbxNewCheckBox_2.setBackground(new Color(160, 248, 231));
		chckbxNewCheckBox_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		chckbxNewCheckBox_2.setBounds(154, 91, 154, 21);
		getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Username");
		chckbxNewCheckBox_3.setBackground(new Color(160, 248, 231));
		chckbxNewCheckBox_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		chckbxNewCheckBox_3.setBounds(154, 114, 154, 21);
		getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Password");
		chckbxNewCheckBox_4.setBackground(new Color(160, 248, 231));
		chckbxNewCheckBox_4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		chckbxNewCheckBox_4.setBounds(154, 137, 154, 21);
		getContentPane().add(chckbxNewCheckBox_4);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.setBackground(new Color(249, 198, 237));
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(154, 164, 154, 21);
		btnNewButton.addActionListener(e-> {
			if (chckbxNewCheckBox.isSelected()) {
				/**
				 * If the user wants to modify their name,
				 * the NameModifyFrame is opened.
				 */
				NameModifyFrame frame1= new NameModifyFrame(tutor);
				frame1.setSize(500,183);
				frame1.setVisible(true);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			
			else if (chckbxNewCheckBox_2.isSelected()) {
				/**
				 * If the user wants to modify their balance, the
				 * BalanceModifyFrame is opened.
				 */
				BalanceModifyFrame frame3= new BalanceModifyFrame(tutor);
				frame3.setSize(420,190);
				frame3.setVisible(true);
				frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			
			else if (chckbxNewCheckBox_3.isSelected()) {
				/**
				 * If the user wants to modify their username, the UsernameModifyFrame
				 * is opened.
				 */
				UsernameModifyFrame frame4= new UsernameModifyFrame(tutor,tsystem);
				frame4.setSize(420,190);
				frame4.setVisible(true);
				frame4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			else if (chckbxNewCheckBox_4.isSelected()) {
				/**
				 * If the user wants to modify their password, the PasswordModifyFrame
				 * is opened.
				 */
				PasswordModifyFrame frame5= new PasswordModifyFrame(tutor);
				frame5.setSize(420,190);
				frame5.setVisible(true);
				frame5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.dispose();
			}
		}
		
				);
		getContentPane().add(btnNewButton);
		
		
		/**
		 * I added all check boxes into a ButtonGroup so that they do not get picked 
		 * at the same time.
		 */
		ButtonGroup bg= new ButtonGroup();
		bg.add(chckbxNewCheckBox);
		bg.add(chckbxNewCheckBox_2);
		bg.add(chckbxNewCheckBox_3);
		bg.add(chckbxNewCheckBox_4);
	}
}
