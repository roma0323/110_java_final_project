package main_program;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;

public class Book {
	public String book_name;
	public int book_amount;
	public Book(String book_name,int book_amount) {
		setBook_name( book_name);
		setBook_amount( book_amount);
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_amount() {
		return book_amount;
	}
	public void setBook_amount(int book_amount) {
		this.book_amount = book_amount;
	}
	@Override
	public String toString() {
		return "book_name=" + book_name + ", book_amount=" + book_amount ;
	}
	
}
