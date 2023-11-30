package frames;

import javax.swing.JFrame;

import system.TutoringSystem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

public class AdminTutoringFeesFrame extends JFrame {

	private TutoringSystem tsystem;
	
	public AdminTutoringFeesFrame(TutoringSystem ts) {
		this.tsystem= ts;
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(null);
		
		/**
		 * It first calls the system's calculateTutoringFees method and calculates
		 * the total tutoring fee, and displays it. 
		 */
		JLabel lblNewLabel = new JLabel("The total of current tutoring fees is: " + tsystem.calculateTutoringFees() + " TL.");
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel.setBounds(54, 24, 338, 13);
		getContentPane().add(lblNewLabel);
		
		/**
		 * The user is then asked to charge these fees.
		 */
		JLabel lblNewLabel_1 = new JLabel("<html>Would you like to charge this fee <br/>from students and add it to the tutors' balances <br/>according to their contracts?</html>");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(54, 47, 335, 75);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Charge Tutoring Fees");
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(113, 141, 199, 21);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(e-> {
			/**
			 * If the user clicks on the Charge Tutoring Fees JButton, the 
			 * chargeTutoring method will be invoked, and the tutoring fee will be
			 * deducted from the students and added into the tutors based on their
			 * percentage cut. 
			 */
			tsystem.chargeTutoring();
			JOptionPane.showMessageDialog(null, "The tutoring fees have been successfully charged and added to the tutors' bank accounts!");
			
		});
	}
}
