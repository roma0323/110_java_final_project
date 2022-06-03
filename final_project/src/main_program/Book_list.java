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
        arrayOfBooks.add(new Book("第三本書", "33333",true));
	}
	public void search_book() {
        Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想查詢的書名");
		String search_book_name = scan.nextLine();
		int check = 0;
    	for(int counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//確認書名跟一不一樣
				System.out.printf("查到了：%s\n",arrayOfBooks.get(counter));
				check=1;
			}
		}
    	if(check==0) {
			System.out.printf("館藏無此書\n");
    	}
	}
	public void search_book_ISBM() {
		Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想查詢的ISBM");
		String search_book_name = scan.nextLine();
		int check = 0;
    	for(int counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//確認書名跟一不一樣
				System.out.printf("查到了：%s\n",arrayOfBooks.get(counter));
				check=1;
			}
		}
    	if(check==0) {
			System.out.printf("館藏無此書\n");
    	}
	}
	
	
	public void borrow_book(student student) {
        Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想借的書名");
		String search_book_name = scan.nextLine();
		int check = 0;	//0查無此書 1沒書了 2可借
		int counter = 0;
    	for( counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//確認書名跟書量	
				if(arrayOfBooks.get(counter).book_available) {
					student.memberArrayOfBooks.add(arrayOfBooks.get(counter));
					arrayOfBooks.get(counter).book_available=false;
					int position = student.memberArrayOfBooks.lastIndexOf(arrayOfBooks.get(counter));	//取放進去的位置
					student.memberArrayOfBooks.get(position).setDue_date(java.time.LocalDate.now().plusDays(15));
                    System.out.printf("借書紀錄：%s\n",student.memberArrayOfBooks);
					System.out.printf("借書成功\n請於%s之前還書\n",java.time.LocalDate.now().plusDays(15));
					check=2;
					break;
				}
				else if(arrayOfBooks.get(counter).book_available==false){
					check=1;
					continue;
				}
				break;
			}//if名字一樣end
		}
    	if(check==0) {
			System.out.printf("查無此書\n");
    	}
    	if(check==1) {
        	System.out.printf("此書已被借完\n");
    	}
	}//borrow end
	
	
	public void return_book(student student) {
		Scanner scan = new Scanner(System.in);  
		int check = 0;	//0查無此書 1逾期還書  2正常還 
		System.out.println("長度： "+student.memberArrayOfBooks.size());
		int a = student.memberArrayOfBooks.size();
			System.out.println("請輸入想還的書名");
			String search_book_name = scan.nextLine();
			
			
			ArrayList<Book> found = new ArrayList<>();
			for(Book book : student.memberArrayOfBooks){
			    if(book.getBook_name().equals(search_book_name)){
			        found.add(book);
			        for(int i = 0; i <= this.arrayOfBooks.size(); i++) {
						if(book.ISBM.equals(this.arrayOfBooks.get(i).ISBM)) {			//讓圖館的書availavle=true
							arrayOfBooks.get(i).book_available=true;
							break;
							}
						}
			        if(java.time.LocalDate.now().compareTo(book.due_date)<=15) {		//15天內還
						System.out.printf("還書成功\n");
						check=2;
						break;
			        }	
					else {
						System.out.printf("逾期還書\n");
						check = 1;
						break;
					}	
			    }//if 名字一樣 
			}//for end
			if(check==0) {
				System.out.printf("查無此書\n");
	    	}
			
			student.memberArrayOfBooks.removeAll(found);

		}//return_book end

	
	@Override
	public String toString() {
		return "arrayOfBooks=" + arrayOfBooks  ;
	}
}//end
