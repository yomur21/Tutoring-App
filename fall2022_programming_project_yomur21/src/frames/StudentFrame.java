package frames;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import student.Student;
import system.TutoringSystem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentFrame extends JFrame {

	private Student student;
	private TutoringSystem tsystem;
	
	public StudentFrame(Student s, TutoringSystem ts) {
		super("Student Interface");
		this.student=s;
		this.tsystem=ts;
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Welcome " + student.getUsername() + "!");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(267, 10, 224, 13);
		getContentPane().add(lblNewLabel_1);
		
		
		/**
		 * I used the internet to find how to attach images into GUI projects. I
		 * have cited it on my references.
		 */
		Icon studentPhoto= new ImageIcon(getClass().getResource(student.getImageCode())); 
		JLabel lblNewLabel_2 = new JLabel(studentPhoto);
		lblNewLabel_2.setBounds(419, 35, 153, 184);
		getContentPane().add(lblNewLabel_2);
		
		/**
		 * Labels containing general information about the student.
		 */
		JLabel lblNewLabel_3 = new JLabel("Name and Surname: " +  student.getName());
		lblNewLabel_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(398, 224, 310, 24);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TCKN: " + student.getId());
		lblNewLabel_4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(398, 258, 218, 24);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Age: " + student.getAge());
		lblNewLabel_5.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(398, 292, 218, 24);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Account Balance: " + student.getBalance() + " TL");
		lblNewLabel_6.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(398, 326, 218, 24);
		getContentPane().add(lblNewLabel_6);
		
		/**
		 * Opens the BuyEquipmentFrame if clicked.
		 */
		JButton btnNewButton = new JButton("Buy Equipment");
		btnNewButton.addActionListener(e-> {
			BuyEquipmentFrame frame2= new BuyEquipmentFrame(student, tsystem);
			frame2.setSize(450,168);
			frame2.setVisible(true);
			frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		});
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(28, 246, 149, 25);
		getContentPane().add(btnNewButton);
		
		
		/**
		 * Opens the RegisterCourseFrame if clicked.
		 */
		JButton btnNewButton_1 = new JButton("Reserve a Course");
		btnNewButton_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_1.setBounds(28, 286, 149, 25);
		btnNewButton_1.addActionListener(e-> {
			RegisterCourseFrame frame6= new RegisterCourseFrame(student,tsystem);
			frame6.setSize(700,700);
			frame6.setVisible(true);
			frame6.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		});
		getContentPane().add(btnNewButton_1);
		
		
		/**
		 * Calls the ShowTakeableCourses method of the system, and shows
		 * the courses a student can take. I used a JOptionPane for this.
		 */
		
		JButton btnNewButton_2 = new JButton("What Courses Can I Take?");
		btnNewButton_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_2.setBounds(28, 366, 232, 25);
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(e-> {
			JOptionPane.showMessageDialog(null, "Currently, the courses you can take are: " + tsystem.ShowTakeableCourse(student));
			
		});
		
		/**
		 * Opens the TutorInfoFrame.
		 */
		JButton btnNewButton_3 = new JButton("Tutor Information");
		btnNewButton_3.addActionListener(e -> {
			TutorInfoFrame frame5= new TutorInfoFrame(tsystem);
			frame5.setSize(1000, 700);
			frame5.setVisible(true);
			frame5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		});
		btnNewButton_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_3.setBounds(28, 326, 153, 25);
		getContentPane().add(btnNewButton_3);
		
		/**
		 * Opens the StudentModifyFrame0.
		 */
		JButton btnNewButton_4 = new JButton("Change My Information");
		btnNewButton_4.addActionListener(e-> {
				StudentModifyFrame0 frame1= new StudentModifyFrame0(student,tsystem);
				frame1.setSize(475,300);
				frame1.setVisible(true);
				this.dispose();
			
		});
		btnNewButton_4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_4.setBounds(387, 366, 200, 25);
		getContentPane().add(btnNewButton_4);
		
		/**
		 * I again attached a picture to the interface.
		 */
		Icon StudyPhoto= new ImageIcon(getClass().getResource("/hm.jpg"));
		JLabel lblNewLabel_7 = new JLabel(StudyPhoto);
		lblNewLabel_7.setBounds(30, 35, 310, 184);
		getContentPane().add(lblNewLabel_7);
		
		/**
		 * Opens the PreviousCoursesFrame.
		 */
		JButton btnNewButton_5 = new JButton("My Previous Courses");
		btnNewButton_5.addActionListener(e-> {
			PreviousCoursesFrame frame3= new PreviousCoursesFrame(student);
			frame3.setSize(500,500);
			frame3.setVisible(true);
			frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		});
		
		btnNewButton_5.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_5.setBounds(209, 246, 160, 25);
		getContentPane().add(btnNewButton_5);
		
		/**
		 * Opens the CurrentCoursesFrame.
		 */
		JButton btnNewButton_6 = new JButton("My Current Courses");
		btnNewButton_6.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_6.setBounds(209, 286, 160, 25);
		btnNewButton_6.addActionListener(e-> {
			CurrentCoursesFrame frame4= new CurrentCoursesFrame(student);
			frame4.setSize(500,500);
			frame4.setVisible(true);
			frame4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		});
		getContentPane().add(btnNewButton_6);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
}
