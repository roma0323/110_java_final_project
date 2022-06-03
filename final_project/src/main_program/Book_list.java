package main_program;
import java.time.LocalDate;
import java.time.LocalDateTime;  
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Book_list {
	ArrayList<Book> arrayOfBooks = new ArrayList<>();
	public Book_list() {
        arrayOfBooks.add(new Book("testbook", "11111",true));
        arrayOfBooks.add(new Book("testbook", "22222",true));
        arrayOfBooks.add(new Book("�ĤT����", "33333",true));
	}
	public void search_book() {
        Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�d�ߪ��ѦW");
		String search_book_name = scan.nextLine();
		int check = 0;
    	for(int counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//�T�{�ѦW��@���@��
				System.out.printf("�d��F�G%s\n",arrayOfBooks.get(counter));
				check=1;
			}
		}
    	if(check==0) {
			System.out.printf("�]�õL����\n");
    	}
	}
	public void search_book_ISBM() {
		Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�d�ߪ�ISBM");
		String search_book_name = scan.nextLine();
		int check = 0;
    	for(int counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//�T�{�ѦW��@���@��
				System.out.printf("�d��F�G%s\n",arrayOfBooks.get(counter));
				check=1;
			}
		}
    	if(check==0) {
			System.out.printf("�]�õL����\n");
    	}
	}
	
	
	public void borrow_book(student student) {
        Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�ɪ��ѦW");
		String search_book_name = scan.nextLine();
		int check = 0;	//0�d�L���� 1�S�ѤF 2�i��
		int counter = 0;
    	for( counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//�T�{�ѦW��Ѷq	
				if(arrayOfBooks.get(counter).book_available) {
					student.memberArrayOfBooks.add(arrayOfBooks.get(counter));
					arrayOfBooks.get(counter).book_available=false;
					int position = student.memberArrayOfBooks.lastIndexOf(arrayOfBooks.get(counter));	//����i�h����m
					student.memberArrayOfBooks.get(position).setDue_date(java.time.LocalDate.now().plusDays(15));
                    System.out.printf("�ɮѬ����G%s\n",student.memberArrayOfBooks);
					System.out.printf("�ɮѦ��\\n�Щ�%s���e�ٮ�\n",java.time.LocalDate.now().plusDays(15));
					check=2;
					break;
				}
				else if(arrayOfBooks.get(counter).book_available==false){
					check=1;
					continue;
				}
				break;
			}//if�W�r�@��end
		}
    	if(check==0) {
			System.out.printf("�d�L����\n");
    	}
    	if(check==1) {
        	System.out.printf("���Ѥw�Q�ɧ�\n");
    	}
	}//borrow end
	
	
	public void return_book(student student) {
		Scanner scan = new Scanner(System.in);  
		int check = 0;	//0�d�L���� 1�O���ٮ�  2���`�� 
		System.out.println("���סG "+student.memberArrayOfBooks.size());
		int a = student.memberArrayOfBooks.size();
			System.out.println("�п�J�Q�٪��ѦW");
			String search_book_name = scan.nextLine();
			
			
			ArrayList<Book> found = new ArrayList<>();
			for(Book book : student.memberArrayOfBooks){
			    if(book.getBook_name().equals(search_book_name)){
			        found.add(book);
			        for(int i = 0; i <= this.arrayOfBooks.size(); i++) {
						if(book.ISBM.equals(this.arrayOfBooks.get(i).ISBM)) {			//�����]����availavle=true
							arrayOfBooks.get(i).book_available=true;
							break;
							}
						}
			        if(java.time.LocalDate.now().compareTo(book.due_date)<=15) {		//15�Ѥ���
						System.out.printf("�ٮѦ��\\n");
						check=2;
						break;
			        }	
					else {
						System.out.printf("�O���ٮ�\n");
						check = 1;
						break;
					}	
			    }//if �W�r�@�� 
			}//for end
			if(check==0) {
				System.out.printf("�d�L����\n");
	    	}
			
			student.memberArrayOfBooks.removeAll(found);

		}//return_book end

	
	@Override
	public String toString() {
		return "arrayOfBooks=" + arrayOfBooks  ;
	}
}//end
