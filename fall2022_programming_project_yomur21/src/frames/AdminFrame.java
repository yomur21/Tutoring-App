package frames;

import javax.swing.JFrame;

import system.TutoringSystem;
import user.Administrator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AdminFrame extends JFrame {

	private Administrator admin;
	private TutoringSystem tsystem;
	public AdminFrame(Administrator a, TutoringSystem ts) {
		super("Admin Interface");
		this.admin= a;
		this.tsystem=ts;
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(null);
		
		/**
		 * I added some JLabels regarding the information of the admin.
		 */
		JLabel lblNewLabel = new JLabel("Welcome " + admin.getUsername() + "!");
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel.setBounds(254, 29, 172, 13);
		getContentPane().add(lblNewLabel);
		
		/**
		 * I created an image icon to display an image, I researched how to 
		 * display images on GUIs on the internet, and I linked my sources on my references.
		 */
		Icon adminPhoto= new ImageIcon(getClass().getResource("/admin1.jpg"));
		JLabel lblNewLabel_1 = new JLabel(adminPhoto);
		lblNewLabel_1.setBounds(459, 29, 133, 154);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name: " + admin.getName());
		lblNewLabel_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(438, 211, 154, 13);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Modify Information");
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(416, 340, 186, 21);
		getContentPane().add(btnNewButton);
		
		/**
		 * Opens the AdminModifyFrame.
		 */
		btnNewButton.addActionListener(e-> {
			AdminModifyFrame frame1= new AdminModifyFrame(admin,tsystem);
			frame1.setSize(450,250);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
		});
		
		JButton btnNewButton_1 = new JButton("Add a Course");
		btnNewButton_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_1.setBounds(416, 260, 186, 21);
		btnNewButton_1.addActionListener(e-> {
			/**
			 * Opens the AdminAddCourseFrame.
			 */
			AdminAddCourseFrame frame2= new AdminAddCourseFrame(tsystem);
			frame2.setSize(450,200);
			frame2.setVisible(true);
			frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		});

		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit Course Information");
		btnNewButton_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_2.setBounds(416, 300, 186, 21);
		/**
		 * Opens the AdminEditCourseFrame.
		 */
		btnNewButton_2.addActionListener(e-> {
			AdminEditCourseFrame frame3= new AdminEditCourseFrame(tsystem);
			frame3.setSize(700,700);
			frame3.setVisible(true);
			frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		});
		getContentPane().add(btnNewButton_2);
		
		/**
		 * I used a photo again here.
		 */
		Icon studyPhoto= new ImageIcon(getClass().getResource("/hm.jpg"));
		JLabel lblNewLabel_3 = new JLabel(studyPhoto);
		lblNewLabel_3.setBounds(20, 56, 222, 127);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("Course Student Information");
		btnNewButton_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_3.setBounds(140, 340, 248, 21);
		getContentPane().add(btnNewButton_3);
		
		/**
		 * Opens the AdminInquireCourseStudentFrame.
		 */
		btnNewButton_3.addActionListener(e-> {
			AdminInquireCourseStudentFrame frame1= new AdminInquireCourseStudentFrame(tsystem);
			frame1.setSize(750,700);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
			
		});
		
		JButton btnNewButton_4 = new JButton("Inquire Tutor Information");
		btnNewButton_4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_4.setBounds(140, 301, 248, 21);
		/**
		 * Opens the AdminShowTutorsFrame.
		 */
		btnNewButton_4.addActionListener(e-> {
			AdminShowTutorsFrame frame4= new AdminShowTutorsFrame(tsystem);
			frame4.setSize(1100,700);
			frame4.setVisible(true);
			frame4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
			
			
		});
		getContentPane().add(btnNewButton_4);
		
		/**
		 * Opens the AdminTutoringFeesFrame.
		 */
		JButton btnNewButton_5 = new JButton("Charge Total Tutoring Fees");
		btnNewButton_5.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_5.setBounds(140, 261, 248, 21);
		btnNewButton_5.addActionListener(e-> {
			AdminTutoringFeesFrame frame5= new AdminTutoringFeesFrame(tsystem);
			frame5.setSize(450,230);
			frame5.setVisible(true);
			frame5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
			
			
		});
		getContentPane().add(btnNewButton_5);
		
		/**
		 * Shows a JOptionPane, calling the calculateEquipmentFees method of the system,
		 * and displays the total equipment fees of a course.
		 * Note that these fees are charged when a student buys an equipment,
		 * thus I did not charge equipment fees as an administrator. 
		 */
		JButton btnNewButton_6 = new JButton("Total Equipment Fees");
		btnNewButton_6.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_6.setBounds(269, 99, 169, 21);
		btnNewButton_6.addActionListener(e-> {
			JOptionPane.showMessageDialog(null, "The total equipment fee of all courses is: " + tsystem.calculateEquipmentFees() + 
					" TL. Note that these are automatically charged when your students buy an equipment.");
			
			
			
			
			
		});
		getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("See Total Profit");
		btnNewButton_7.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_7.setBounds(269, 130, 169, 21);
		getContentPane().add(btnNewButton_7);
		/**
		 * Shows a JOptionPane, calling the calculateProfit method of the system, 
		 * and displays the total profit of the system.
		 */
		
		btnNewButton_7.addActionListener(e-> {
			JOptionPane.showMessageDialog(null, "The total profit of the whole tutoring system is " + tsystem.calculateProfit() + " TL.");
			
			
			
		});
		
		JButton btnNewButton_8 = new JButton("See Tutors' Income");
		btnNewButton_8.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_8.setBounds(269, 162, 172, 21);
		getContentPane().add(btnNewButton_8);
		/**
		 * Opens a AdminTutorIncomeFrame. 
		 */
		btnNewButton_8.addActionListener(e-> {
			AdminTutorIncomeFrame frame6= new AdminTutorIncomeFrame(tsystem);
			frame6.setSize(750,700);
			frame6.setVisible(true);
			frame6.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
			
		});
		
		/**
		 * Opens a AdminCourseProfitFrame.
		 */
		JButton btnNewButton_9 = new JButton("See Each Course's Profit");
		btnNewButton_9.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_9.setBounds(140, 221, 248, 21);
		getContentPane().add(btnNewButton_9);
		btnNewButton_9.addActionListener(e-> {
			AdminCourseProfitFrame frame7= new AdminCourseProfitFrame(tsystem);
			frame7.setSize(750,700);
			frame7.setVisible(true);
			frame7.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
			
			
			
		});
		
		
		
		
		
		
		

		
		
		
		
		
		

	}
}
