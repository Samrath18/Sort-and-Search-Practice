package sortAndSearch;

/*
 * Samrath Singh
 * ICS4UO-B
 * Sort and Search
 * 2023/04/17
 * Object class of the program.
 */

public class Student {

    //The Student class has three fields
	public String studentID;
	public String name;
	public String grade;
	
    //The Student class has two constructor
	public Student() {
	}
	public Student(String studentID, String name, String grade) {
		this.studentID = studentID;
		this.name = name;
		this.grade = grade;
	}

	//Get and set methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getstudentID() {
		return studentID;
	}
	public void setstudentID(String studentID) {
		this.studentID = studentID;
	}
}
