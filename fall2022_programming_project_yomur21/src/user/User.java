package user;

import system.TutoringSystem;

public abstract class User {

	/**User is an abstract superclass, the highest in the hierarchy. Each user of the
	 * system has a username, password, and a name.
	 * 
	 */
	protected String username;
	protected String password;
	protected String name;
	
	/**
	 * The constructor of the User class.
	 */
	
	public User(String name, String username, String password) {
		this.username = username;
		this.password = password;
		this.name= name;
	}

	/**
	 * Getters and setters. 
	 */
	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	
	
	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	/** The User class has an abstract method called "logIn". It will be overridden
	 * by each user to open the frame of their respective user type.
	 */
	public abstract boolean logIn(String username, String password, TutoringSystem s);
	
}
