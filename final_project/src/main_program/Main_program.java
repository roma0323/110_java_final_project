package main_program;
import java.util.ArrayList;
import java.util.Scanner;
public class Main_program {

	public static void main(String[] args) {
        Student_list student_list = new Student_list();
        ArrayList<student> arrayOfStudents = new ArrayList<>();
        arrayOfStudents = student_list.getArrayOfStudents();
        System.out.println(arrayOfStudents.get(0).memberArrayOfBooks);
        arrayOfStudents.get(0).memberArrayOfBooks.add((new Book("亂加的", 3)));
        arrayOfStudents.get(0).memberArrayOfBooks.add((new Book("二亂加二", 2)));
        System.out.println(arrayOfStudents.get(0).memberArrayOfBooks.get(1));
        ArrayList<Book> memberArrayOfBooks = new ArrayList<>();
        Book_list book_list=new Book_list();
        Scanner scan = new Scanner(System.in);  // Create a Scanner object

        int function_mode = 0;
        do{
            System.out.println("\nchoose funtion\n(1)sreach\n(2)register\n(3)login\n(4)quit");
        	function_mode = scan.nextInt();
        	
        	if (function_mode==1) {		//sreach的功能
        		book_list.search_book();
            }//sreach結尾
        	
            
            else if (function_mode==2) {		//register的功能
                int identity_mode=0;
                do {
                    System.out.println("choose identity\n(1)Admin\n(2)Member\n(3)quit");
                	identity_mode = scan.nextInt();
                	if(identity_mode==1) {				// register Admin 
                		System.out.println("register Admin ");
                	}
                	else if(identity_mode==2) {			// register Member 
                        System.out.println("choose identity\n(1)student\n(2)staff\n(3)teacher");
                        int member_identity = scan.nextInt();
                        System.out.println("input your name");
                        String name = scan.nextLine(); 
                        name =  scan.nextLine();
                        System.out.println("input your account");
                        String account = scan.nextLine(); 
                        System.out.println("input your password");
                        String password = scan.nextLine(); 
                        
                        if(member_identity==1) {				
                        	arrayOfStudents = student_list.register_student(name, account, password,memberArrayOfBooks);
                        	break;
                    	}
                        if(member_identity==2) {				
                        	System.out.println("input your staff_id");
                            int staff_id = scan.nextInt(); 
                    	}
                        if(member_identity==3) {				
                        	System.out.println("input your teacher_id");
                            int teacher_id = scan.nextInt(); 
                    	}
					}//register Member end
                	else if(identity_mode==3) {			// quit
                		break;
					}
                	else {
                		System.out.println("請輸入1~3");
                	}
                }while(identity_mode!=3);
            }//register結尾
        	
            else if (function_mode==3) {		//login的功能
            	 int identity_mode= 0;
                 do {
                	 	System.out.println("Login ,choose identity\n(1)Admin\n(2)Member\n(3)quit");
                	 	identity_mode = scan.nextInt();
                 		if(identity_mode==1) {				// login Admin
                 		System.out.println("login Admin ");
                 		}
                 		if(identity_mode==2) {				// login member
                 			System.out.println("choose identity\n(1)student\n(2)staff\n(3)teacher");
                            int member_identity = scan.nextInt();
                        	System.out.println("input your account(Int)");
                            String account = scan.nextLine(); 
                            account = scan.nextLine();
                            System.out.println("input your password(Int)");
                            String password = scan.nextLine(); 
                            int check=0;		//確認登入狀態 0登出1學生2老師3員工
                            int counter = 0;	//第幾個會員資料
                            switch(member_identity) {
	                            case 1 :
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
	                            case 2 :
	                            	
	                            case 3 :
	                            default:	
                            }//switch
                           
                            while(check!=0) {
                        		System.out.println("\nchoose funtion\n(1)borrow\n(2)return\n(3)information\n(4)logout\n");
                                int logined_function = scan.nextInt(); 
                                switch(logined_function) {
                                case 1:		
                                	book_list.borrow_book(arrayOfStudents.get(counter));	//送會員資料過去
                                    System.out.println(arrayOfStudents.get(counter).memberArrayOfBooks);
                                    System.out.println(arrayOfStudents.get(counter));                         
                                	break;
                                case 2:			
                                	//arrayOfStudents.get(0).memberArrayOfBooks.get(1);
                                	break;
                                case 3:					
                                	break;
                                case 4:	
                                	check=0;
                                	break;
                                }
                        	};//登入功能結尾 
                     	}
                 		else {				// quit
                 			System.out.println("請輸入1~3");
                     	}
                	 
                  }while(identity_mode!=3);
            }//login結尾
        	
            else if (function_mode==4) {			//quit
            	System.out.println("程式結束");
            }//quit結尾
        	
            else {
            	System.out.println("請輸入1~4");
            }
        }
        while(function_mode!=4);
           
        
	}
	
	
}//end


			

