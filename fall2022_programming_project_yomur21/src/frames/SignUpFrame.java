package frames;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import system.TutoringSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JToolBar;

public class SignUpFrame extends JFrame {
	
	private JPanel panel;
	private JLabel label;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JButton button;
	private TutoringSystem system;

	public SignUpFrame(TutoringSystem s) {
		super("Sign-up");
		setFont(new Font("Script MT Bold", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(128, 255, 255));
		this.system= s;
		/**
		 * I created a JPanel. (I do not use panels later on, I use the getContentPane() method,
		 * which is automatically written by the window builder.
		 */
		panel= new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setLayout(null);
		getContentPane().add(panel);
		label= new JLabel("Sign-up as: ");
		label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		label.setBounds(194,49,116,25);
		panel.add(label);

		/**
		 * The second argument of the JRadioButton means that it is selected
		 * by default.
		 * 
		 * I created radio buttons to let users sign-up as a tutor, a student
		 * or an admin.
		 */
		radioButton1= new JRadioButton("A tutor", true);
		radioButton1.setBackground(new Color(132, 251, 209));
		radioButton1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		radioButton2= new JRadioButton("A student");
		radioButton2.setBackground(new Color(132, 251, 209));
		radioButton2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		radioButton3= new JRadioButton("An administrator");
		radioButton3.setBackground(new Color(132, 251, 209));
		radioButton3.setForeground(new Color(0, 0, 0));
		radioButton3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		radioButton1.setBounds(149,87,183,25);
		radioButton2.setBounds(149,129,183,25);
		radioButton3.setBounds(149, 172, 184,25);
		button= new JButton("Sign-Up");
		button.setBackground(new Color(128, 255, 255));
		button.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 15));
		button.setBounds(149,212,183,25);
		button.addActionListener(e -> {
			/**
			 * If the tutor is picked, the TutorSignUpFrame is opened.
			 */
			if (radioButton1.isSelected()) {
				TutorSignUpFrame frame1= new TutorSignUpFrame(system);
				frame1.setSize(550,400);
				frame1.setVisible(true);
				frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			/**
			 * If the student is selected, the StudentSignUpFrame is opened.
			 */
			if (radioButton2.isSelected()) {
				StudentSignUpFrame frame2= new StudentSignUpFrame(system);
				frame2.setSize(450,500);
				frame2.setVisible(true);
				frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			/**
			 * If the admin is selected, the AdminSignUpFrame is opened.
			 */
			if (radioButton3.isSelected()) {
				AdminSignUpFrame frame3= new AdminSignUpFrame(system);
				frame3.setSize(350,250);
				frame3.setVisible(true);
				frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.dispose();
			}
			
			
			
		});
		/**
		 * I use a button group to make sure that only one option is selected.
		 */
		panel.add(button);
		ButtonGroup bg= new ButtonGroup();
		//to group them all in the same set
		bg.add(radioButton1);
		bg.add(radioButton2);
		bg.add(radioButton3);
		
		panel.add(radioButton1);
		panel.add(radioButton2); 
		panel.add(radioButton3);
		
		
	}
}
