package main_program;
import java.util.ArrayList;
import java.util.Scanner;
public class Student_list {
    private  ArrayList<student> arrayOfStudents ;
    private student student;
    private ArrayList<Book> defaultBook = new ArrayList<>();	//空借書名單  因為不能是null
    
	public Student_list(ArrayList<student> arrayOfStudents ) {
		setArrayOfStudents( arrayOfStudents);
	}
	
	public void addArrayOfStudents(student student) {
		this.arrayOfStudents.add(student);
	}
	public student getStudent() {
		return student;
	}

	public void setStudent(student student) {
		this.student = student;
	}

	public  ArrayList<student> getArrayOfStudents() {
		return arrayOfStudents;
	}

	public void setArrayOfStudents(ArrayList<student> arrayOfStudents) {
		this.arrayOfStudents = arrayOfStudents;
	}

	public ArrayList register_student(String name, String account, String password,ArrayList<Book> memberArrayOfBooks) {//
        Scanner scan = new Scanner(System.in);  
        System.out.println("input your student_id(Int)");
    	String student_id = scan.nextLine();
        arrayOfStudents.add(new student(name, account, password, student_id,memberArrayOfBooks));
        System.out.println("register success");
        return arrayOfStudents;
	}
}
