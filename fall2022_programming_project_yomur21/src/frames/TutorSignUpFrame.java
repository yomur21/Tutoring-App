package frames;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import system.TutoringSystem;
import tutors.ALevelTutor;
import tutors.BLevelTutor;
import user.User;

import java.awt.Color;
import java.awt.Font;

public class TutorSignUpFrame extends JFrame {

	
	private TutoringSystem system;
	private JPanel panel;
	private JButton btn1;
	private JRadioButton rbtn1;
	private JRadioButton rbtn2;
	private JLabel infoLabel;
	private JLabel lbl1;
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
	
	public TutorSignUpFrame(TutoringSystem s) {
		super("Tutor Sign-Up");
		/**
		 * The TutorSignUpFrame is almost the same code as the StudentSignUpFrame.
		 */
		this.system= s;
		/**
		 * I created the components and added them to the panel.
		 */
		panel= new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setLayout(null);
		getContentPane().add(panel);
		infoLabel= new JLabel("Please enter your information.");
		infoLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		infoLabel.setBounds(150,10,200,25);
		panel.add(infoLabel);
		lbl1= new JLabel("Real Name:");
		lbl1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl1.setBounds(10,41,80,25);
		lbl2= new JLabel("ID Number:");
		lbl2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl2.setBounds(10,81,80,25);
		lbl3= new JLabel("Photo: ");
		lbl3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl3.setBounds(10,121,80,25);
		lbl4= new JLabel("Balance: ");
		lbl4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl4.setBounds(10,161,80,25);
		lbl5= new JLabel("Username: ");
		lbl5.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl5.setBounds(10,201,80,25);
		lbl6= new JLabel("Password: ");
		lbl6.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl6.setBounds(10,241,80,25);
		lbl7= new JLabel("Please choose your tutoring status:");
		lbl7.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		lbl7.setBounds(288,41,233,25);
		text1= new JTextField();
		text1.setBounds(100,41,165,25);
		text2= new JTextField();
		text2.setBounds(100,81,165,25);
		text3= new JTextField();
		text3.setBounds(100,121,165,25);
		text4= new JTextField();
		text4.setBounds(100,161,165,25);
		text5= new JTextField();
		text5.setBounds(100,201,165,25);
		text6= new JTextField();
		text6.setBounds(100,241,165,25);
		rbtn1= new JRadioButton("A Level", true);
		rbtn1.setBackground(new Color(132, 251, 209));
		rbtn1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		rbtn2= new JRadioButton("B Level");
		rbtn2.setBackground(new Color(132, 251, 209));
		rbtn2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		rbtn1.setBounds(292,81,101, 25);
		rbtn2.setBounds(395,81,101,25);
		/**
		 * I will ask the tutor to choose if they are an A Level or a B Level, and thus
		 * I decided to use JRadioButtons. I use a button group to make sure that
		 * only one is picked.
		 */
		ButtonGroup bg= new ButtonGroup();
		bg.add(rbtn1);
		bg.add(rbtn2);
		btn1= new JButton("Enter");
		btn1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		btn1.setBounds(353,121,80,25);
		panel.add(btn1);
		btn1.addActionListener(e -> {
			/**
			 * I used regex to ensure that the input text is in the format that I want.
			 * Must contain letters for names, and also I assumed that it is in a 
			 * Name + Surname format and that everyone has just one name and surname.
			 * 
			 * Must put numbers for ID and balance.
			 * 
			 * Must not be blank for username and password.
			 */
			if (text1.getText().matches("[a-zA-Z]+" + " " + "[a-zA-Z]+")== false) {
				JOptionPane.showMessageDialog(null,"Please enter your name and surname with a space between them!");
				return;
			}
			else if(text2.getText().matches("\\d+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid ID!");
				return;
			}
			else if(text4.getText().matches("\\d+")== false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid balance!");
				return;
			}
			
			else if (text5.getText().matches("\\w+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid username! Your username cannot contain any whitespaces.");
				return;
			}
			
			else if (text6.getText().matches("\\w+")==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid password! Your password cannot contain any whitespaces.");
				return;
			}
			
			/**
			 * It finally checks if the input username exists in the system.
			 * If so, throws an error message.
			 */
			for (User user: system.getAllUsersList()) {
				if (text5.getText()==user.getUsername()) {
					JOptionPane.showMessageDialog(null, "Please enter a valid username! This username already exists!");
					return;
				}
			}
			
		
			String name= text1.getText();
			String id= text2.getText();
			String imageCode= text3.getText();
			int balance= Integer.parseInt(text4.getText());
			String username= text5.getText();
			String password= text6.getText();
			
			if (rbtn1.isSelected()) {
				/**
				 * If "A" was selected, creates an ALevelTutor object and adds it
				 * to the system.
				 */
				ALevelTutor tutor= new ALevelTutor(name,id,imageCode,balance,username,password);
				system.addTutor(tutor);
				JOptionPane.showMessageDialog(null, "Successfully signed up!", "Success", JOptionPane.PLAIN_MESSAGE);
			}
			
			if (rbtn2.isSelected()) {
				/**
				 * If "B" was selected, creates a BLevelTutor object and adds it to the
				 * system.
				 */
				BLevelTutor tutor= new BLevelTutor(name,id,imageCode,balance,username,password);
				system.addTutor(tutor);
				JOptionPane.showMessageDialog(null, "Successfully signed up!", "Success", JOptionPane.PLAIN_MESSAGE);
			}
			
			
			
			
			
			
		});
		
		
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);
		panel.add(lbl4);
		panel.add(lbl5);
		panel.add(lbl6);
		panel.add(lbl7);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		panel.add(text4);
		panel.add(text5);
		panel.add(text6);
		panel.add(rbtn1);
		panel.add(rbtn2);
		
	}
}
