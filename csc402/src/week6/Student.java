package week6;
/*
 * The Student class will have 3 String type properties:
 * 		firstName
 * 		lastName
 * 		studentId
 */

//public class Student implements Comparable<Object> {
public class Student implements Comparable<Student> {
	private String studentId;
	private String firstName;
	private String lastName;
	
	public Student(){};
	
	public Student(String id, String fName, String lName){
		this.studentId = id;
		this.firstName = fName;
		this.lastName = lName;
	}
	
	
/*	private String getStudentId(){
		return this.studentId;
	}

	public int compareTo(Object object){
		Student student = (Student)object;
//		System.out.println(student.getStudentId());
//		System.out.println(this.getStudentId());
		return student.getStudentId().compareTo(this.getStudentId());
	}	
*/	
	public int compareTo(Student other){
		int compare = studentId.compareTo(other.studentId);
		
		if(compare != 0){
			return compare;
		}
		compare = firstName.compareTo(other.firstName);
		if(compare != 0){
			return compare;
		}
		return compare = lastName.compareTo(other.lastName);
	}
	
	public String toString(){
		return "Students [firstName=" + this.firstName + ", lastName=" + this.lastName + ", studentId=" + this.studentId + "]";
	}
	
}
