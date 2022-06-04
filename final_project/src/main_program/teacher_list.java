package main_program;

import java.util.ArrayList;
import java.util.Scanner;

public class teacher_list {
	private  ArrayList<teacher> arrayOfTeachers ;
    private teacher teacher;
    private ArrayList<Book> defaultBook = new ArrayList<>();	//空借書名單  因為不能是null
    
	public teacher_list(ArrayList<teacher> arrayOfStudents ) {
		setArrayOfTeachers( arrayOfStudents);
	}
	
	public void addArrayOfTeachers(student student) {
		this.arrayOfTeachers.add(teacher);
	}
	
	public ArrayList<teacher> getArrayOfTeachers() {
		return arrayOfTeachers;
	}
	public void setArrayOfTeachers(ArrayList<teacher> arrayOfTeachers) {
		this.arrayOfTeachers = arrayOfTeachers;
	}
	public teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(teacher teacher) {
		this.teacher = teacher;
	}

	public ArrayList register_teacher(String name, String account, String password,ArrayList<Book> memberArrayOfBooks) {//
        Scanner scan = new Scanner(System.in);  
        System.out.println("input your teacher_id");
    	String teacher_id = scan.nextLine();
    	arrayOfTeachers.add(new teacher(name, account, password, memberArrayOfBooks,teacher_id));
        System.out.println("register success");
        return arrayOfTeachers;
	}
}
