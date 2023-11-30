package frames;

import javax.swing.JFrame;

import system.TutoringSystem;
import user.Administrator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import course.AdvancedCourse;
import course.BeginnerCourse;
import course.RegularCourse;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class AdminAddCourseFrame extends JFrame{
private TutoringSystem tsystem;
private JTextField textField;

public AdminAddCourseFrame(TutoringSystem ts) {
	getContentPane().setBackground(new Color(128, 128, 255));
	this.tsystem=ts;
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Enter some information about the course.");
	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel.setBounds(91, 21, 282, 13);
	getContentPane().add(lblNewLabel);
	
	/**
	 * I added some JLabels and TextFields.
	 */
	JLabel lblNewLabel_1 = new JLabel("Course Name: ");
	lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel_1.setBounds(47, 65, 116, 13);
	getContentPane().add(lblNewLabel_1);
	
	textField = new JTextField();
	textField.setBounds(151, 65, 211, 19);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("Course Level: ");
	lblNewLabel_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel_2.setBounds(47, 103, 99, 13);
	getContentPane().add(lblNewLabel_2);
	
	/**
	 * I added two radio buttons for the admin to pick if the course is
	 * advanced or not.
	 */
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Advanced");
	rdbtnNewRadioButton.setBackground(new Color(247, 200, 247));
	rdbtnNewRadioButton.setBounds(151, 100, 103, 21);
	getContentPane().add(rdbtnNewRadioButton);
	
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Beginner");
	/**
	 * I set the beginner course as the selected one, when the user does not select
	 * anything.
	 */
	rdbtnNewRadioButton_1.setSelected(true);
	rdbtnNewRadioButton_1.setBackground(new Color(247, 200, 247));
	rdbtnNewRadioButton_1.setBounds(259, 100, 103, 21);
	getContentPane().add(rdbtnNewRadioButton_1);
	
	/**
	 * I added both radio buttons into a button group so that they do not get picked at the
	 * same time.
	 */
	ButtonGroup bg= new ButtonGroup();
	bg.add(rdbtnNewRadioButton_1);
	bg.add(rdbtnNewRadioButton);
	
	JButton btnNewButton = new JButton("Create a course");
	btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton.setBounds(140, 135, 154, 21);
	btnNewButton.addActionListener(e-> {
		
		/**
		 * If the input name already exists, throws an error message. Else, it starts
		 * creating the course.
		 */
		for (RegularCourse course: tsystem.getAllCoursesList()) {
			if (course.getCourseName().equals(textField.getText())) {
				JOptionPane.showMessageDialog(null, "This course already exists! If you want to modify the properties of a course, please change it in the 'Modify Course Information' section.");
				return;
			}
		}
		
		/**
		 * Creates an AdvancedCourse object if "advanced" is selected. Then opens
		 * the AdminChooseEquipmentFrame.
		 */
		if (rdbtnNewRadioButton.isSelected()) {
			RegularCourse c1= new AdvancedCourse(textField.getText());
			ts.addCourse(c1);
			JOptionPane.showMessageDialog(null, "Course successfully added to system! Please continue if you'd like to add an equipment or a prerequisite.");
			this.dispose();
			AdminChooseEquipmentFrame frame1= new AdminChooseEquipmentFrame(c1,tsystem);
			frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame1.setSize(550,200);
			frame1.setVisible(true);
		}
		
		/**
		 * Creates a BeginnerCourse object if "beginner" is selected. Then opens the
		 * AdminChooseEquipmentFrame.
		 */
		if (rdbtnNewRadioButton_1.isSelected()) {
			RegularCourse c2= new BeginnerCourse(textField.getText());
			ts.addCourse(c2);
			JOptionPane.showMessageDialog(null, "Course successfully added to system! Please continue if you'd like to add an equipment or a prerequisite.");
			this.dispose();
			AdminChooseEquipmentFrame frame2= new AdminChooseEquipmentFrame(c2,tsystem);
			frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame2.setSize(550,200);
			frame2.setVisible(true);
		}
		
	});
	getContentPane().add(btnNewButton);
	
	
}
}
