package main;

import javax.swing.JFrame;

import course.AdvancedCourse;
import course.BeginnerCourse;
import course.Equipment;
import course.RegularCourse;
import exceptions.CannotBuyEquipmentException;
import exceptions.CannotRegisterToCourseException;
import exceptions.InvalidPrereqException;
import exceptions.InvalidTutorException;
import frames.LogInFrame;
import student.Student;
import system.TutoringSystem;
import tutors.ALevelTutor;
import tutors.BLevelTutor;
import tutors.Tutor;
import user.Administrator;

/************** Pledge of Honor ******************************************
I hereby certify that I have completed this programming project on my own
without any help from anyone else. The effort in the project thus belongs
completely to me. I did not search for a solution, or I did not consult any
program written by others or did not copy any program from other sources. I
read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Yamac Omur, 79458>
*************************************************************************/



public class Main {
	public static void main(String[] args) {
		/**
		 * I created my student, tutor and admin objects here.
		 */
		Student s1= new Student("Nawal Waseem", "1234", 18, "/student1.jpg", 100000, "Female", "eva123", "4571evad");
		Student s2= new Student("Zulal Demirtas", "2345", 19, "/student2.jpg", 100000, "Female", "ilovechemistry", "boron");
		Student s3= new Student("Sevval Kazokoglu", "3456",19,"/student3.jpg",100000, "Female", "somsomi", "birthdayxoxo");
		Student s4= new Student("Minh Pham", "4567",19,"/student4.jpg",100000, "Male", "kurino", "anhbanmai");
		Student s5= new Student("Pardis Fish", "5678",19,"/student5.jpg",100000, "Female", "fishtar", "azhdaha");
		Student s6= new Student("Yagmur Elci", "6789",20,"/student6.jpg",100000, "Female", "lngenthou", "vk987lara");
		Student s7= new Student("Jiwoo Kim", "7890",21,"/student7.jpg",100000, "Female", "chuucandoit", "saveloona");
		Student s8= new Student("Ismail Ayas", "8901",18,"/student8.jpg",100000, "Male", "turkishraccoon", "cuteraccoons1234");
		Student s9= new Student("Mert Guneyli", "9012",19,"/student9.jpg",100000, "Male", "machines", "factorybicibici");
		Student s10= new Student("Emre Ekici", "0123",20,"/student10.jpg",100000, "Male", "istanbulmemories", "moonlight4562");
		Student s11= new Student("Gavin Ren", "1123",19,"/student11.jpg",100000, "Male", "renvosje", "gaathet");
		Student s12= new Student("Filip Filipie", "2213",17,"/student12.jpg",100000, "Male", "filiphanie", "czesc765");
		Student s13= new Student("Frederic Chopin", "2137",18,"/student13.jpg",100000, "Male", "chopinnie", "teateatea444");
		Student s14= new Student("Sude Suzan", "4555",19,"/student14.jpg",100000, "Female", "suzzie", "prettyswift0981");
		Student s15 = new Student("Irem Tulukoglu", "9837",21,"/student15.jpg",100000, "Female", "tsfanclub", "emoswift8172");
		Student s16= new Student ("Akarsh Six", "7738", 19, "/student13.jpg", 100000, "Male", "thedevas", "600dev");
		
		
		Administrator a1= new Administrator("admin0982", "imsogood2123", "Ozgur Yuksel");
		
		
		
		
		Tutor t1= new ALevelTutor("Oznur Ozkasap", "5641", "/tutor1.jpg", 0, "oozkasap", "comp132");
		Tutor t2= new ALevelTutor("Sinem Coleri", "9823", "/tutor2.jpg", 0, "scoleri", "engr200");
		Tutor t3= new ALevelTutor("Beren Semiz", "5614", "/tutor3.jpg", 0, "bsemiz", "comp125");
		Tutor t4= new ALevelTutor("Yucel Yemez", "5344", "/tutor4.jpg", 0, "yyemez", "comp106");
		Tutor t5= new ALevelTutor("Deniz Yuret", "9182", "/tutor5.jpg", 0, "dyuret", "comp542");
		Tutor t6= new BLevelTutor("Aykut Erdem", "6784", "/tutor6.jpg", 0, "aerdem", "comp201");
		Tutor t7= new BLevelTutor("Kaan Guven", "3218", "/tutor7.jpg", 0, "kguven", "phys102");
		Tutor t8= new BLevelTutor("Aysel Ozdemir", "3921", "/tutor8.jpg", 0, "aozdemir", "hums113");
		Tutor t9= new BLevelTutor("Ulas Gurel", "0891", "/tutor9.jpg", 0, "ugurel", "phys101");
		Tutor t10= new ALevelTutor("Chloe Brown", "3988", "/tutor1.jpg", 0, "cbrown", "math106");
		Tutor t11= new ALevelTutor("August Anderson", "9487", "/tutor4.jpg", 0, "aanderson", "elec202");
		Tutor t12= new ALevelTutor("Jaydin Gonzales", "1632", "/tutor6.jpg", 0, "jgonzales", "elec201");
		Tutor t13= new BLevelTutor("Patricia Villegas", "7467", "/tutor2.jpg", 0, "pvillegas", "phys410");
		Tutor t14= new BLevelTutor("Harley Durham", "5473", "/tutor3.jpg", 0, "hdurham", "math204");
		
		/**
		 * I created the system and added the objects to the system.
		 */
		TutoringSystem ts= new TutoringSystem();
		ts.addStudent(s2);
		ts.addStudent(s3);
		ts.addStudent(s1);
		ts.addStudent(s4);
		ts.addStudent(s5);
		ts.addStudent(s6);
		ts.addStudent(s7);
		ts.addStudent(s8);
		ts.addStudent(s9);
		ts.addStudent(s10);
		ts.addStudent(s11);
		ts.addStudent(s12);
		ts.addStudent(s13);
		ts.addStudent(s14);
		ts.addStudent(s15);
		ts.addStudent(s16);
		ts.addTutor(t1);
		ts.addTutor(t2);
		ts.addTutor(t3);
		ts.addTutor(t4);
		ts.addTutor(t5);
		ts.addTutor(t6);
		ts.addTutor(t7);
		ts.addTutor(t8);
		ts.addTutor(t9);
		ts.addTutor(t10);
		ts.addTutor(t11);
		ts.addTutor(t12);
		ts.addTutor(t13);
		ts.addTutor(t14);
		ts.addAdmin(a1);
		
		
		/**
		 * I created the course objects.
		 */
		RegularCourse c1= new AdvancedCourse("Differential Equations");
		RegularCourse c2= new AdvancedCourse("Electromagnetism");
		RegularCourse c3= new AdvancedCourse("Natural Language Processing");
		RegularCourse c4= new AdvancedCourse("Signals and Systems");
		RegularCourse c5= new AdvancedCourse("Academic Writing for Science");
		RegularCourse c6= new AdvancedCourse("Advanced Programming");
		RegularCourse c7= new BeginnerCourse("Linear Algebra");
		RegularCourse c8= new BeginnerCourse("Calculus 1");
		RegularCourse c9= new BeginnerCourse("Calculus 2");
		RegularCourse c10= new BeginnerCourse("Programming with Python");
		RegularCourse c11= new BeginnerCourse("Physics 1");
		RegularCourse c12= new BeginnerCourse("Physics 2");
		
		
		
		/**
		 * I created the equipment objects and added them to the system.
		 */
		
		Equipment e1= new Equipment(800, "Tablet", 20);
		Equipment e2= new Equipment(2600, "Laptop", 15);
		Equipment e3= new Equipment(300, "Textbook",10);
		Equipment e4= new Equipment(600, "Multimeter", 30);
		Equipment e5= new Equipment(50, "Notebook", 10);
		
		c1.addEquipment(e3);
		c3.addEquipment(e2);
		c3.addEquipment(e1);
		c5.addEquipment(e5);
		c6.addEquipment(e2);
		c7.addEquipment(e5);
		c8.addEquipment(e1);
		c9.addEquipment(e1);
		c10.addEquipment(e2);
		c11.addEquipment(e4);
		c12.addEquipment(e4);
		
		
		ts.addEquipment(e1);
		ts.addEquipment(e2);
		ts.addEquipment(e3);
		ts.addEquipment(e4);
		ts.addEquipment(e5);
		
		
		/**
		 * I added some prerequisites to certain courses.
		 */
		try {
			c1.addPreRequisite(c8);
			c1.addPreRequisite(c9);
			c2.addPreRequisite(c8);
			c2.addPreRequisite(c11);
			c3.addPreRequisite(c8);
			c3.addPreRequisite(c9);
			c4.addPreRequisite(c7);
			c4.addPreRequisite(c8);
			c6.addPreRequisite(c10);
			
		} 
		
		catch (InvalidPrereqException e) {
			e.printStackTrace();
		}
		/**
		 * I added the courses to the system.
		 */
		ts.addCourse(c1);
		ts.addCourse(c2);
		ts.addCourse(c3);
		ts.addCourse(c4);
		ts.addCourse(c5);
		ts.addCourse(c6);
		ts.addCourse(c7);
		ts.addCourse(c8);
		ts.addCourse(c9);
		ts.addCourse(c10);
		ts.addCourse(c11);
		ts.addCourse(c12);
		/**
		 * I added some prerequisite courses to some students so that they can take
		 * the advanced courses.
		 * 
		 * I also added a "fail" status on student1 to see how it looks on the GUI.
		 */
		s1.addPreviousCourse(c8, true, t1);
		s1.addPreviousCourse(c9, true, t1);
		s1.addPreviousCourse(c11, true, t1);
		s1.addPreviousCourse(c5, false, t1);
		s2.addPreviousCourse(c8, true, t10);
		s2.addPreviousCourse(c9, true, t8);
		s3.addPreviousCourse(c8, true, t10);
		s3.addPreviousCourse(c9, true, t8);
		s4.addPreviousCourse(c8, true, t10);
		s4.addPreviousCourse(c9, true, t8);
		s5.addPreviousCourse(c8, true, t10);
		s5.addPreviousCourse(c9, true, t8);
		s6.addPreviousCourse(c8, true, t10);
		s6.addPreviousCourse(c9, true, t8);
		s7.addPreviousCourse(c8, true, t10);
		s7.addPreviousCourse(c9, true, t8);
		s8.addPreviousCourse(c8, true, t10);
		s8.addPreviousCourse(c9, true, t8);
		
		
	
		s2.addPreviousCourse(c11, true, t10);
		s3.addPreviousCourse(c11, true, t6);
		s4.addPreviousCourse(c11, true, t10);
		s5.addPreviousCourse(c11, true, t10);
		s6.addPreviousCourse(c11, true, t10);
		s7.addPreviousCourse(c11, true, t6);
		s8.addPreviousCourse(c11, true, t6);
		
		
		s1.addPreviousCourse(c10,true,t7);
		s2.addPreviousCourse(c10, true, t7);
		s3.addPreviousCourse(c10, true, t6);
		s4.addPreviousCourse(c10, true, t13);
		s5.addPreviousCourse(c10, true, t9);
		s6.addPreviousCourse(c10, true, t7);
		s7.addPreviousCourse(c10, true, t6);
		s8.addPreviousCourse(c10, true, t6);
		
		
		s1.addPreviousCourse(c7, true, t9);
		s2.addPreviousCourse(c7, true, t8);
		s3.addPreviousCourse(c7, true, t6);
		s4.addPreviousCourse(c7, true, t14);
		s5.addPreviousCourse(c7, true, t9);
		s6.addPreviousCourse(c7, true, t8);
		s7.addPreviousCourse(c7, true, t6);
		s8.addPreviousCourse(c7, true, t14);
		
		
		/**
		 * I added courses to tutors. 4 tutors in total are teaching one course, with
		 * 2 different time slots.
		 */
		try {
		t1.addCourse(c1, "09:00-10:00", 850);
		t1.addCourse(c1, "11:00-12:00", 850);
		
		t2.addCourse(c1, "13:00-14:00", 740);
		t2.addCourse(c1, "20:00-21:00", 740);
		
		t3.addCourse(c1, "15:00-16:00", 750);
		t3.addCourse(c1, "10:00-11:00", 750);
		
		t11.addCourse(c1, "08:00-09:00", 700);
		t11.addCourse(c1, "09:00-10:00", 700);
		
		t1.addCourse(c2, "20:00-21:00", 900);
		t1.addCourse(c2, "14:00-15:00", 900);
		
		t4.addCourse(c2, "20:00-21:00", 760);
		t4.addCourse(c2, "11:00-12:00", 760);
		
		t3.addCourse(c2, "16:00-17:00", 780);
		t3.addCourse(c2, "17:00-18:00", 780);
		
		t12.addCourse(c2, "08:00-09:00", 745);
		t12.addCourse(c2, "09:00-10:00", 745);
		
		t5.addCourse(c3, "20:00-21:00", 765);
		t5.addCourse(c3, "19:00-20:00", 765);
		
		t4.addCourse(c3, "08:00-09:00", 740);
		t4.addCourse(c3, "10:00-11:00", 740);
		
		t2.addCourse(c3, "10:00-11:00", 785);
		t2.addCourse(c3, "15:00-16:00", 785);
		
		t11.addCourse(c3, "10:00-11:00", 765);
		t11.addCourse(c3, "11:00-12:00", 765);
		
		t5.addCourse(c4, "08:00-09:00", 760);
		t5.addCourse(c4, "13:00-14:00", 760);
		
		t3.addCourse(c4, "18:00-19:00", 890);
		t3.addCourse(c4, "11:00-12:00", 890);
		
		t1.addCourse(c4, "15:00-16:00", 740);
		t1.addCourse(c4, "16:00-17:00", 740);
		
		t12.addCourse(c4, "11:00-12:00", 900);
		t12.addCourse(c4, "13:00-14:00", 900);
		
		t4.addCourse(c5, "15:00-16:00", 950);
		t4.addCourse(c5, "16:00-17:00", 950);
		
		t2.addCourse(c5, "14:00-15:00", 880);
		t2.addCourse(c5, "12:00-13:00", 880);
		
		t1.addCourse(c5, "13:00-14:00", 900);
		t1.addCourse(c5, "18:00-19:00", 900);
		
		t11.addCourse(c5, "13:00-14:00", 705);
		t11.addCourse(c5, "14:00-15:00", 705);
		
		t3.addCourse(c6, "13:00-14:00", 860);
		t3.addCourse(c6, "20:00-21:00", 860);
		
		t5.addCourse(c6, "09:00-10:00", 750);
		t5.addCourse(c6, "16:00-17:00", 750);
		
		t1.addCourse(c6, "08:00-09:00", 745);
		t1.addCourse(c6, "10:00-11:00", 745);
	
		
		
		t12.addCourse(c6, "14:00-15:00", 860);
		t12.addCourse(c6, "15:00-16:00", 860);
		
		
	
	
		t6.addCourse(c12, "09:00-10:00", 560);
		t6.addCourse(c12, "11:00-12:00", 560);
		
		t7.addCourse(c12, "13:00-14:00", 740);
		t7.addCourse(c12, "20:00-21:00", 740);
		
		t8.addCourse(c12, "15:00-16:00", 600);
		t8.addCourse(c12, "10:00-11:00", 600);
		
		t13.addCourse(c12, "08:00-09:00", 500);
		t13.addCourse(c12, "09:00-10:00", 500);
		
		t11.addCourse(c12, "20:00-21:00", 760);
		
		t6.addCourse(c7, "20:00-21:00", 500);
		t6.addCourse(c7, "14:00-15:00", 500);
		
		t9.addCourse(c7, "20:00-21:00", 450);
		t9.addCourse(c7, "11:00-12:00", 450);
		
		t8.addCourse(c7, "16:00-17:00", 700);
		t8.addCourse(c7, "17:00-18:00", 700);
		
		
		t14.addCourse(c7, "08:00-09:00", 630);
		t14.addCourse(c7, "09:00-10:00", 630);
		
		t10.addCourse(c8, "20:00-21:00", 650);
		t10.addCourse(c8, "19:00-20:00", 650);
		
		t9.addCourse(c8, "08:00-09:00", 630);
		t9.addCourse(c8, "10:00-11:00", 630);
		
		t7.addCourse(c8, "10:00-11:00", 620);
		t7.addCourse(c8, "15:00-16:00", 620);
		
		
		t13.addCourse(c8, "10:00-11:00", 390);
		t13.addCourse(c8, "11:00-12:00", 400);
		
		
		
		
		
		
		t10.addCourse(c9, "08:00-09:00", 530);
		t10.addCourse(c9, "13:00-14:00", 530);
		
		t8.addCourse(c9, "18:00-19:00", 390);
		t8.addCourse(c9, "11:00-12:00", 390);
		
		t6.addCourse(c9, "15:00-16:00", 700);
		t6.addCourse(c9, "16:00-17:00", 700);
		
		t14.addCourse(c9, "11:00-12:00", 572);
		t14.addCourse(c9, "13:00-14:00", 572);
		
		t12.addCourse(c9, "16:00-17:00", 760);
		
		
		t9.addCourse(c10, "15:00-16:00", 550);
		t9.addCourse(c10, "16:00-17:00", 550);
		
		t7.addCourse(c10, "14:00-15:00", 580);
		t7.addCourse(c10, "12:00-13:00", 580);
		
		t6.addCourse(c10, "13:00-14:00", 400);
		t6.addCourse(c10, "18:00-19:00", 400);
		
		t13.addCourse(c10, "13:00-14:00", 665);
		t13.addCourse(c10, "14:00-15:00", 665);
		
		
		t8.addCourse(c11, "13:00-14:00", 460);
		t8.addCourse(c11, "20:00-21:00", 460);
		
		t10.addCourse(c11, "09:00-10:00", 510);
		t10.addCourse(c11, "16:00-17:00", 510);
		
		t6.addCourse(c11, "08:00-09:00", 495);
		t6.addCourse(c11, "10:00-11:00", 495);
	
		
		t14.addCourse(c11, "16:00-17:00", 375);
		t14.addCourse(c11, "17:00-18:00", 375);
		
	
		}
		
		catch (InvalidTutorException e) {
			System.out.println(e);
		}
		
		
		
		/**
		 * I bought equipment to make sure the students
		 * register to the classes.
		 */
		try {
			s1.buyEquipment(e1);
			s1.buyEquipment(e2);
			s1.buyEquipment(e3);
			s1.buyEquipment(e5);
			
			s2.buyEquipment(e1);
			s2.buyEquipment(e2);
			s2.buyEquipment(e3);
			s2.buyEquipment(e5);
			
			s3.buyEquipment(e1);
			s3.buyEquipment(e2);
			s3.buyEquipment(e3);
			s3.buyEquipment(e5);
			
			
			s4.buyEquipment(e1);
			s4.buyEquipment(e2);
			s4.buyEquipment(e3);
			s4.buyEquipment(e5);
			
			
			s5.buyEquipment(e1);
			s5.buyEquipment(e2);
			s5.buyEquipment(e3);
			s5.buyEquipment(e5);
			
			
			s6.buyEquipment(e1);
			s6.buyEquipment(e2);
			s6.buyEquipment(e3);
			s6.buyEquipment(e5);
			
			
			s7.buyEquipment(e1);
			s7.buyEquipment(e2);
			s7.buyEquipment(e3);
			s7.buyEquipment(e5);
			
			
			s8.buyEquipment(e1);
			s8.buyEquipment(e2);
			s8.buyEquipment(e3);
			s8.buyEquipment(e5);
			
			
			s9.buyEquipment(e1);
			s9.buyEquipment(e2);
			s9.buyEquipment(e4);
			
			s10.buyEquipment(e1);
			s10.buyEquipment(e2);
			s10.buyEquipment(e4);
			
			s11.buyEquipment(e1);
			s11.buyEquipment(e2);
			s11.buyEquipment(e4);
			
			s12.buyEquipment(e1);
			s12.buyEquipment(e2);
			s12.buyEquipment(e4);
			
			s13.buyEquipment(e1);
			s13.buyEquipment(e2);
			s13.buyEquipment(e4);
			
			s14.buyEquipment(e1);
			s14.buyEquipment(e2);
			s14.buyEquipment(e4);
			
			s15.buyEquipment(e1);
			s15.buyEquipment(e2);
			s15.buyEquipment(e4);
			
			s16.buyEquipment(e1);
			s16.buyEquipment(e2);
			s16.buyEquipment(e4);
			
			
		
			
			
			
			

	}

	catch (CannotBuyEquipmentException e) {
		System.out.println(e);
	}

		
		
		
		
		
		
		
		
		
		
		
		/**
		 * I registered the students to courses randomly.
		 */
		try {
		s1.registerCourse(c1, t1, "11:00-12:00");
		s2.registerCourse(c1, t2, "20:00-21:00");
		s3.registerCourse(c1, t1, "09:00-10:00");
		s4.registerCourse(c1, t2, "13:00-14:00");
		s5.registerCourse(c1, t3, "15:00-16:00");
		s6.registerCourse(c1, t3, "10:00-11:00");
		s7.registerCourse(c1, t11, "08:00-09:00");
		s8.registerCourse(c1, t11, "09:00-10:00");
		
		
		
		s1.registerCourse(c2, t12, "09:00-10:00");
		s2.registerCourse(c2, t1, "14:00-15:00");
		s3.registerCourse(c2, t1, "20:00-21:00");
		s4.registerCourse(c2, t4, "11:00-12:00");
		s5.registerCourse(c2, t4, "20:00-21:00");
		s6.registerCourse(c2, t3, "16:00-17:00");
		s7.registerCourse(c2, t3, "17:00-18:00");
		s8.registerCourse(c2, t12, "08:00-09:00");
		
		
		
		s1.registerCourse(c3, t5, "20:00-21:00");
		s2.registerCourse(c3, t5, "19:00-20:00");
		s3.registerCourse(c3, t4, "10:00-11:00");
		s4.registerCourse(c3, t4, "08:00-09:00");
		s5.registerCourse(c3, t2, "10:00-11:00");
		s6.registerCourse(c3, t2, "15:00-16:00");
		s7.registerCourse(c3, t11, "10:00-11:00");
		s8.registerCourse(c3, t11, "11:00-12:00");
		
		
		s1.registerCourse(c4, t5, "13:00-14:00");
		s2.registerCourse(c4, t5, "08:00-09:00");
		s3.registerCourse(c4, t3, "18:00-19:00");
		s4.registerCourse(c4, t1, "15:00-16:00");
		s5.registerCourse(c4, t1, "16:00-17:00");
		s6.registerCourse(c4, t3, "11:00-12:00");
		s7.registerCourse(c4, t12, "11:00-12:00");
		s8.registerCourse(c4, t12, "13:00-14:00");
		
		
		s1.registerCourse(c5, t4, "15:00-16:00");
		s2.registerCourse(c5, t4, "16:00-17:00");
		s3.registerCourse(c5, t2, "14:00-15:00");
		s4.registerCourse(c5, t2, "12:00-13:00");
		s5.registerCourse(c5, t1, "13:00-14:00");
		s6.registerCourse(c5, t11, "13:00-14:00");
		s7.registerCourse(c5, t1, "18:00-19:00");
		s8.registerCourse(c5, t11, "14:00-15:00");
		
		
		s1.registerCourse(c6, t5, "16:00-17:00");
		s2.registerCourse(c6, t5, "09:00-10:00");
		s3.registerCourse(c6, t3, "13:00-14:00");
		s4.registerCourse(c6, t1, "10:00-11:00");
		s5.registerCourse(c6, t12, "14:00-15:00");
		s6.registerCourse(c6, t1, "08:00-09:00");
		s7.registerCourse(c6, t3, "20:00-21:00");
		s8.registerCourse(c6, t12, "15:00-16:00");
		
		
		
		
		
		
		
		
		
		
		
		
		s9.registerCourse(c12, t6, "11:00-12:00");
		s10.registerCourse(c12, t7, "20:00-21:00");
		s11.registerCourse(c12, t6, "09:00-10:00");
		s12.registerCourse(c12, t7, "13:00-14:00");
		s13.registerCourse(c12, t8, "15:00-16:00");
		s14.registerCourse(c12, t8, "10:00-11:00");
		s15.registerCourse(c12, t13, "08:00-09:00");
		s16.registerCourse(c12, t13, "09:00-10:00");
		
		
		
		s9.registerCourse(c7, t14, "09:00-10:00");
		s10.registerCourse(c7, t6, "14:00-15:00");
		s11.registerCourse(c7, t6, "20:00-21:00");
		s12.registerCourse(c7, t9, "11:00-12:00");
		s13.registerCourse(c7, t9, "20:00-21:00");
		s14.registerCourse(c7, t8, "16:00-17:00");
		s15.registerCourse(c7, t8, "17:00-18:00");
		s16.registerCourse(c7, t14, "08:00-09:00");
		
		
		
		s9.registerCourse(c8, t10, "20:00-21:00");
		s10.registerCourse(c8, t10, "19:00-20:00");
		s11.registerCourse(c8, t9, "10:00-11:00");
		s12.registerCourse(c8, t9, "08:00-09:00");
		s13.registerCourse(c8, t7, "10:00-11:00");
		s14.registerCourse(c8, t7, "15:00-16:00");
		s15.registerCourse(c8, t13, "10:00-11:00");
		s16.registerCourse(c8, t13, "11:00-12:00");
		
		
		s9.registerCourse(c9, t10, "13:00-14:00");
		s10.registerCourse(c9, t10, "08:00-09:00");
		s11.registerCourse(c9, t8, "18:00-19:00");
		s12.registerCourse(c9, t6, "15:00-16:00");
		s13.registerCourse(c9, t6, "16:00-17:00");
		s14.registerCourse(c9, t8, "11:00-12:00");
		s15.registerCourse(c9, t14, "11:00-12:00");
		s16.registerCourse(c9, t14, "13:00-14:00");
		
		
		s9.registerCourse(c10, t9, "15:00-16:00");
		s10.registerCourse(c10, t9, "16:00-17:00");
		s11.registerCourse(c10, t7, "14:00-15:00");
		s12.registerCourse(c10, t7, "12:00-13:00");
		s13.registerCourse(c10, t6, "13:00-14:00");
		s14.registerCourse(c10, t13, "13:00-14:00");
		s15.registerCourse(c10, t6, "18:00-19:00");
		s16.registerCourse(c10, t13, "14:00-15:00");
		
		
		s9.registerCourse(c11, t10, "16:00-17:00");
		s10.registerCourse(c11, t10, "09:00-10:00");
		s11.registerCourse(c11, t8, "13:00-14:00");
		s12.registerCourse(c11, t6, "10:00-11:00");
		s13.registerCourse(c11, t14, "14:00-15:00");
		s14.registerCourse(c11, t6, "08:00-09:00");
		s15.registerCourse(c11, t8, "20:00-21:00");
		s16.registerCourse(c11, t14, "15:00-16:00");
		
		
		
		}
		catch (CannotRegisterToCourseException e) {
			System.out.println(e);
		}
		
		
		/**
		 * Finally, as this whole process took money out of the students'
		 * bank accounts, I reset all of their balance to 10.000 TL.
		 */
		
	s1.setBalance(10000);
	s2.setBalance(10000);
	s3.setBalance(10000);
	s4.setBalance(10000);
	s5.setBalance(10000);
	s6.setBalance(10000);
	s7.setBalance(10000);
	s8.setBalance(10000);
	s9.setBalance(10000);
	s10.setBalance(10000);
	s11.setBalance(10000);
	s12.setBalance(10000);
	s13.setBalance(10000);
	s14.setBalance(10000);
	s15.setBalance(10000);
	s16.setBalance(10000);
		
	/**
	 * Creates the first frame of the GUI, the LogInFrame.
	 */
		
		LogInFrame frame1= new LogInFrame(ts);
		frame1.setSize(550,350);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
