package tutors;

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

import course.RegularCourse;
import exceptions.InvalidTutorException;
import exceptions.InvalidTutoringCostException;

public class ALevelTutor extends Tutor{

	/**ALevelTutor is the subclass of Tutor.
	 * 
	 * 
	 * The constructor for the ALevelTutor class.First calls the
	 * superclass constructor. A Level Tutors can have a maximum
	 * 10% as their percentage cut, and I decided that it can be between 1 and 10%.
	 * I used the SecureRandom class to generate a random number between 1 and 10.
	 */
	public ALevelTutor(String tutorName, String tutorId, String imageCode, int balance,
			String username, String password) {
		super(tutorName, tutorId, imageCode, balance, username, password);
		SecureRandom random= new SecureRandom();
		this.percentageCut=1+ random.nextInt(10);
	}
	
	/**I have added an extra method to throw an exception in case
	 * the tutor sets a wrong tutoring cost. I ask the tutor to set a cost
	 * in the GUI portion. 
	 * 
	 * The setCourseCost method takes a course to be taught by the tutor,
	 * a time slot for the course, and an integer, the hourly fee of the course.
	 * 
	 * A Level Tutors cannot set their costs to be lower than 700 TL. Thus, 
	 * if the cost is lower than 700 TL, it throws an exception. Else,
	 * it calls the superclass's "addCourse" method.
	 * 
	 */
	
	@Override
	public void setCourseCost(RegularCourse c, String time, int cost) throws InvalidTutoringCostException, InvalidTutorException{
	
			if (cost<700) {
				throw new InvalidTutoringCostException("The cost of this course per hour should be at least 700 TL.");
			}
			
			this.addCourse(c, time, cost);
		
	
		}
		
	}


