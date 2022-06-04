package main_program;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main_program {

	public static void main(String[] args) {
		
		
        ArrayList<Book> LibraryArrayOfBooks = new ArrayList<>();		//圖書館書的arraylist
        Book_list book_list=new Book_list(LibraryArrayOfBooks);
        book_list.addArrayOfBooks( new Book ("testbook", "111",true));
        book_list.addArrayOfBooks(new Book ("testbook", "222",true));
        book_list.addArrayOfBooks(new Book ("third", "333",true));
        System.out.println( "圖書館預設書"+book_list.getArrayOfBooks());

        ArrayList<student> arrayOfStudents = new ArrayList<>();
        ArrayList<Book> memberArrayOfBooks = new ArrayList<>();		//會員自己的借書名單  因為不能是null
        Student_list student_list =new Student_list(arrayOfStudents);
        student_list.addArrayOfStudents(new student ("roger", "1", "1", "110403519",memberArrayOfBooks));
        student_list.addArrayOfStudents(new student ("roma", "2", "2", "110403520",memberArrayOfBooks));
        System.out.println( "學生預設名單"+student_list.getArrayOfStudents());
       
        ArrayList<admin> arrayOfAdmins = new ArrayList<>();		//管理員資料的arraylist
        admin_list admin_list = new admin_list(arrayOfAdmins);
        admin_list.addArrayOfAdmins(new admin (	"admin1", "11", "11") );
        admin_list.addArrayOfAdmins(new admin (	"admin2", "22", "22") );
        System.out.println( "管理員預設名單"+admin_list. getArrayOfAdmins());
        
        ArrayList<teacher>arrayOfTeachers = new  ArrayList<>();
        teacher_list teacher_list = new teacher_list(arrayOfTeachers);

		
        Scanner scan = new Scanner(System.in);  
        String  function_mode = "0";
        do{
            System.out.println("\nchoose funtion\n(1)sreach\n(2)register\n(3)login\n(4)quit");
        	function_mode = scan.nextLine();
        	switch(function_mode) {
        	case "1" :			//sreach的功能
        		book_list.search_book();
        		break;
        	case "2" :			//register的功能
        		String member_identity="0";
        		outerloop:				//註冊完後break到這	
        		while(true){
                	System.out.println("register choose identity\n(1)student\n(2)teacher\n(3)staff\n(4)quit");
                    member_identity = scan.nextLine();
                    if(member_identity.equals("4")) {
                    	break;
                    }
                    else if(!member_identity.equals("1")&&!member_identity.equals("2")&&!member_identity.equals("3")) {
                    	System.out.println("請輸入1~4");
                    	continue;
                    }
                    System.out.println("input your name");
                    String name = scan.nextLine(); 
                    System.out.println("input your account");
                    String account = scan.nextLine(); 
                    System.out.println("input your password");
                    String password = scan.nextLine(); 
                	switch(member_identity) {
                	case "1" :
                		arrayOfStudents = student_list.register_student(name, account, password,memberArrayOfBooks);//空借書名單  因為不能是null
                        System.out.println("學生名單"+arrayOfStudents);
                		break outerloop;			//可break到指定的loop層級
                	case "2" :
                		arrayOfTeachers = teacher_list.register_teacher(name, account, password,memberArrayOfBooks);//空借書名單  因為不能是null
                        System.out.println("老師名單"+arrayOfTeachers);
                		break outerloop;			//可break到指定的loop層級
                		
                	case "3" :
                		break;
                	}
                }
        		break;
        		
        	case "3" :			//login的功能
        		 String  identity_mode= "0";
         		outerloop:		//登出後break到這
                 do {
                	 	System.out.println("Login ,choose identity\n(1)Admin\n(2)Member\n(3)quit");
                	 	identity_mode = scan.nextLine();
                	 	switch(identity_mode) {
                	 	case "1" :
                			// login Admin
                 			System.out.println("input your account(Int)");
                            String account = scan.nextLine(); 
                            System.out.println("input your password(Int)");
                            String password = scan.nextLine();
                            int counter = 0;	//紀錄是第幾個管理員資料
                            int check=0;		//確認登入是否成功
                            for(counter = 0; counter < arrayOfAdmins.size(); counter++) {
                        		if(account.equals(arrayOfAdmins.get(counter).account)&&password.equals(arrayOfAdmins.get(counter).password)) {			//確認帳號密碼一不一樣
    		        				System.out.printf("登入成功："+arrayOfAdmins.get(counter)+"\n");
    		        				check=1;
    		        				break;
    		        			}
    		        		}
                        	if(check==0) {
                        		System.out.printf("帳號密碼錯誤\n");
                        	}
                        	while(check!=0) {
                        		System.out.println("\nchoose funtion\n(1)serach\n(2)add book\n(3)edit book\n(4)delete\n(5)logout\n");
                                String  logined_function = scan.nextLine(); 
                                switch(logined_function) {
                                case "1":		
                                	book_list.search_book();                                	break;
                                case "2":			
                                	book_list.add_book();	
                                	break;
                                case "3":		
                                	book_list.edit_book();	
                                	break;
                                case "4":	
                                	book_list.delete_book();	
                                	break;
                                case "5":	
                                	check=0;
                                	break outerloop;		//可break到指定的loop層級
                                }
                        	};//admin登入功能結尾 
                	 		break;
                	 	case "2" :
                	 		// login member
                 			System.out.println("choose identity\n(1)student\n(2)teacher\n(3)staff");
                 			member_identity = scan.nextLine();		//確認登入狀態 1學生2老師3員工
                        	System.out.println("input your account(Int)");
                             account = scan.nextLine(); 
                            System.out.println("input your password(Int)");
                            password = scan.nextLine(); 
                            check=0;		//紀錄是確認登入是否成功
                            counter = 0;	//第幾個會員資料
                            switch(member_identity) {
	                            case "1" :				//1學生
	                            	for(counter = 0; counter < arrayOfStudents.size(); counter++) {
		                        		if(account.equals(arrayOfStudents.get(counter).account)&&password.equals(arrayOfStudents.get(counter).password)) {			//確認帳號密碼一不一樣
		    		        				System.out.printf("登入成功："+arrayOfStudents.get(counter)+"\n");
		    		        				check=1;
		    		        				break;
		    		        			}
		    		        		}
		                        	if(check==0) {
		                        		System.out.printf("帳號密碼錯誤\n");
		                        	}
		                        	break;
	                            case "2" :		//2老師
	                            	for(counter = 0; counter < arrayOfTeachers.size(); counter++) {
		                        		if(account.equals(arrayOfTeachers.get(counter).account)&&password.equals(arrayOfTeachers.get(counter).password)) {			//確認帳號密碼一不一樣
		    		        				System.out.printf("登入成功："+arrayOfTeachers.get(counter)+"\n");
		    		        				check=2;
		    		        				break;
		    		        			}
		    		        		}
		                        	if(check==0) {
		                        		System.out.printf("帳號密碼錯誤\n");
		                        	}
	                            case "3" :		//3員工
	                            default:	
                            }//switch
                           
                            while(check!=0) {
                        		System.out.println("\nchoose funtion\n(1)serach\n(2)borrow\n(3)return\n(4)information\n(5)logout\n");
                                String  logined_function = scan.nextLine(); 
                                switch(logined_function) {
                                case "1":		
                                	book_list.search_book();                                	break;
                                case "2":	
                                	if(check==1) {
                                    	book_list.borrow_book(arrayOfStudents.get(counter));	//送學生資料過去
                                	}	
                                	if(check==2) {
                                		book_list.borrow_book(arrayOfTeachers.get(counter));	//送老師資料過去
                                	}
                                	break;
                                case "3":	
                                	if(check==1) {
                                    	book_list.return_book(arrayOfStudents.get(counter));//送學生資料過去
                                	}	
                                	if(check==2) {
                                    	book_list.return_book(arrayOfTeachers.get(counter));//送老師資料過去
                                	}
                                	break;
                                case "4":	
                                	if(check==1) {
                                        System.out.printf("個人資料：%s\n",arrayOfStudents.get(counter));
                                	}	
                                	if(check==2) {
                                        System.out.printf("個人資料：%s\n",arrayOfTeachers.get(counter));
                                	}
                                	break;
                                case "5":	
                                	check=0;
                                	break outerloop;		//可break到指定的loop層級
                                default:
                                	System.out.println("輸入1~5");
                                }
                            };//member登入功能結尾     
                	 		break;
                	 	case "3" :
                	 		break;
                	 	default:
                	 		System.out.println("請輸入1~3");
                	 		continue;
                	 	}	
                  }while(!identity_mode.equals("3"));
        		break;
        		
        	case "4" :
        		System.out.println("程式結束");
        		break;
        		
        	default:
        		System.out.println("請輸入1~4");
        		break;
        	
        	}
  
        }
        while(!function_mode.equals("4"));
           
        
	}
}//end


			

