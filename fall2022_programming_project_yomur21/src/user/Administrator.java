package user;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

import course.Equipment;
import course.RegularCourse;
import frames.AdminFrame;
import student.Student;
import system.TutoringSystem;
import tutors.Tutor;

/**
 * The Administrator class is a subclass of the User class.
 * 
 *
 */
public class Administrator extends User{
	/**
	 * The constructor simply calls the superclass's constructor. Administrators
	 * do not have any other special fields.
	 */
	public Administrator(String username, String password, String name) {
		super(name,username, password);
	}
	
	
	/**
	 * Overrides the logIn method of the User class. It takes two String arguments
	 * (username and password) and a TutoringSystem. It returns a boolean containing
	 * information about whether the log in was successful or not. 
	 * 
	 * If the current object's password and username are the same as the arguments,
	 * the admninistrator frame of the GUI is opened. 
	 */
	@Override
	public boolean logIn(String username, String password, TutoringSystem s) {
		boolean logInSuccessful= false;
		if (this.username.equals(username)&& this.password.equals(password)) {
			logInSuccessful= true;
			AdminFrame frame4= new AdminFrame(this,s);
			frame4.setSize(700,500);
			frame4.setVisible(true);
			frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		return logInSuccessful;
		
	}
	
	

	
	
	
	
}
