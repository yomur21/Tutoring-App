package tutors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;


import course.AdvancedCourse;
import course.RegularCourse;
import exceptions.InvalidTutorException;
import exceptions.InvalidTutoringCostException;
import frames.TutorFrame;
import student.Student;
import system.TutoringSystem;
import user.BalanceSetter;
import user.User;

/**
 * Tutor is a superclass, also a subclass of the User class. Since I need
 * a tutor to be either A or B level, I do not need to instantiate a "Tutor" object
 * at all. I also needed to declare a method to be overridden by the Tutor subclasses.
 * However, for a Tutor object, the method (setCourseCost) would not make sense.
 * Thus I decided that the method setCourseCost, and the Tutor class to 
 * be an abstract class. The tutor class also implements the BalanceSetter(custom defined)
 * interface. 
 *
 */
public abstract class Tutor extends User implements BalanceSetter{
	/**
	 * Each tutor has an ID, an image code (I added images titled "tutor1.jpg" until
	 * "tutor10.jpg" in my resources file.) If you would like to create
	 * a Tutor object, please type in "/tutor1.jpg" or any number between 1-10
	 * as the imageCode variable.
	 * 
	 * Each tutor has a balance, a percentageCut, a list of students,
	 * 
	 * a HashMap "studentsList" which contains an ArrayList of students as a value,
	 * and a RegularCourse as a key. The HashMap gives information about
	 * which students are taking which course of the tutor.
	 * 
	 * the courseList HashMap contains a course as a key, and an Integer(type-wrapper class 
	 * to refer to integers) as a value. The integer value means the tutoring cost of
	 * the specific class.
	 * 
	 * the "courseSchedule" TreeMap (I wanted this to be a TreeMap to sort
	 * the keys so that the tutor's schedule goes from 08:00 until 21:00.)
	 * contains a String, which is the time slot of the course, and the value, which
	 * is the course itself.
	 * 
	 * the "studentSchedule" TreeMap (It is a TreeMap for the same reason) contains
	 * a String indicating the time of a course, and the corresponding value
	 * is the Student taking that course.
	 */
	protected String tutorId;
	protected String imageCode;
	protected double balance;
	protected int percentageCut;
	protected ArrayList<Student> TutorStudentsList;
	protected HashMap<RegularCourse,ArrayList<Student>> studentsList;
	protected HashMap<RegularCourse,Integer> courseList;
	protected TreeMap<String,RegularCourse> courseSchedule;
	protected TreeMap<String,Student> studentSchedule;
	
	
	/**
	 * 
	 *The constructor initializes the lists and the maps, and also
	 *some other fields.
	 */
	
	public Tutor(String tutorName, String tutorId, String imageCode, int balance, String username, String password) {
		super(tutorName, username, password);
		this.tutorId = tutorId;
		this.imageCode = imageCode;
		this.balance = balance;
		this.courseSchedule = new TreeMap<String,RegularCourse>();
		this.studentsList= new HashMap<RegularCourse,ArrayList<Student>>();
		//Integer: the tutoring cost 
		this.courseList = new HashMap<RegularCourse,Integer>();
		this.TutorStudentsList= new ArrayList<Student>();
		this.studentSchedule= new TreeMap<String,Student>();
	}



	/**
	 * Getters and setters.
	 */
	public String getTutorId() {
		return tutorId;
	}


	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}


	public String getImageCode() {
		return imageCode;
	}


	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}


	public double getBalance() {
		return balance;
	}


	public double getPercentageCut() {
		return percentageCut;
	}


	public TreeMap<String,RegularCourse> getSchedule() {
		return courseSchedule;
	}


	public HashMap<RegularCourse, ArrayList<Student>> getStudentsList() {
		return studentsList;
	}


	public HashMap<RegularCourse, Integer> getCourseList() {
		return courseList;
	}
	
	
	/** The "addCourse" method takes a RegularCourse (course that the tutor will teach),
	 * a String(the time slot), and an integer (the tutoring cost of the course).
	 * 
	 * It then puts the course and the cost to the "courseList" hashmap of the
	 * tutor. It also puts the time of the course and the course itself
	 * to the "courseSchedule" treemap of the tutor. And finally, if
	 * the tutor is not teaching the RegularCourse "c" already, it adds
	 * the tutor to the course c's tutors list.
	 */
	public void addCourse(RegularCourse c, String time, int tutoringCost) throws InvalidTutorException {
		courseList.put(c, tutoringCost);
		courseSchedule.put(time,c);
		if (!c.getTutorsList().contains(this)) {
		c.addTutor(this);
		}
	}
	
	
	/**
	 *The method "selectCourse" takes a RegularCourse argument 
	 *and first checks if the course is an AdvancedCourse.
	 *
	 *If the course is advanced, it means that a B Level Tutor cannot teach that course.
	 *Thus, if the tutor (this) is an instance of the BLevelTutor class, 
	 *the method throws an exception. Nothing happens if the tutor is A Level. 
	 */
	public void selectCourse(RegularCourse c) throws InvalidTutorException {
		if (c instanceof AdvancedCourse) {
			if (this instanceof BLevelTutor) {
				throw new InvalidTutorException("You cannot teach this course. You are not qualified enough.");
			}
		}
	}
	
	
	
	
	
	
	/**
	 * the "updateStudentStatus" method takes a RegularCourse(a course that
	 * a student has finished), the Student that finished the course, and a String
	 * (whether the student failed or not) as arguments.
	 * 
	 * 
	 * If the student passed the course, the course is added to the
	 * previous courses list of the student. ("true" means the student passed, and "this" being
	 * the tutor that taught the course to the student.). And the course
	 * is removed from the current courses list of the student.
	 * 
	 * If the student failed, then the course is added to the previous courses list
	 * of the student ("false" means they failed.)
	 * And the course is removed from the current courses list of the Student.
	 */
	public void updateStudentStatus(RegularCourse c, Student s, String status) {

		if (status.equals("pass")) {
			s.addPreviousCourse(c, true,this);
			s.removeCourse(c);
		}
		else if (status.equals("fail")) {
			s.addPreviousCourse(c, false,this);
			s.removeCourse(c);
		}
		
	}
	
	/**
	 * The addStudent method takes a RegularCourse(the course that the student
	 * is taking), a Student (the student that is taking the course), and a String
	 * (the time slot of the course). If the studentsList variable already has 
	 * the course as a key, it adds the student to the ArrayList of students. 
	 * There may be duplicate students in the studentsList, however the student
	 * might be taking two different time slots of the tutor, and thus I kept
	 * duplicate versions of the Student.
	 * 
	 * 
	 * If the course will be entered to the studentsList for the first time,
	 * the method first creates an ArrayList of Students and adds the student to that list.
	 * It finally puts the course and the ArrayList to the "studentsList" variable
	 * of the Tutor.
	 * 
	 * 
	 * The student is also added to the TutorStudentsList variable of the Tutor, 
	 * this time I checked for duplicate values, and did not add the Student if it 
	 * would be a duplicate.
	 * 
	 * Finally, the time slot of the course and the student taking the course
	 * is put into the studentSchedule treemap. 
	 */
	public void addStudent(RegularCourse c, Student s, String time) {
		if(studentsList.containsKey(c)) {
			studentsList.get(c).add(s);
		}
		else {
			ArrayList<Student> studentList= new ArrayList<Student>();
			studentList.add(s);
			studentsList.put(c, studentList);
		}
		if (!TutorStudentsList.contains(s)) {
		TutorStudentsList.add(s);
		}
		studentSchedule.put(time, s);
	}
	

	/**
	 * The "logIn" method is the same as the admins and the students. It takes two
	 * string parameters (username and password), and it also takes a TutoringSystem
	 * object. It checks if the arguments are equal
	 * to the current object's username and password pair.
	 * 
	 * If it is, it opens the tutor frame, and returns a boolean. If logInSuccessful
	 * is true, this means that the user was able to log in. If false, this means
	 * that the log in was not successful.
	 */
	public boolean logIn(String username, String password, TutoringSystem s) {
		boolean logInSuccessful= false;
		if (this.username.equals(username)&& this.password.equals(password)) {
			logInSuccessful=true;
			TutorFrame frame2= new TutorFrame(this,s);
			frame2.setSize(700,500);
			frame2.setVisible(true);
			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		return logInSuccessful;
		
	}
	

	/**
	 * Getters.
	 */
	public ArrayList<Student> getTutorStudentsList() {
		return TutorStudentsList;
	}


	public TreeMap<String,RegularCourse> getCourseSchedule() {
		return courseSchedule;
	}





	public TreeMap<String, Student> getStudentSchedule() {
		return studentSchedule;
	}



	/**
	 * The implementation of the "setBalance" method of the BalanceSetter interface.
	 * Admins do not have a balance in my version, but both tutors and students do, 
	 * thus I decided to use an interface to create a setBalance method 
	 * and connect Tutors and Students to set their balance without writing
	 * separate code for them in the GUI.
	 * 
	 * The setBalance method is a simple setter that sets the balance of the tutor
	 * to a given value. 
	 */
	public void setBalance(double d) {
		this.balance=d;
	}
	
	
	/**
	 * the toString method returns a string containing information about the tutor.
	 */
	
	public String toString() {
		String a= "<html>Tutor Name: " + this.name + "<br/> Tutor ID: " + this.tutorId + "<br/> Tutor's Courses: ";
		for (Map.Entry<RegularCourse,Integer> entry: this.courseList.entrySet()) {
			RegularCourse c= entry.getKey();
			a= a.concat(c.getCourseName() + ", ");
		}
		
		return a;
	}
	
	/**
	 * I wrote an abstract method "setCourseCost" here which will be 
	 * overridden by the ALevelTutor and BLevelTutor classes. (I will explain
	 * the method in their own sections)
	 */
	public abstract void setCourseCost(RegularCourse c, String time, int cost) throws InvalidTutoringCostException, InvalidTutorException;
	
	




	
	

	
}
