package tutors;

import java.security.SecureRandom;

import course.RegularCourse;
import exceptions.InvalidTutorException;
import exceptions.InvalidTutoringCostException;

public class BLevelTutor extends Tutor{

	/**
	 * BLevelTutor is the subclass of Tutor.
	 * 
	 * 
	 * The constructor. Calls the superclass's constructor. B Level Tutors 
	 * can have a maximum of 15% percentage cut. Thus, I used the SecureRandom class
	 * to generate a number between 1 and 15 and assumed it to be the percentage cut
	 * of the tutor.
	 */
	
	public BLevelTutor(String tutorName, String tutorId, String imageCode, int balance, 
			String username, String password) {
		super(tutorName, tutorId, imageCode, balance, username, password);
		SecureRandom random= new SecureRandom();
		this.percentageCut= 1+ random.nextInt(15);
	}
	
	/**
	 * Similar to the setCourseCost method of ALevelTutor, it overrides
	 * the abstract method setCourseCost in the Tutor class.
	 * setCourseCost takes a course which will be taught by the tutor, a String which
	 * is the time slot of the course, and an integer, which is the tutoring
	 * cost decided by the tutor. 
	 * 
	 * B Level Tutors cannot set a course fee to be more than 1000 TL. Thus,
	 * when the cost is over 1000 TL or negative, it throws an exception.
	 */
	
	@Override
public void setCourseCost(RegularCourse c, String time, int cost) throws InvalidTutoringCostException, InvalidTutorException{
		
			if (cost>1000 || cost<0) {
				throw new InvalidTutoringCostException("The cost of this course per hour should be between 0-1000 TL.");
			}
			
			this.addCourse(c, time, cost);
			


		}
		
		
		
	}

