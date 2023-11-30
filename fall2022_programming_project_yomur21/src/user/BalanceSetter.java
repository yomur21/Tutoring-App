package user;
/**
 * "BalanceSetter" is an interface that will be implemented by Tutors and Students.
 * I did not want to do a separate balance modify frame for a Tutor and a Student, 
 * therefore for my code efficiency I decided to create an interface to link a
 * tutor and a student, and separate them from the administrator. (Administrators do 
 * not have a balance in my project). 
 *
 */
public interface BalanceSetter {
	/**
	 * The implementers of BalanceSetter need to implement the setBalance method,
	 * which takes a double argument, and returns nothing.
	 */
	public abstract void setBalance(double balance);
}
