package frames;

import javax.swing.JFrame;

import course.Equipment;
import course.RegularCourse;
import system.TutoringSystem;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AdminChooseEquipmentFrame extends JFrame{

	private RegularCourse course;
	private TutoringSystem tsystem;
	private JTextField textField;
	
	public AdminChooseEquipmentFrame(RegularCourse c, TutoringSystem ts) {
		/**
		 * All equipments for the course are reset here. I wanted to use one frame
		 * instead of different frames for modifying and setting the equipment list
		 * of a course. In both cases, the values are reset here, and the user can
		 * pick whatever they want.
		 */
		c.resetEquipmentsList();
		getContentPane().setBackground(new Color(128, 128, 255));
		this.course= c;
		this.tsystem= ts;
		getContentPane().setLayout(null);
		

		
		/**
		 * I created some JLabels and some JTextFields.
		 */
		JLabel lblNewLabel = new JLabel("<html> Enter the name of an an equipment: (Note that the <br/> equipments list of the course has been reset, so add all the equipments needed)</html>");
		lblNewLabel.setBounds(10,10,544,28);
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Equipment Name: ");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(64, 74, 137, 13);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(211, 72, 164, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Equipment");
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 116, 164, 21);
		getContentPane().add(btnNewButton);
		
		/**
		 * If the equipment exists, it adds the equipment to the list
		 * of the course's equipments. If not, it shows an error message.
		 */
		btnNewButton.addActionListener(e-> {
			for (Equipment eq: tsystem.getAllEquipmentsList()) {
				if (textField.getText().equals(eq.getName())) {
					course.addEquipment(eq);
					JOptionPane.showMessageDialog(null, "Equipment added to course! If you want to add more, please continue or click 'Choose Prerequisites' to continue.");
					return;
				}
			}
			
			JOptionPane.showMessageDialog(null, "Equipment not found! Please enter a valid equipment.");
			return;
		});
		
		
		
		/**
		 * Opens the AdminChoosePrerequisiteFrame.
		 */
		JButton btnNewButton_1 = new JButton("Choose prerequisites");
		btnNewButton_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_1.setBounds(184, 116, 164, 21);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(e-> {
			AdminChoosePrerequisiteFrame frame= new AdminChoosePrerequisiteFrame(course, tsystem);
			frame.setSize(550, 250);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		});
		
		/**
		 * If the user clicks cancel, the frame will close.
		 */
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(e-> {
			this.dispose();
		});
		btnNewButton_2.setBounds(358, 116, 164, 21);
		getContentPane().add(btnNewButton_2);
	
		
		
	}
}
