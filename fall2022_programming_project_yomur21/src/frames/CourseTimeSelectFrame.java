package frames;

import javax.swing.JFrame;

import tutors.Tutor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import course.RegularCourse;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CourseTimeSelectFrame extends JFrame {
private Tutor tutor;
private RegularCourse course;
public CourseTimeSelectFrame(Tutor t, RegularCourse c) {
	this.tutor= t;
	this.course=c;
	getContentPane().setBackground(new Color(128, 128, 255));
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Please pick a time for your course. ");
	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	lblNewLabel.setBounds(108, 30, 225, 13);
	getContentPane().add(lblNewLabel);
	
	/**
	 * I created a combo box containing all the possible time slots a tutor can teach.
	 */
	JComboBox comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00", "18:00-19:00", "19:00-20:00", "20:00-21:00"}));
	comboBox.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	comboBox.setBounds(122, 73, 174, 21);
	getContentPane().add(comboBox);
	
	JButton btnNewButton = new JButton("Select Time");
	btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
	btnNewButton.setBounds(144, 104, 128, 21);
	getContentPane().add(btnNewButton);
	btnNewButton.addActionListener(e-> {
		/**
		 * If nothing is selected, throws an error message.
		 * 
		 * If the time is already in the schedule of the tutor, throws an
		 * error message and terminates.
		 * 
		 * If everything is alright, the next frame will ask the tutor to determine
		 * a fee for the course. CourseFeeSelectFrame will be opened.
		 */
		if (comboBox.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "Please Select a Time!");
			return;
		}
		String time= comboBox.getSelectedItem().toString();
		if (tutor.getCourseSchedule().containsKey(time)) {
			JOptionPane.showMessageDialog(null, "You cannot choose this time! You are teaching at this hour.");
			return;
		}
		
		else {
			CourseFeeSelectFrame frame1= new CourseFeeSelectFrame(tutor,c,time);
			frame1.setSize(400,200);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.dispose();
			
		}
		
		
		
	});
	
}
}
