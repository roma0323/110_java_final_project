package main_program;

import java.util.ArrayList;
import java.util.Scanner;

public  class student extends member {
	private String student_id;
	
	//ArrayList<student> arrayOfStudents = Student_list.getArrayOfStudents();
	public student( String name,String account,String password,String student_id,ArrayList<Book> memberArrayOfBooks) {//
		super(name,account,password, memberArrayOfBooks);//
		setStudent_id( student_id) ;
	}
	
	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return String.format("\n%s%s%s", super.toString(),", student_id= ",student_id);
	}
	
	
}
