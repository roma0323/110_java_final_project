package main_program;
import java.time.LocalDateTime;  
import java.util.ArrayList;
import java.util.Scanner;

public class Book_list {
	ArrayList<Book> arrayOfBooks = new ArrayList<>();
	public Book_list() {
        arrayOfBooks.add(new Book("�Ĥ@����", 3));
        arrayOfBooks.add(new Book("�ĤG����", 1));
	}
	public int search_book() {
        Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�d�ߪ��ѦW");
		String search_book_name = scan.nextLine();
		int check = 0;
    	for(int counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//�T�{�ѦW��@���@��
				System.out.printf("�d��F�A�ѤU%d��\n",arrayOfBooks.get(counter).book_amount);
				check=1;
			}
		}
    	if(check==0) {
			System.out.printf("�d�L����\n");
    	}
    	return check;
	}
	
	public void borrow_book(student student) {
        Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�ɪ��ѦW");
		String search_book_name = scan.nextLine();
		int check = 0;	//0�d�L���� 1�S�ѤF 2�i��
		int counter = 0;
    	for( counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//�T�{�ѦW��Ѷq	
				if(arrayOfBooks.get(counter).book_amount>0) {
					arrayOfBooks.get(counter).book_amount--;
					student.memberArrayOfBooks.add(arrayOfBooks.get(counter));
					
					
			        
					System.out.printf("�ɮѦ��\\n�Щ�%s���e�ٮ�\n",java.time.LocalDate.now().plusDays(15));
					check=2;
					break;
				}
				System.out.printf("�Ѥw�Q�ɧ�\n");
				check=1;
				break;
			}
		}
    	if(check==0) {
			System.out.printf("�d�L����\n");
    	}
	}//borrow end
	
	
	public void return_book(student student) {
		Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�٪��ѦW");
		String search_book_name = scan.nextLine();
		int check = 0;	//0�d�L���� 1�S�ѤF 2�i��
		int counter = 0;
    	for( counter = 0; counter < student.memberArrayOfBooks.size(); counter++) {
			if(search_book_name.equals(student.memberArrayOfBooks.get(counter).book_name)) {			//�T�{�ѦW��Ѷq	
				if(student.memberArrayOfBooks.get(counter).book_amount>0) {
					student.memberArrayOfBooks.add(arrayOfBooks.get(counter));
					arrayOfBooks.get(counter).book_amount--;
					
					
			        
					System.out.printf("�ɮѦ��\\n�Щ�%s���e�ٮ�\n",java.time.LocalDate.now().plusDays(15));
					check=2;
					break;
				}
				System.out.printf("�Ѥw�Q�ɧ�\n");
				check=1;
				break;
			}
		}
    	if(check==0) {
			System.out.printf("�d�L����\n");
    	}
    	
	}
	@Override
	public String toString() {
		return "arrayOfBooks=" + arrayOfBooks  ;
	}
}//end
