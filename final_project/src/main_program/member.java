package main_program;

import java.util.ArrayList;

public class member {
	protected String account ;
	protected String password ;
	protected String name ;
	protected ArrayList<Book> memberArrayOfBooks ;

	public member(String name,String account,String password,ArrayList<Book> memberArrayOfBooks) {
		setName( name);
		setAccount( account);
		setPassword( password);
		setMemberArrayOfBooks(memberArrayOfBooks);
	}
	
	public ArrayList<Book> getMemberArrayOfBooks() {
		return memberArrayOfBooks;
	}

	public void setMemberArrayOfBooks(ArrayList<Book> memberArrayOfBooks) {
		this.memberArrayOfBooks = memberArrayOfBooks;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "account=" + account + ", password=" + password + ", name=" + name + ", memberArrayOfBooks="
				+ memberArrayOfBooks;
	}
	
	
}
