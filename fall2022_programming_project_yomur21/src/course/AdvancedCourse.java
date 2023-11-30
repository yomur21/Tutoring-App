package course;

import exceptions.InvalidTutorException;
import tutors.BLevelTutor;
import tutors.Tutor;

/**
 * AdvancedCourse is a subclass of RegularCourse.
 *
 */
public class AdvancedCourse extends RegularCourse{

	/** The constructor.
	 */
	public AdvancedCourse(String courseName) {
		super(courseName);
	}
	
	/**
	 * Overrides the addTutor method of RegularCourse. If the parameter Tutor 
	 * is a B Level Tutor, the course cannot be taught, therefore it throws an 
	 * exception. Else, it adds the tutor to the course's tutors list.
	 */
	@Override public void addTutor(Tutor t) throws InvalidTutorException {
		if (t instanceof BLevelTutor) {
			throw new InvalidTutorException("Cannot add tutor. A B-Level Tutor cannot teach advanced courses.");
		}
		super.addTutor(t);
	}
	
	/**
	 * The only difference between this class's toString and its super class's toString
	 * is that this toString method also returns the course's level, which
	 * in this case, is advanced.
	 */
	@Override
	public String toString() {
		String a= "<html> Course Name: " + this.courseName + "<br/> Equipments: ";
		for (Equipment eq: this.equipmentList) {
			a=a.concat(eq.getName() + ", ");
		}
		a=a.concat("<br/> Course Level: Advanced");
		a=a.concat("<br/> Course Prerequisites: ");
		
		for (RegularCourse c: this.prereqList) {
			a=a.concat(c.getCourseName() + ", ");
		}
		
		return a;
	}

}
