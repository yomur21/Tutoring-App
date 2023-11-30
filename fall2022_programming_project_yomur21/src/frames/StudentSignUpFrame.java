package frames;

import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import student.Student;
import system.TutoringSystem;
import tutors.ALevelTutor;
import tutors.BLevelTutor;
import user.User;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class StudentSignUpFrame extends JFrame {

	
	private TutoringSystem system;

	private JPanel panel;
	private JButton btn1;
	private JLabel infoLabel;
	private	JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
	private JTextField text6;
	private JComboBox comboBox;

	private JLabel lbl8;

	private JTextField text7;
	
	
	public StudentSignUpFrame(TutoringSystem s) {
		super("Student Sign-Up");
		this.system=s;
		/**
		 * I created a panel.
		 */
		panel= new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setLayout(null);
		getContentPane().add(panel);
		/**
		 * I created a label.
		 */
		infoLabel= new JLabel("Please enter your information.");
		infoLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		infoLabel.setBounds(129,20,200,25);
		panel.add(infoLabel);
		/**
		 * I created labels and textfields corresponding to these labels and set their
		 * positions. To set positions, I have used the window builder.
		 */
		lbl1= new JLabel("Real Name:");
		lbl1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl1.setBounds(49,55,80,25);
		lbl2= new JLabel("TCKN: ");
		lbl2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl2.setBounds(49,95,80,25);
		lbl3= new JLabel("Age: ");
		lbl3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl3.setBounds(49,135,80,25);
		lbl4= new JLabel("Photo: ");
		lbl4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl4.setBounds(49,175,80,25);
		lbl5= new JLabel("Balance: ");
		lbl5.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl5.setBounds(49,215,80,25);
		lbl6= new JLabel("Username: ");
		lbl6.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl6.setBounds(49,255,80,25);
		lbl7= new JLabel("Password: ");
		lbl7.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl7.setBounds(49,295,80,25);
		lbl8= new JLabel("Gender: ");
		lbl8.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl8.setBounds(49,335,80,25);
		text1= new JTextField();
		text1.setBounds(142,55,165,25);
		text2= new JTextField();
		text2.setBounds(142,95,165,25);
		text3= new JTextField();
		text3.setBounds(142,135,165,25);
		text4= new JTextField();
		text4.setBounds(142,175,165,25);
		text5= new JTextField();
		text5.setBounds(142,215,165,25);
		text6= new JTextField();
		text6.setBounds(142,255,165,25);
		text7= new JTextField();
		text7.setBounds(142,295,165,25);
		btn1= new JButton("Enter");
		btn1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btn1.setBounds(178,375,80,25);
		panel.add(btn1);
		/**
		 * I added a combo box which makes the student select their gender.
		 */
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(142, 335, 165, 25);
		panel.add(comboBox);
		/**
		 * I used regex to ensure that the input text is in the format that I want.
		 * Must contain letters for names, and also I assumed that it is in a 
		 * Name + Surname format and that everyone has just one name and surname.
		 * 
		 * Must put numbers for ID, age and balance.
		 * 
		 * Must not be blank for username and password.
		 */
		btn1.addActionListener(e -> {
			if (text1.getText().matches("[a-zA-Z]+" + " " + "[a-zA-Z]+")== false) {
				JOptionPane.showMessageDialog(null,"Please enter your name and surname with a space between them!");
				return;
			}
			else if(text2.getText().matches("\\d+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid ID!");
				return;
			}
			else if (text3.getText().matches("\\d+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid age!");
				return;
			}
			else if(text5.getText().matches("\\d+")== false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid balance!");
				return;
			}
			
			else if (text6.getText().matches("\\w+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid username! Your username cannot contain any whitespaces.");
				return;
			}
			
			else if (text7.getText().matches("\\w+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid password! Your password cannot contain any whitespaces.");
				return;
			}
			
			
			/**
			 * It finally checks if the input username exists in the system.
			 * If so, throws an error message.
			 */
			for (User user: system.getAllUsersList()) {
				if (text6.getText().equals(user.getUsername())) {
					JOptionPane.showMessageDialog(null, "Please enter a valid username! This username already exists!");
					return;
				}
			}
			
			
			/**
			 * Creates and adds a student object to the system. 
			 */
			String name= text1.getText();
			String id= text2.getText();
			int age= Integer.parseInt(text3.getText());
			String imageCode= text4.getText();
			int balance= Integer.parseInt(text5.getText());
			String username= text6.getText();
			String password= text7.getText();
			String gender= (String) comboBox.getSelectedItem();
			Student student= new Student(name,id,age,imageCode,balance,gender,username,password);
			this.system.addStudent(student);
			JOptionPane.showMessageDialog(null, "Successfully signed up!", "Success", JOptionPane.PLAIN_MESSAGE);
			
			
			
			
			
		});
		
		
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);
		panel.add(lbl4);
		panel.add(lbl5);
		panel.add(lbl6);
		panel.add(lbl7);
		panel.add(lbl8);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		panel.add(text4);
		panel.add(text5);
		panel.add(text6);
		panel.add(text7);
		
		
		
		
		
		
	}
}
