package course;

import java.util.ArrayList;
import java.util.Collections;

import exceptions.InvalidPrereqException;
import exceptions.InvalidTutorException;
import student.Student;
import tutors.Tutor;

public class RegularCourse {
	/**A regular course has a list of tutors, a name for the course,
	 * a students list, a list of prerequisite classes, and a list of equipments.
	 */
	protected ArrayList<Tutor> tutorsList;
	protected String courseName;
	protected ArrayList<Student> studentsList;
	protected ArrayList<RegularCourse> prereqList;
	protected ArrayList<Equipment> equipmentList;
	
	
	/**Constructor of a RegularCourse. It initializes the array lists and creates 
	 * the instance variable "courseName".
	 * 
	 * 
	 */
	public RegularCourse(String courseName) {
		this.tutorsList = new ArrayList<Tutor>();
		this.courseName = courseName;
		this.studentsList = new ArrayList<Student>();
		this.prereqList = new ArrayList<RegularCourse>();
		this.equipmentList = new ArrayList<Equipment>();
	}
	
	
	/** The "addTutor" method takes a Tutor object, and throws an exception 
	 * if the course has more than 5 tutors teaching it. Else, it adds 
	 * the tutor to the tutors list of the course.
	 */
	public void addTutor(Tutor t) throws InvalidTutorException {
		if (tutorsList.size()>5) {
			System.out.println("Cannot add tutor. A course can have at most 5 tutors.");
			return;
		}
		tutorsList.add(t);
	}
	
	
	/**
	 * Takes a Student object and adds it to the students list.
	 */
	public void addStudent(Student s) {
		studentsList.add(s);
	}
	
	/**Takes a RegularCourse object that will be a prerequisite of the course,
	 * and adds it to the list of prerequisites. Note that the subclasses
	 * of RegularCourse override this method.
	 * 
	 * @param c
	 * @throws InvalidPrereqException
	 */
	public void addPreRequisite(RegularCourse c) throws InvalidPrereqException {
		prereqList.add(c);
	}
	
	/**
	 * Takes an Equipment object as a parameter and adds it to the equipment
	 * list of the course.
	 * @param e
	 */
	public void addEquipment(Equipment e) {
		equipmentList.add(e);
	}
	

	/**
	 * Getters and setters.
	 * 
	 */
	public ArrayList<Tutor> getTutorsList() {
		return tutorsList;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public ArrayList<Student> getStudentsList() {
		return studentsList;
	}



	public ArrayList<RegularCourse> getPrereqList() {
		return prereqList;
	}


	public ArrayList<Equipment> getEquipmentList() {
		return equipmentList;
	}

	
	
	/**
	 * The toString method returns a formatted String, that will show some
	 * information regarding the course in the GUI section of my project.
	 */
	public String toString() {
		String a= "<html> Course Name: " + this.courseName + "<br/> Course Level: " + ((this instanceof AdvancedCourse) ? "Advanced" : "Beginner") + "<br/> Equipments: ";
		for (Equipment eq: this.equipmentList) {
			a=a.concat(eq.getName() + ", ");
		}
		
		a=a.concat("<br/> Course Prerequisites: ");
		
		for (RegularCourse c: this.prereqList) {
			a=a.concat(c.getCourseName() + ", ");
		}
		
		return a;
	}
	
	/** I have implemented my code so that
	 * each prerequisite or equipment is reset when the admin wants to modify a
	 * course's information. These two methods are to reset the prerequisite list
	 * of a course, and to reset the equipments list of a course.
	 *
	 */
	public void resetEquipmentsList() {
		this.equipmentList.removeAll(equipmentList);
	}
	
	public void resetPrereqList() {
		this.prereqList.removeAll(prereqList);
	}



	
	
	
	
}
