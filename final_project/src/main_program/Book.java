package main_program;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Book {
	public String book_name;
	public String ISBM;
	public boolean book_available;
	public LocalDate due_date;
	public Book(String book_name,String ISBM,boolean book_available) {
		setBook_name( book_name);
		setISBM( ISBM);
		setBook_available( book_available);
	}
	public boolean isBook_available() {
		return book_available;
	}
	public void setBook_available(boolean book_available) {
		this.book_available = book_available;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getISBM() {
		return ISBM;
	}
	public void setISBM(String iSBM) {
		ISBM = iSBM;
	}
	@Override
	public String toString() {
		return "\n"+"book_name=" + book_name + ", ISBM=" + ISBM + ", book_available=" + book_available + ", due_date="
				+ due_date ;
	}
	
	
	
}
