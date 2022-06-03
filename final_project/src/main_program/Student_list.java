package main_program;
import java.util.ArrayList;
import java.util.Scanner;
public class Student_list {
    private ArrayList<student> arrayOfStudents = new ArrayList<>();
    private ArrayList<Book> defaultBook = new ArrayList<>();	//空借書名單
	public Student_list() {
		arrayOfStudents.add(new student("roger", "11", "11", "110403519",defaultBook));
		arrayOfStudents.add(new student("roma", "22", "22", "110403520",defaultBook));
		
	}
	
	public ArrayList<student> getArrayOfStudents() {
		return arrayOfStudents;
	}

	public void setArrayOfStudents(ArrayList<student> arrayOfStudents) {
		this.arrayOfStudents = arrayOfStudents;
	}

	public ArrayList register_student(String name, String account, String password,ArrayList<Book> memberArrayOfBooks) {
        Scanner scan = new Scanner(System.in);  
        System.out.println("input your student_id(Int)");
    	String student_id = scan.nextLine();
        arrayOfStudents.add(new student(name, account, password, student_id,memberArrayOfBooks));
        System.out.println("register success");
        return arrayOfStudents;
	}
}
