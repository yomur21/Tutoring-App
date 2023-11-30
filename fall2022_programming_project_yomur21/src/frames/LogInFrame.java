package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import system.TutoringSystem;
import user.User;
import java.awt.Color;
import java.awt.Font;

public class LogInFrame extends JFrame {

	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JLabel label;
	private JLabel welcomeText;
	private JTextField UserTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private TutoringSystem system;
	private JButton button3;


	/**
	 * For this part, Alex Lee's YouTube video (on my references) really helped me
	 * understand how to use JTextField and JButton. I used the WindowBuilder to
	 * set the bounds, background and the font.
	 * 
	 */
	public LogInFrame (TutoringSystem system) {
		super("Login");
		this.system=system;
		panel= new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		welcomeText= new JLabel("Welcome to YUSIS! Please enter your username and password.");
		welcomeText.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		welcomeText.setBounds(69,26,1000,25);
		panel.add(welcomeText);
		label= new JLabel("Username: ");
		label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		label.setBounds(92,79,80,25);
		panel.setLayout(null);

		panel.add(label);
		UserTextField= new JTextField(20);
		UserTextField.setBounds(182, 80, 187, 25);
		panel.add(UserTextField);
		getContentPane().add(panel);

		passwordLabel= new JLabel("Password: ");
		passwordLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		passwordLabel.setBounds(92,122,80,25);

		panel.add(passwordLabel);

		passwordText= new JPasswordField();
		passwordText.setBounds(182,123,187,25);

		panel.add(passwordText);


		button1= new JButton("Login");
		button1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		button1.setBounds(179,174,90,25);


		button2= new JButton ("Cancel");
		button2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		button2.setBounds(279,174,90,25);
		/**
		 * I use a lambda expression here, I cited the forum which
		 * contained a question similar to the one I had in mind on my references.
		 * 
		 * "e" is the parameter, which is an ActionEvent, after the -> is a method
		 * declaration. I used lambda expressions many times in my GUI code.
		 * 
		 * The method calls the logIn method for every user object in the system. If
		 * it works for one User object, it will open their
		 * respective frame. (AdminFrame,StudentFrame,TutorFrame)
		 * 
		 * 
		 */
		button1.addActionListener(e -> {
			String username= UserTextField.getText();
			String password= passwordText.getText();

			for (User u: this.system.getAllUsersList()) {
				if (u.logIn(username, password,this.system)) {
					return;
				}

			}

			JOptionPane.showMessageDialog(null, "Invalid username or password. Please type in your username and password again.");
		});
		panel.add(button1);

		
		/**
		 * When the user clicks "cancel" the frame is closed.
		 */
		button2.addActionListener( e -> {
			this.dispose();
		} );
	
		panel.add(button2);
		
		button3= new JButton ("Sign-up");
		button3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		button3.setBounds(227,209,90,25);
		panel.add(button3);
		ButtonHandler handler3= new ButtonHandler();
		button3.addActionListener(handler3);
	}
	
	private class ButtonHandler implements ActionListener {

		/**
		 * The method added to button3 opens a new SignUpFrame.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			SignUpFrame frame1= new SignUpFrame(system);
			frame1.setSize(500,350);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		}
		
	}


}

	

