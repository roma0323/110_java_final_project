package main_program;

import java.util.ArrayList;
import java.util.Scanner;

public class teacher extends member{
	private String teacher_id;
	
	public teacher(String name, String account, String password, ArrayList<Book> memberArrayOfBooks,String teacher_id) {
		super(name, account, password, memberArrayOfBooks);
		setTeacher_id( teacher_id) ;
	}

	

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	@Override
	public String toString() {
		return String.format("\n%s%s%s", super.toString(),", teacher_id= ",teacher_id);
	}
}
