package course;

import exceptions.InvalidPrereqException;

/**BeginnerCourse is a subclass of RegularCourse.
 * 
 *
 */
public class BeginnerCourse extends RegularCourse {

	public BeginnerCourse(String courseName) {
		super(courseName);
	}
	
	/**
	 * This method overrides the "addPreRequisite" method of the superclass.
	 * It takes a RegularCourse argument to put as a prerequisite, checks if
	 * the regular course is advanced, and if it is, throws an exception.
	 * Because beginner courses cannot have advanced courses as prerequisites.
	 */
	@Override 
	public void addPreRequisite(RegularCourse c) throws InvalidPrereqException {
		if (c instanceof AdvancedCourse) {
			throw new InvalidPrereqException();
		}
	}
	
	/**
	 * The toString method only differs from the superclass because of its
	 * addition of the course level, which is beginner in this case.
	 */
	@Override
	public String toString() {
		String a= "<html> Course Name: " + this.courseName + "<br/> Equipments: ";
		for (Equipment eq: this.equipmentList) {
			a=a.concat(eq.getName() + ", ");
		}
		a=a.concat("<br/> Course Level: Beginner");
		a=a.concat("<br/> Course Prerequisites: ");
		
		for (RegularCourse c: this.prereqList) {
			a=a.concat(c.getCourseName() + ", ");
		}
		
		return a;
	}

	

}
