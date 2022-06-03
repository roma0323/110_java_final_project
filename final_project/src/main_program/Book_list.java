package main_program;
import java.time.LocalDateTime;  
import java.util.ArrayList;
import java.util.Scanner;

public class Book_list {
	ArrayList<Book> arrayOfBooks = new ArrayList<>();
	public Book_list() {
        arrayOfBooks.add(new Book("第一本書", 3));
        arrayOfBooks.add(new Book("第二本書", 1));
	}
	public int search_book() {
        Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想查詢的書名");
		String search_book_name = scan.nextLine();
		int check = 0;
    	for(int counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//確認書名跟一不一樣
				System.out.printf("查到了，剩下%d本\n",arrayOfBooks.get(counter).book_amount);
				check=1;
			}
		}
    	if(check==0) {
			System.out.printf("查無此書\n");
    	}
    	return check;
	}
	
	public void borrow_book(student student) {
        Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想借的書名");
		String search_book_name = scan.nextLine();
		int check = 0;	//0查無此書 1沒書了 2可借
		int counter = 0;
    	for( counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//確認書名跟書量	
				if(arrayOfBooks.get(counter).book_amount>0) {
					arrayOfBooks.get(counter).book_amount--;
					student.memberArrayOfBooks.add(arrayOfBooks.get(counter));
					
					
			        
					System.out.printf("借書成功\n請於%s之前還書\n",java.time.LocalDate.now().plusDays(15));
					check=2;
					break;
				}
				System.out.printf("書已被借完\n");
				check=1;
				break;
			}
		}
    	if(check==0) {
			System.out.printf("查無此書\n");
    	}
	}//borrow end
	
	
	public void return_book(student student) {
		Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想還的書名");
		String search_book_name = scan.nextLine();
		int check = 0;	//0查無此書 1沒書了 2可借
		int counter = 0;
    	for( counter = 0; counter < student.memberArrayOfBooks.size(); counter++) {
			if(search_book_name.equals(student.memberArrayOfBooks.get(counter).book_name)) {			//確認書名跟書量	
				if(student.memberArrayOfBooks.get(counter).book_amount>0) {
					student.memberArrayOfBooks.add(arrayOfBooks.get(counter));
					arrayOfBooks.get(counter).book_amount--;
					
					
			        
					System.out.printf("借書成功\n請於%s之前還書\n",java.time.LocalDate.now().plusDays(15));
					check=2;
					break;
				}
				System.out.printf("書已被借完\n");
				check=1;
				break;
			}
		}
    	if(check==0) {
			System.out.printf("查無此書\n");
    	}
    	
	}
	@Override
	public String toString() {
		return "arrayOfBooks=" + arrayOfBooks  ;
	}
}//end
