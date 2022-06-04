package main_program;
import java.time.LocalDate;
import java.time.LocalDateTime;  
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Book_list {
	private ArrayList<Book> arrayOfBooks ;
	private Book book;
	
	public Book_list(ArrayList<Book> arrayOfBooks) {	
		setArrayOfBooks(arrayOfBooks);
	}
	
	public void addArrayOfBooks(Book book) {
		this.arrayOfBooks.add(book);
	}
	public ArrayList<Book> getArrayOfBooks() {
		return arrayOfBooks;
	}

	public void setArrayOfBooks(ArrayList<Book> arrayOfBooks) {
		this.arrayOfBooks = arrayOfBooks;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void search_book() {
        Scanner scan = new Scanner(System.in);  
		System.out.println("�Ҧ��ѥءG"+arrayOfBooks);
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
	
	public void borrow_book(member student) {
        Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�ɪ��ѦW");
		String search_book_name = scan.nextLine();
		int check = 0;	//0�d�L���� 1�S�ѤF 2�i��
		int counter = 0;
    	for( counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//�T�{�ѦW
				if(arrayOfBooks.get(counter).book_available) {							//�T�{�i��
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
	
	
	public void return_book(member student) {
		Scanner scan = new Scanner(System.in);  
		int check = 0;	//0�d�L���� 1�O���ٮ�  2���`�� 
		int a = student.memberArrayOfBooks.size();
		
			System.out.println("�п�J�Q�٪��ѦW");
			String search_book_name = scan.nextLine();
			
			for(Book book : student.memberArrayOfBooks){
			    if(book.getBook_name().equals(search_book_name)&&!book.isBook_available()){
			    	book.book_available = false;					//�ۤv�o�̪����٦^�h�F �]��false
			        for(int i = 0; i <= this.arrayOfBooks.size(); i++) {
						if(book.ISBM.equals(this.arrayOfBooks.get(i).ISBM)) {			
							arrayOfBooks.get(i).book_available=true;		//�����]����availavle=true
							break;
							}
						}
			        if(java.time.LocalDate.now().compareTo(book.due_date)>=15) {		//15�Ѥ���
						System.out.printf("�������ٮ��ٮѦ��\\n");
						check=2;
						break;
			        }	
					else {
						System.out.printf("�O���ٮ�(�G�N���]�O�� �@���~�|������\n");
						student.addFine(100);
						check = 1;
						break;
					}	
			    }//if �W�r�@�� 
			}//for end
			if(check==0) {
				System.out.printf("�d�L����\n");
	    	}
			
		}//return_book end
	
	public void add_book() {
		Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�W�[���ѦW");
		String add_book_name = scan.nextLine();
		System.out.println("�п�J�Q�W�[��ISBM");
		String add_book_ISBM = scan.nextLine();
		arrayOfBooks.add(new Book(add_book_name, add_book_ISBM,true));
		System.out.println("�s�W���\");
		System.out.println(arrayOfBooks);
	}
	public void edit_book() {
		Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�ק諸�Ѫ�ISBM");
		String edit_book_ISBM = scan.nextLine();
		System.out.println("�п�J�ק�᪺�ɾ\���A(True �� False");
		Boolean edit_book_available = scan.nextBoolean();
		int check = 0;	//�T�{���L�d���
		for(int counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(edit_book_ISBM.equals(arrayOfBooks.get(counter).ISBM)) {			//�T�{�ѦW��@���@��
				arrayOfBooks.get(counter).book_available = edit_book_available;
				check=1;
			}
		}
    	if(check==0) {
			System.out.printf("�]�õL����\n");
    	}
		System.out.println("�ק令�\");
		System.out.println(arrayOfBooks);
	}
	
	public void delete_book() {
		Scanner scan = new Scanner(System.in);  
		System.out.println("�п�J�Q�R�����Ѫ�ISBM");
		String delete_book_ISBM = scan.nextLine();
		int check = 0;	//�T�{���L�d���
		ArrayList<Book> found = new ArrayList<>();
		for(Book book : arrayOfBooks){
			  if(book.getISBM().equals(delete_book_ISBM)){
			    	found.add(book);
			    	check=1;
			   }
		}	    
		arrayOfBooks.removeAll(found);
    	if(check==0) {
			System.out.printf("�]�õL����\n");
    	}
		System.out.println("�ק令�\");
		System.out.println(arrayOfBooks);
	}
	@Override
	public String toString() {
		return "arrayOfBooks=" + arrayOfBooks  ;
	}
}//end
