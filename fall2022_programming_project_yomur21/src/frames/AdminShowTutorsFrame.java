package frames;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import system.TutoringSystem;
import tutors.Tutor;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminShowTutorsFrame extends JFrame{

	private TutoringSystem tsystem;
	
	public AdminShowTutorsFrame(TutoringSystem ts) {
		this.tsystem= ts;
		
		/**
		 * Iteratively adds each tutor's information as a radio button. I used a flow
		 * layout to do this.
		 */
		ButtonGroup bg= new ButtonGroup();
		for (Tutor t: tsystem.getAllTutorsList()) {
			JRadioButton rb= new JRadioButton(t.toString());
			/**
			 * I added an action command to access the tutor later.
			 */
			rb.setActionCommand(t.getName());
			rb.setBackground(new Color(251, 198, 249));
			bg.add(rb);
			getContentPane().add(rb);
		}
		
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JButton btnNewButton = new JButton("Tutor's Schedule");
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(e-> {
			/**
			 * If no tutor is selected, throws an error message.
			 */
			if (bg.getSelection()==null) {
				JOptionPane.showMessageDialog(null, "Please select a tutor!");
			}
			
			/**
			 * Finds the tutor that corresponds to the button on the background,
			 * and opens the TutorScheduleFrame, if the Tutor Schedule button is clicked.
			 */
			for (Tutor t: tsystem.getAllTutorsList()) {
				if(bg.getSelection().getActionCommand().equals(t.getName())) {
					TutorScheduleFrame frame1= new TutorScheduleFrame(t);
					frame1.setSize(700,500);
					frame1.setVisible(true);
					frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
			
			
			
		});
		
		JButton btnNewButton_1 = new JButton("Tutor's Available Slots");
		btnNewButton_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(e-> {
			/**
			 * If no tutor is selected, throws an error message.
			 */
			if (bg.getSelection()==null) {
				JOptionPane.showMessageDialog(null, "Please select a tutor!");
			}
			
			/**
			 * Accesses the selected tutor on the background, 
			 * and opens a AdminTutorAvailableSlotsScheduleFrame. 
			 */
			for (Tutor t: tsystem.getAllTutorsList()) {
				if(bg.getSelection().getActionCommand().equals(t.getName())) {
					AdminTutorAvailableSlotsScheduleFrame frame2= new AdminTutorAvailableSlotsScheduleFrame(t);
					frame2.setSize(500,500);
					frame2.setVisible(true);
					frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
			
			
			
		});
		
		
		JButton btnNewButton_2 = new JButton("Tutor's Students");
		btnNewButton_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(e-> {
			if (bg.getSelection()==null) {
				JOptionPane.showMessageDialog(null, "Please select a tutor!");
			}
			
			/**
			 * Opens a TutorStudentsFrame.
			 */
			for (Tutor t: tsystem.getAllTutorsList()) {
				if(bg.getSelection().getActionCommand().equals(t.getName())) {
					TutorStudentsFrame frame3= new TutorStudentsFrame(t);
					frame3.setSize(1000,1000);
					frame3.setVisible(true);
					frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
			
			
			
		});
		
		
	}
}
