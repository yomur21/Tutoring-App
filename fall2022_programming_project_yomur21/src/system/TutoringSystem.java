package system;
import java.util.ArrayList;
import java.util.Map;

import course.Equipment;
import course.RegularCourse;
import student.Student;
import tutors.Tutor;
import user.Administrator;
import user.User;

public class TutoringSystem {

	/**
	 * Each Tutoring System keeps a list of all courses, all tutors, all students, all admins, 
	 * all equipment, and all users in general. The "User", "RegularCourse"
	 * and "Tutor" lists here are all examples of polymorphism, since they also contain
	 * the objects of their subclasses.
	 * 
	 */
		ArrayList<RegularCourse> allCoursesList;
		ArrayList<Tutor> allTutorsList;
		ArrayList<Student> allStudentsList;
		ArrayList<Administrator> adminsList;
		ArrayList<Equipment> allEquipmentsList;
		ArrayList<User> allUsersList;
		
		
		/**
		 * The constructor initializes all the lists.
		 */
		public TutoringSystem() {
			this.allCoursesList= new ArrayList<RegularCourse>();
			this.allTutorsList= new ArrayList<Tutor>();
			this.allStudentsList= new ArrayList<Student>();
			this.allEquipmentsList= new ArrayList<Equipment>();
			this.adminsList= new ArrayList<Administrator>();
			this.allUsersList= new ArrayList<User>();
		}

		/**
		 * The "calculateProfit" method calculates the total profit of the whole system.
		 * I assumed that the total profit would equal to the profit of all equipments
		 * and the tutoring fees. I assumed that the equipment profit will be equal to
		 * the equipment's price multiplied by the equipment's profit percentage. Note that I defined
		 * the profit percentage to be a number between 0 and 100, thus I divide the expression by 100. 
		 * 
		 * If a student has bought an equipment(if the equipment is in a student's list), then that
		 * means that the system has gained profit. It first calculates the equipment profit
		 * by iterating over the equipment list of each student, and adds it to the local variable
		 * "totalProfit".
		 * 
		 * 
		 * Then, I assumed the tutoring profit to be the course's fee multiplied by the
		 * percentage cut of the tutor, which is then divided by 100, as I defined
		 * the percentage cut of the tutor to be a number between 1 and 15 for B Level tutors,
		 * and between 1 and 10 for A Level Tutors.
		 * 
		 * 
		 * The method then iterates through all tutors, and uses a for loop to access
		 * the courses of a tutor. The "value" of each course in the 
		 * courseList of each tutor is the fee of the course.
		 * is the course fee which the tutor specifies themselves.
		 * I multiplied this with the percentage cut, and also multiplied this number again
		 * by the number of students taking this class. 
		 * 
		 * The method finally returns the total profit of all courses.
		 * 
		 */
		public double calculateProfit() {
			double totalProfit=0;
			for (Student s: allStudentsList) {
				for (Equipment eq: s.getEquipmentsList()) {
					totalProfit+= eq.getPrice()*(eq.getProfitPercentage()/100);
				}

			}

			for (Tutor t: allTutorsList) {
				for (Map.Entry<RegularCourse,ArrayList<Student>> entry: t.getStudentsList().entrySet()) {
					RegularCourse c= entry.getKey();
						totalProfit+= ((t.getCourseList().get(c))*(t.getPercentageCut()/100))*(entry.getValue().size());

			}
			}

			return totalProfit;
		}


		
		/**
		 * This method takes a RegularCourse parameter and calculates the
		 * total equipment profit gained by the course. It works similarly
		 * with the method above, the only difference is that this method 
		 * calculates the equipment profit that a specific course gains, which I 
		 * will also need.
		 * 
		 * The method returns a double, which is the total profit of the 
		 * course in terms of equipments.
		 * 
		 */

		public double calculateCourseEquipmentsProfit(RegularCourse c) {
			double courseEquipmentsProfit=0;
			if (!c.getEquipmentList().isEmpty()) {
				for (Tutor t: allTutorsList) {
					if (t.getStudentsList().containsKey(c)) {
					for (Equipment eq: c.getEquipmentList()) {
						courseEquipmentsProfit+= eq.getPrice()*(eq.getProfitPercentage()/100) * (t.getStudentsList().get(c).size());

					}
					}
				}
			}
			
			return courseEquipmentsProfit;
		}
		
		
		/**
		 * Similar to the method above, the "calculateCourseTutoringProfit" method
		 * takes a RegularCourse and returns a double value, which is the total 
		 * profit that the course makes. I explained how I calculated the profit
		 * of a course in the "calculateProfit" method explanation.
		 */
		public double calculateCourseTutoringProfit(RegularCourse c) {
			double courseTutoringProfit=0;
			for (Tutor t: allTutorsList) {
				if (t.getStudentsList().containsKey(c)) {
				courseTutoringProfit+= (t.getCourseList().get(c)) * (t.getStudentsList().get(c).size()) * (t.getPercentageCut()/100);
			}
			}
			
			
			return courseTutoringProfit;
		}
		
		
		
		/**
		 * This method deducts the tutoring fees of a course from a student,
		 * and adds it to the tutor's balance. It returns nothing.
		 * It iterates over the whole list of tutors, and then accesses each course,
		 * and adds the tutoring fee to the tutor's balance.
		 * 
		 * I assumed that the student pays the full tutoring fee,
		 * and the tutor earns the tutoring fee multiplied by
		 * (100 subtracted by the percentage cut) divided by 100. For instance,
		 * if the tutor's percentage cut is 10, the expression I wrote
		 * calculates 90% of the tutoring fee and adds it to the tutor's balance.
		 */
		public void chargeTutoring() {
			for (Tutor t:allTutorsList) {
				for (Map.Entry<RegularCourse,ArrayList<Student>> entry: t.getStudentsList().entrySet()) {
					for (Student s: entry.getValue()) {
						s.setBalance(s.getBalance()-t.getCourseList().get(entry.getKey()));
						t.setBalance(t.getBalance()+ ((t.getCourseList().get(entry.getKey())* ((100-t.getPercentageCut())/100))));
					}
				}
			}
		
		}
		
		
		/*
		 * The method "calculateTutoringFees" has no parameters and returns
		 * the total tutoring fees of the entire system as a double.
		 * 
		 * It iterates over the list of all tutors, and gets the students list of
		 * the tutor. Then, over the HashMap containing a RegularCourse and
		 * an array list of students taking the course, it calculates the tutoring fee
		 * (which is is simply the value of the courseList HashMap.)
		 * and then multiplies it with the number of students (entry.getValue().size()).
		 * 
		 * It then finally returns the total tutoring fee.
		 * 
		 * 
		 */
		public double calculateTutoringFees() {
			double tutoringFee=0;
			for (Tutor t:allTutorsList) {
				if (!t.getStudentsList().isEmpty()) {
					for (Map.Entry<RegularCourse,ArrayList<Student>> entry: t.getStudentsList().entrySet()) {
						if (!entry.getValue().isEmpty()) {
						tutoringFee+=((t.getCourseList().get(entry.getKey()))*(entry.getValue().size()));
							
						}
							}
				
				}
			}
			
			return tutoringFee;
			
		}
		
		/**
		 * The method "calculateEquipmentFees" takes no parameter and returns a
		 * double which corresponds to the total equipment fee of the system.
		 * 
		 * It iterates over the student's list, and then for each student, it checks
		 * the equipments that they have, and adds the fee to the total equipment fee.
		 * 
		 * Finally, it returns the total equipment fee.
		 * 
		 * I assumed that the equipment fee is deducted from a student
		 * when the student buys the equipment, thus I did not implement a
		 * method that charges the equipment fees, as it is already charged anyway.
		 */
		
		public double calculateEquipmentFees() {
			double equipmentFee=0;
			for (Student s: allStudentsList) {
				for (Equipment eq: s.getEquipmentsList()) {
					equipmentFee+= eq.getPrice();
				}
			}
			
			return equipmentFee;
		}
		
		
		
		/*
		 * The "add" methods simply add the given parameters to the
		 * given lists of the system. Note that for tutors, admins, and students,
		 * they will also be added to the list of all users, thanks to polymorphism,
		 * they can all act as User objects as well.
		 */
		
		public void addCourse(RegularCourse c) {
			allCoursesList.add(c);
		}
		
		public void addTutor(Tutor t) {
			allTutorsList.add(t);
			allUsersList.add(t);
		}
		
		public void addStudent(Student s) {
			allStudentsList.add(s);
			allUsersList.add(s);
		}
		
		public void addAdmin(Administrator a) {
			adminsList.add(a);
			allUsersList.add(a);
		}
		
		public void addEquipment(Equipment e) {
			allEquipmentsList.add(e);
		}


		/**
		 * Some getters and setters.
		 * 
		 */
		public ArrayList<RegularCourse> getAllCoursesList() {
			return allCoursesList;
		}


		public ArrayList<Tutor> getAllTutorsList() {
			return allTutorsList;
		}


		public ArrayList<Student> getAllStudentsList() {
			return allStudentsList;
		}


		public ArrayList<Equipment> getAllEquipmentsList() {
			return allEquipmentsList;
		}


		public ArrayList<User> getAllUsersList() {
			return allUsersList;
		}
		
		
		
		/** I use the ShowTakeableCourse method when a student
		 * wants to know the courses that they can take. It takes a student parameter
		 * and returns a String, which contains the course names of the courses
		 * that the student can take. (I will use this in my GUI.)
		 * 
		 * I did not take the balance of the student or the equipment
		 * of the student, or if the student has already taken this class
		 *  into account in this method. It shows the student
		 * what classes they can take based only on the classes they have previously taken.
		 * 
		 * It iterates over the list of all courses. If a course has no prerequisites,
		 * then the student can already take the course.
		 * 
		 * 
		 * Then, if the course has prerequisites, it first declares an arraylist of booleans,
		 * which will tell me if the Student has passed every single prerequisite.
		 * 
		 * If the student passed, it adds "true" to the ArrayList. If not, it adds "false".
		 * 
		 * 
		 * If the ArrayList is full of "true"s, then that means the student
		 * has taken all the required prerequisites of a course. Thus,
		 * the course name is added to the string of "takeableCourses".
		 * 
		 * 
		 * Finally, it returns the string which is all the courses that the
		 * student can take.
		 */
		public String ShowTakeableCourse(Student s) {
			String takeableCourses= "";
			for (RegularCourse c: allCoursesList) {
				
				if (c.getPrereqList().isEmpty()) {
					takeableCourses= takeableCourses.concat(c.getCourseName() + ", ");
					continue;
				}
				
				
				ArrayList<Boolean> StudentHasTakenPreReq = new ArrayList<Boolean>();
				for (RegularCourse prereq: c.getPrereqList()) {
					if (s.getPreviousCourses().containsKey(prereq)) {
						if (s.getPreviousCourses().get(prereq)==true) {
							StudentHasTakenPreReq.add(true);
						}
						else {
							StudentHasTakenPreReq.add(false);
							}
						
					}
					
					else {
						StudentHasTakenPreReq.add(false);
					}
				}
				
				if (!StudentHasTakenPreReq.contains(false)) {
					takeableCourses= takeableCourses.concat(c.getCourseName() +", ");
				}
			}
			
			return takeableCourses;
			
			}
		
		/**
		 * The "ShowEquipment" method returns an ArrayList of Strings
		 * containing information about each equipment.
		 * 
		 * It first creates an Array of the same size as the equipment list.
		 * 
		 * Then, it iterates over the list of equipments and adds the String
		 * containing information regarding the equipment to the String array.
		 * 
		 * Finally, the method returns this array of strings. 
		 * 
		 * I use this method to show equipment information and to create a
		 * JComboBox in my project's GUI portion.
		 */
		
		public String[] ShowEquipment() {
			String [] equipmentNames= new String[allEquipmentsList.size()];
			for (int i=0; i<allEquipmentsList.size();i++) {
				equipmentNames[i]= allEquipmentsList.get(i).getName() + ": " + allEquipmentsList.get(i).getPrice() + " TL.";
			}
			
			return equipmentNames;
			}
		
		
		}
		
		
		
	

