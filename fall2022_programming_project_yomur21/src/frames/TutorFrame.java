package frames;

import javax.swing.JFrame;

import system.TutoringSystem;
import tutors.ALevelTutor;
import tutors.Tutor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TutorFrame extends JFrame {

	private Tutor tutor;
	private TutoringSystem tsystem;
	
	public TutorFrame(Tutor t, TutoringSystem ts) {
		super("Tutor Interface");
		getContentPane().setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		this.tutor=t;
		this.tsystem= ts;
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(null);
		
		/**
		 * I created an ImageIcon to display the image of the tutor. I used the Internet
		 * to find how to display images, which I linked on my references.
		 */
		Icon tutorPhoto= new ImageIcon(getClass().getResource(tutor.getImageCode()));
		JLabel lblNewLabel = new JLabel(tutorPhoto);
		lblNewLabel.setBounds(488, 53, 145, 167);
		getContentPane().add(lblNewLabel);
		/**
		 * I created some JLabels containing information about the tutor.
		 */
		JLabel lblNewLabel_1 = new JLabel("Name: " + tutor.getName());
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(488, 248, 169, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome " + tutor.getUsername()+ "!");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(298, 30, 132, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tutor ID: " + tutor.getTutorId());
		lblNewLabel_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(488, 281, 195, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Balance: " + (int)tutor.getBalance() + " TL");
		lblNewLabel_4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(488, 314, 145, 13);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Modify Information");
		btnNewButton.setBackground(new Color(255, 128, 255));
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(476, 390, 169, 21);
		getContentPane().add(btnNewButton);
		/**
		 * Opens the TutorModifyFrame0.
		 */
		btnNewButton.addActionListener(e-> {
			TutorModifyFrame0 frame2= new TutorModifyFrame0(tutor,tsystem);
			frame2.setSize(450,260);
			frame2.setVisible(true);
			frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
			
		});
		
		/**
		 * I added an extra picture to the interface, using the same method.
		 */
		Icon studyPhoto= new ImageIcon(getClass().getResource("/hm.jpg"));
		JLabel lblNewLabel_5 = new JLabel(studyPhoto);
		lblNewLabel_5.setBounds(26, 64, 317, 167);
		getContentPane().add(lblNewLabel_5);
	
		
		/**
		 * Opens the TutorCourseSelectFrame.
		 */
		JButton btnNewButton_1 = new JButton("Teach a Course");
		btnNewButton_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_1.setBounds(38, 263, 154, 21);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(e-> {
			TutorCourseSelectFrame frame3= new TutorCourseSelectFrame(tutor, tsystem);
			frame3.setSize(800,450);
			frame3.setVisible(true);
			frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		});
		
		/**
		 * Opens the UpdateStudentStatusFrame.
		 */
		JButton btnNewButton_2 = new JButton("Student Info/Update Student Status");
		btnNewButton_2.addActionListener(e-> {
			UpdateStudentStatusFrame frame4= new UpdateStudentStatusFrame(tutor);
			frame4.setVisible(true);
			frame4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame4.setSize(600,550);
			
		});
		btnNewButton_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_2.setBounds(38, 309, 266, 21);
		getContentPane().add(btnNewButton_2);
		
		
		/**
		 * Opens the TutorScheduleFrame.
		 */
		JButton btnNewButton_3 = new JButton("My Schedule");
		btnNewButton_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_3.setBounds(38, 353, 154, 21);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(e-> {
			TutorScheduleFrame frame1= new TutorScheduleFrame(tutor);
			frame1.setSize(700,500);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		});
		
		/**
		 * Finally, I added a JLabel to display whether the tutor is an A level or a B level.
		 */
		JLabel lblNewLabel_6 = new JLabel("Tutor Level: " + ((tutor instanceof ALevelTutor) ? "A" : "B"));
		lblNewLabel_6.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(488, 347, 100, 13);
		getContentPane().add(lblNewLabel_6);
	}
}
