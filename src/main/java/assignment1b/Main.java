package assignment1b;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import assignment1.Module;
import assignment1.Student;
import assignment1.courseProgramme;

public class Main {

	public static void main(String[] args) {

		System.out.println("STARTING");
		DateTime sampleDate1 = new DateTime(2013, 1, 15, 0, 0, 0, 0);
		DateTime sampleDate2 = new DateTime(2017, 6, 15, 0, 0, 0, 0);
		
		List<Student> students = new ArrayList();
		students.add(new Student("DanielRegan", 21, new DateTime(1997, 1, 25, 0, 0, 0, 0), 12812));
		students.add(new Student("JohnSmith", 22, new DateTime(1996, 9, 5, 0, 0, 0, 0), 12813));
		students.add(new Student("EndaMahoney", 21, new DateTime(1997, 5, 30, 0, 0, 0, 0), 12814));
		students.add(new Student("JaneCooley", 21, new DateTime(1997, 1, 29, 0, 0, 0, 0), 12815));
		students.add(new Student("JackFitzpatrick", 21, new DateTime(1997, 2, 22, 0, 0, 0, 0), 12816));
		students.add(new Student("JohnnyEnglish", 19, new DateTime(1999, 11, 15, 0, 0, 0, 0), 12817));
		students.add(new Student("BethMccabe", 21, new DateTime(1997, 3, 4, 0, 0, 0, 0), 12818));
		students.add(new Student("JessTravers", 23, new DateTime(1995, 5, 15, 0, 0, 0, 0), 12819));
		students.add(new Student("BillBurr", 20, new DateTime(1998, 6, 1, 0, 0, 0, 0), 12820));
		
		Module softwareEngineering = new Module("Software Engineering", "CT417");
		Module machineLearning = new Module("Machine Learning", "CT475");
		Module artificialIntelligence = new Module("Artificial Intelligence", "CT421");
		Module statistics = new Module("Statistics", "MA417");
		Module informationSystems = new Module("Information Systems", "CT317");
		Module accounting = new Module("Accounting", "BS217");
		Module analytics = new Module("Analytics", "MA455");
		Module german = new Module("German", "Gr422");
		
		List<courseProgramme> courses = new ArrayList();
		courseProgramme computerScience = new courseProgramme("Computer Science", sampleDate1, sampleDate2);
		courseProgramme commerce = new courseProgramme("Commerce", sampleDate1, sampleDate2);
		courseProgramme arts = new courseProgramme("Arts", sampleDate1, sampleDate2);
		courses.add(computerScience);
		courses.add(commerce);
		courses.add(arts);
		
		computerScience.addModule(softwareEngineering);
		computerScience.addModule(machineLearning);
		computerScience.addModule(artificialIntelligence);
		computerScience.addModule(analytics);
		commerce.addModule(statistics);
		commerce.addModule(accounting);
		commerce.addModule(informationSystems);
		arts.addModule(statistics);
		arts.addModule(german);
		arts.addModule(informationSystems);
		
		for(int i=0; i<students.size(); i++){
			courseProgramme course;
			if(i%3==0){
				course = computerScience;
			} else if(i%3==1){
				course = commerce;
			} else{
				course = arts;
			}
			Student s = students.get(i);
			s.enrollForCourse(course);
		}
		
		System.out.println("COURSES AND THEIR MODULES\n===============================");
		for(courseProgramme course: courses){
			System.out.println(course.getCourseName());
			for(Module module: course.getModuleList()){
				System.out.println("\t"+module.getID()+" : "+module.getName());
			}
		}
		
		System.out.println("\n\nSTUDENTS\n===========================");
		for(Student s: students){
			System.out.println(s.getUsername());
			for(courseProgramme c: s.getRegisteredCourses()){
				System.out.println("\t"+c.getCourseName());
				for(Module m:c.getModuleList()){
					System.out.println("\t\t"+m.getID()+" : "+m.getName());
				}
			}
		}
		
		
	}

}
