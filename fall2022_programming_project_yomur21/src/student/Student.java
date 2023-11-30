package student;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import course.Equipment;
import course.RegularCourse;
import exceptions.CannotBuyEquipmentException;
import exceptions.CannotRegisterToCourseException;
import frames.StudentFrame;
import system.TutoringSystem;
import tutors.Tutor;
import user.*;

/**
 * the Student class is a subclass of User, and it also implements the Comparable
 * and the BalanceSetter(a custom interface) interfaces.
 * 
 *
 */
public class Student extends User implements Comparable<Student> , BalanceSetter{

	/**
	 * Each student has an ID, age, an imageCode (I added images student1.jpg until
	 * student15.jpg in the resources folder, if you'd like to create Student
	 * objects, please use them as the "imageCode" variables. For example, "/student1.jpg"
	 */
	private String id;
	private int age;
	private String imageCode;
	/**
	 * Each student has a HashMap containing the courses which they took,
	 * and a Boolean as a value. "true" in this case means that the student 
	 * passed the course, and "false" means that the student failed the course.
	 */
	private HashMap<RegularCourse, Boolean> previousCourses;
	/**
	 * A student also keeps a hashmap of tutors that previously taught them this course.
	 */
	private HashMap<RegularCourse,Tutor> previousCoursesTutorList;
	/**
	 * Students keep a hashmap of the courses that they're currently taking, 
	 * having their tutor as the value.
	 */
	private HashMap<RegularCourse, Tutor> currentCourses;
	/**
	 * Students have an account balance, a gender(for sorting them)
	 */
	private double balance;
	private String gender;
	/**
	 * Students keep an array list of their equipments.
	 */
	private ArrayList<Equipment> equipmentsList;
	/**
	 * Each student also keeps a HashMap of their schedule, so a course
	 * and its time.
	 */
	private HashMap<RegularCourse,String> courseSchedule;
	
	

	/**
	 * The student constructor. It initializes the list and the HashMaps.
	 * 
	 */
	public Student(String name, String id, int age, String imageCode, double balance,
			String gender, String username, String password) {
		super(name,username, password);
		this.id = id;
		this.age = age;
		this.imageCode = imageCode;
		this.previousCourses = new HashMap<RegularCourse,Boolean>();
		this.previousCoursesTutorList= new HashMap<RegularCourse, Tutor>();
		this.currentCourses = new HashMap<RegularCourse,Tutor>();
		this.balance = balance;
		this.gender = gender;
		this.equipmentsList= new ArrayList<Equipment>();
		this.courseSchedule= new HashMap<RegularCourse,String>();
	}


	/**
	 * Getters and setters.
	 */
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getImageCode() {
		return imageCode;
	}



	public HashMap<RegularCourse, Boolean> getPreviousCourses() {
		return previousCourses;
	}



	public HashMap<RegularCourse,Tutor> getCurrentCourses() {
		return currentCourses;
	}



	public double getBalance() {
		return balance;
	}
	
	
	/**
	 * I have three methods for a student to register to a course. I use all of them,
	 * just in different frames (in the GUI section).
	 * 
	 * 
	 * 
	 * 
	 * The "registerCourse" method takes the course to be registered in, the tutor
	 * that will teach the course, and the time which the student will take the course.
	 * It first checks if the time is okay for the tutor or not. If the tutor is 
	 * teaching somebody else at the time, it throws a "CannotRegisterToCourseException".
	 * 
	 * Then, the method checks if the student themselves have a class at that time.
	 * If they do, it throws a CannotRegisterToCourseException.
	 * 
	 * If everything is alright, the course and the time are put in the currentCourses variable,
	 * the tutor's "addStudent" method is called, the course and the time is put
	 * in the courseSchedule variable, and also the student is added
	 * to the course's list of students.
	 */
	public void registerCourse(RegularCourse c, Tutor t, String time) throws CannotRegisterToCourseException {
		if (t.getStudentsList()!= null) {
			if (t.getStudentSchedule().containsKey(time)) {
				throw new CannotRegisterToCourseException("Cannot be registered to course. The course tutor is occupied at this time.");
	
			}
		if (courseSchedule.containsValue(time)) {
			throw new CannotRegisterToCourseException("Cannot be registered to course. You are taking another course at this time.");
		}
		
		currentCourses.put(c, t);
		t.addStudent(c, this, time);
		courseSchedule.put(c, time);
		c.addStudent(this);
		
		}
		
	}
	
	
	/**
	 * The "tentativeRegisterCourse" method takes a RegularCourse parameter.
	 * It basically checks if the student can take this course or not.
	 * 
	 * First, it checks if the student has the equipments required for the course,
	 * if not, it throws an exception.
	 * 
	 * Then, it checks if the student has fulfilled all the prerequisite requirements
	 * of the course, even if a course is on the previous courses list of a student,
	 * the student may have failed the course, so the method also checks this.
	 * If the prerequisite requirements aren't met, it throws an exception.
	 * 
	 * 
	 * Finally, if the course itself was passed already by the student, it throws
	 * an exception.
	 */
	
	
	
	
		public void tentativeRegisterCourse(RegularCourse c) throws CannotRegisterToCourseException {
		
		if(c.getEquipmentList()!=null) {
			for (Equipment eq: c.getEquipmentList()) {
				if (!this.equipmentsList.contains(eq)) {
					throw new CannotRegisterToCourseException("Cannot be registered to course. You do not have the required equipments for this course.");
				}
			}
		}
		if (c.getPrereqList()!=null) {
			for (RegularCourse prereq: c.getPrereqList()) {
				if (previousCourses.containsKey(prereq)) {
					if (!previousCourses.get(prereq)) {
					throw new CannotRegisterToCourseException("Cannot be registered to course. You have not fulfilled the prerequisite requirements.");
					}
					}
				else {
					throw new CannotRegisterToCourseException("Cannot be registered to course. You have not fulfilled the prerequisite requirements.");
				}
			}
		}
		
		if (previousCourses.containsKey(c)) {
			if (previousCourses.get(c)) {
				throw new CannotRegisterToCourseException("Cannot be registered to course. You have already passed this course.");
			}
		}
		
		}
		
	
		/**
		 * This method checks if the student can afford the tutoring fee of the course.
		 * 
		 */
	public void checkBalance(RegularCourse c, Tutor t) throws CannotRegisterToCourseException {
		
		if (balance<t.getCourseList().get(c)) {
			throw new CannotRegisterToCourseException("Cannot be registered to course. Your balance is not enough to afford this course.");
		}
	}
	
	
	/**
	 * A getter for the course schedule.
	 */
	public HashMap<RegularCourse, String> getCourseSchedule() {
		return courseSchedule;
	}


	/**
	 * The buyEquipment method takes an Equipment object as a parameter.
	 * The student is trying to buy this object. If the student
	 * has this piece of equipment already, it will throw an exception.
	 * 
	 * Also, if the student cannot afford the equipment, it will throw an exception.
	 * Finally, if all conditions are met, the student "buys" the equipment, which
	 * is added to the student's equipments list, and also the price is subtracted
	 * from the student's balance.
	 */
	public void buyEquipment(Equipment eq) throws CannotBuyEquipmentException {
		if (equipmentsList.contains(eq)) {
			throw new CannotBuyEquipmentException("Cannot buy this piece of equipment. You already have it.");
		}
		if (balance<eq.getPrice()) {
			throw new CannotBuyEquipmentException("Cannot buy this piece of equipment. You do not have enough money.");
		}
		
		this.balance-= eq.getPrice();
		equipmentsList.add(eq);
	}



	
	/**
	 * A compareTo method to sort Student objects by using 
	 * the static sort method of the Collections class. It first checks the ages 
	 * of the students. The smaller age will be shown first.
	 * 
	 * If the ages are equal and if the student is female, this student will be shown
	 * first.
	 */
	
	
	@Override
	public int compareTo(Student s) {
		if (this.age>s.getAge()) {
			return 1;
		}

		if (this.age<s.getAge()) {
			return -1;
		}

		if (this.age==s.getAge()) {

			if (this.gender.equals("Female") && s.getGender().equals("Male")) {
				return -1;
			}

			if (this.gender.equals("Male") && s.getGender().equals("Female")) {
				return 1;
			}
		}
		
		return 0;
	}
	
	
	/**
	 * The overridden method of the User class, It takes a String (username), 
	 * String(password of the user) and the Tutoring System as parameters and
	 * returns a boolean.
	 * It first checks if the username and password argument matches
	 * the username and password of the Student. If so, the user will
	 * successfully log in to the system, and the special interface
	 * for students will be displayed. The rest of the method is creating the
	 * StudentFrame.
	 * 
	 * If the username and password do not match, the method returns false.
	 */
	
	@Override
	public boolean logIn(String username, String password, TutoringSystem s) {
		boolean logInSuccessful= false;
		if (this.username.equals(username)&& this.password.equals(password)) {
			logInSuccessful= true;
			StudentFrame frame3= new StudentFrame(this,s);
			frame3.setSize(750,500);
			frame3.setVisible(true);
			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		return logInSuccessful;
		
	}
	
	/**
	 * This method takes a RegularCourse (previously taken course), a boolean (
	 * if true, student has passed, if false, student has failed), and a tutor(the
	 * tutor which the student took this course from).
	 * 
	 * It puts the course and the status into the Student's previousCourses HashMap.
	 * And it puts the course and the tutor that taught the course
	 * into the Student's previousCoursesTutorList HashMap.
	 */
	public void addPreviousCourse(RegularCourse c, boolean status, Tutor t) {
		previousCourses.put(c, status);
		previousCoursesTutorList.put(c, t);
	}

	/**
	 * The toString method of the student only displays the non-confidential 
	 * information for each student.
	 */
public String toString() {
	return "<html>Student's Name: " + this.name + "<br/>Student's Age: " + this.age + "<br/> Student's Gender: " + this.gender;
}


/**
 * Two getter methods.
 */
public ArrayList<Equipment> getEquipmentsList() {
	return equipmentsList;
}



public HashMap<RegularCourse,Tutor> getPreviousCoursesTutorList() {
	return previousCoursesTutorList;
}

/**
 * This method removes the parameter RegularCourse object from the 
 * currentCourses list of the Student. I use this method in other classes.
 */
public void removeCourse(RegularCourse c) {
	if (currentCourses.containsKey(c)) {
		currentCourses.remove(c);
	}
}


/**
 * Overrides the "setBalance" method of the interface BalanceSetter.
 * It is a setter for the Student's balance. I wanted to group
 * Tutors and Students (ones that have an account balance) into one, that is why
 * I decided to use an interface here.
 */

@Override
public void setBalance(double balance) {
	this.balance= balance;
	
}







	
	
	
	
}
