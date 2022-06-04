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
		System.out.println("所有書目："+arrayOfBooks);
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
	
	public void borrow_book(member student) {
        Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想借的書名");
		String search_book_name = scan.nextLine();
		int check = 0;	//0查無此書 1沒書了 2可借
		int counter = 0;
    	for( counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(search_book_name.equals(arrayOfBooks.get(counter).book_name)) {			//確認書名
				if(arrayOfBooks.get(counter).book_available) {							//確認可借
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
	
	
	public void return_book(member student) {
		Scanner scan = new Scanner(System.in);  
		int check = 0;	//0查無此書 1逾期還書  2正常還 
		int a = student.memberArrayOfBooks.size();
		
			System.out.println("請輸入想還的書名");
			String search_book_name = scan.nextLine();
			
			for(Book book : student.memberArrayOfBooks){
			    if(book.getBook_name().equals(search_book_name)&&!book.isBook_available()){
			    	book.book_available = false;					//自己這裡的書還回去了 設為false
			        for(int i = 0; i <= this.arrayOfBooks.size(); i++) {
						if(book.ISBM.equals(this.arrayOfBooks.get(i).ISBM)) {			
							arrayOfBooks.get(i).book_available=true;		//讓圖館的書availavle=true
							break;
							}
						}
			        if(java.time.LocalDate.now().compareTo(book.due_date)>=15) {		//15天內還
						System.out.printf("期限內還書還書成功\n");
						check=2;
						break;
			        }	
					else {
						System.out.printf("逾期還書(故意都設逾期 罰金才會有改變\n");
						student.addFine(100);
						check = 1;
						break;
					}	
			    }//if 名字一樣 
			}//for end
			if(check==0) {
				System.out.printf("查無此書\n");
	    	}
			
		}//return_book end
	
	public void add_book() {
		Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想增加的書名");
		String add_book_name = scan.nextLine();
		System.out.println("請輸入想增加的ISBM");
		String add_book_ISBM = scan.nextLine();
		arrayOfBooks.add(new Book(add_book_name, add_book_ISBM,true));
		System.out.println("新增成功");
		System.out.println(arrayOfBooks);
	}
	public void edit_book() {
		Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想修改的書的ISBM");
		String edit_book_ISBM = scan.nextLine();
		System.out.println("請輸入修改後的借閱狀態(True 或 False");
		Boolean edit_book_available = scan.nextBoolean();
		int check = 0;	//確認有無查到書
		for(int counter = 0; counter < arrayOfBooks.size(); counter++) {
			if(edit_book_ISBM.equals(arrayOfBooks.get(counter).ISBM)) {			//確認書名跟一不一樣
				arrayOfBooks.get(counter).book_available = edit_book_available;
				check=1;
			}
		}
    	if(check==0) {
			System.out.printf("館藏無此書\n");
    	}
		System.out.println("修改成功");
		System.out.println(arrayOfBooks);
	}
	
	public void delete_book() {
		Scanner scan = new Scanner(System.in);  
		System.out.println("請輸入想刪除的書的ISBM");
		String delete_book_ISBM = scan.nextLine();
		int check = 0;	//確認有無查到書
		ArrayList<Book> found = new ArrayList<>();
		for(Book book : arrayOfBooks){
			  if(book.getISBM().equals(delete_book_ISBM)){
			    	found.add(book);
			    	check=1;
			   }
		}	    
		arrayOfBooks.removeAll(found);
    	if(check==0) {
			System.out.printf("館藏無此書\n");
    	}
		System.out.println("修改成功");
		System.out.println(arrayOfBooks);
	}
	@Override
	public String toString() {
		return "arrayOfBooks=" + arrayOfBooks  ;
	}
}//end
