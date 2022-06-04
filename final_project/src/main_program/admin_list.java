package main_program;

import java.util.ArrayList;
import java.util.Scanner;

public class admin_list {
	private ArrayList<admin> arrayOfAdmins ;
	protected admin admin;
	public admin_list(ArrayList<admin> arrayOfAdmins) {
		setArrayOfAdmins(arrayOfAdmins);
		
	}
	public void addArrayOfAdmins(admin admin) {
		this.arrayOfAdmins.add(admin);
	}
	public admin getAdmin() {
		return admin;
	}

	public void setAdmin(admin admin) {
		this.admin = admin;
	}

	public ArrayList<admin> getArrayOfAdmins() {
		return arrayOfAdmins;
	}
	public void setArrayOfAdmins(ArrayList<admin> arrayOfAdmins) {
		this.arrayOfAdmins = arrayOfAdmins;
	}
//	public ArrayList register_admin(String name, String account, String password,ArrayList<Book> memberArrayOfBooks) {
//        Scanner scan = new Scanner(System.in);  
//        System.out.println("input your student_id(Int)");
//    	String student_id = scan.nextLine();
//        arrayOfStudents.add(new student(name, account, password, student_id,memberArrayOfBooks));
//        System.out.println("register success");
//        return arrayOfStudents;
//	}
}
