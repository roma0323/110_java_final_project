package main_program;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main_program {

	public static void main(String[] args) {
		
		
        ArrayList<Book> LibraryArrayOfBooks = new ArrayList<>();		//�Ϯ��]�Ѫ�arraylist
        Book_list book_list=new Book_list(LibraryArrayOfBooks);
        book_list.addArrayOfBooks( new Book ("testbook", "111",true));
        book_list.addArrayOfBooks(new Book ("testbook", "222",true));
        book_list.addArrayOfBooks(new Book ("third", "333",true));
        System.out.println( "�Ϯ��]�w�]��"+book_list.getArrayOfBooks());

        ArrayList<student> arrayOfStudents = new ArrayList<>();
        ArrayList<Book> memberArrayOfBooks = new ArrayList<>();		//�|���ۤv���ɮѦW��  �]������Onull
        Student_list student_list =new Student_list(arrayOfStudents);
        student_list.addArrayOfStudents(new student ("roger", "1", "1", "110403519",memberArrayOfBooks));
        student_list.addArrayOfStudents(new student ("roma", "2", "2", "110403520",memberArrayOfBooks));
        System.out.println( "�ǥ͹w�]�W��"+student_list.getArrayOfStudents());
       
        ArrayList<admin> arrayOfAdmins = new ArrayList<>();		//�޲z����ƪ�arraylist
        admin_list admin_list = new admin_list(arrayOfAdmins);
        admin_list.addArrayOfAdmins(new admin (	"admin1", "11", "11") );
        admin_list.addArrayOfAdmins(new admin (	"admin2", "22", "22") );
        System.out.println( "�޲z���w�]�W��"+admin_list. getArrayOfAdmins());
        
        ArrayList<teacher>arrayOfTeachers = new  ArrayList<>();
        teacher_list teacher_list = new teacher_list(arrayOfTeachers);

		
        Scanner scan = new Scanner(System.in);  
        String  function_mode = "0";
        do{
            System.out.println("\nchoose funtion\n(1)sreach\n(2)register\n(3)login\n(4)quit");
        	function_mode = scan.nextLine();
        	switch(function_mode) {
        	case "1" :			//sreach���\��
        		book_list.search_book();
        		break;
        	case "2" :			//register���\��
        		String member_identity="0";
        		outerloop:				//���U����break��o	
        		while(true){
                	System.out.println("register choose identity\n(1)student\n(2)teacher\n(3)staff\n(4)quit");
                    member_identity = scan.nextLine();
                    if(member_identity.equals("4")) {
                    	break;
                    }
                    else if(!member_identity.equals("1")&&!member_identity.equals("2")&&!member_identity.equals("3")) {
                    	System.out.println("�п�J1~4");
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
                		arrayOfStudents = student_list.register_student(name, account, password,memberArrayOfBooks);//�ŭɮѦW��  �]������Onull
                        System.out.println("�ǥͦW��"+arrayOfStudents);
                		break outerloop;			//�ibreak����w��loop�h��
                	case "2" :
                		arrayOfTeachers = teacher_list.register_teacher(name, account, password,memberArrayOfBooks);//�ŭɮѦW��  �]������Onull
                        System.out.println("�Ѯv�W��"+arrayOfTeachers);
                		break outerloop;			//�ibreak����w��loop�h��
                		
                	case "3" :
                		break;
                	}
                }
        		break;
        		
        	case "3" :			//login���\��
        		 String  identity_mode= "0";
         		outerloop:		//�n�X��break��o
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
                            int counter = 0;	//�����O�ĴX�Ӻ޲z�����
                            int check=0;		//�T�{�n�J�O�_���\
                            for(counter = 0; counter < arrayOfAdmins.size(); counter++) {
                        		if(account.equals(arrayOfAdmins.get(counter).account)&&password.equals(arrayOfAdmins.get(counter).password)) {			//�T�{�b���K�X�@���@��
    		        				System.out.printf("�n�J���\�G"+arrayOfAdmins.get(counter)+"\n");
    		        				check=1;
    		        				break;
    		        			}
    		        		}
                        	if(check==0) {
                        		System.out.printf("�b���K�X���~\n");
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
                                	break outerloop;		//�ibreak����w��loop�h��
                                }
                        	};//admin�n�J�\�൲�� 
                	 		break;
                	 	case "2" :
                	 		// login member
                 			System.out.println("choose identity\n(1)student\n(2)teacher\n(3)staff");
                 			member_identity = scan.nextLine();		//�T�{�n�J���A 1�ǥ�2�Ѯv3���u
                        	System.out.println("input your account(Int)");
                             account = scan.nextLine(); 
                            System.out.println("input your password(Int)");
                            password = scan.nextLine(); 
                            check=0;		//�����O�T�{�n�J�O�_���\
                            counter = 0;	//�ĴX�ӷ|�����
                            switch(member_identity) {
	                            case "1" :				//1�ǥ�
	                            	for(counter = 0; counter < arrayOfStudents.size(); counter++) {
		                        		if(account.equals(arrayOfStudents.get(counter).account)&&password.equals(arrayOfStudents.get(counter).password)) {			//�T�{�b���K�X�@���@��
		    		        				System.out.printf("�n�J���\�G"+arrayOfStudents.get(counter)+"\n");
		    		        				check=1;
		    		        				break;
		    		        			}
		    		        		}
		                        	if(check==0) {
		                        		System.out.printf("�b���K�X���~\n");
		                        	}
		                        	break;
	                            case "2" :		//2�Ѯv
	                            	for(counter = 0; counter < arrayOfTeachers.size(); counter++) {
		                        		if(account.equals(arrayOfTeachers.get(counter).account)&&password.equals(arrayOfTeachers.get(counter).password)) {			//�T�{�b���K�X�@���@��
		    		        				System.out.printf("�n�J���\�G"+arrayOfTeachers.get(counter)+"\n");
		    		        				check=2;
		    		        				break;
		    		        			}
		    		        		}
		                        	if(check==0) {
		                        		System.out.printf("�b���K�X���~\n");
		                        	}
	                            case "3" :		//3���u
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
                                    	book_list.borrow_book(arrayOfStudents.get(counter));	//�e�ǥ͸�ƹL�h
                                	}	
                                	if(check==2) {
                                		book_list.borrow_book(arrayOfTeachers.get(counter));	//�e�Ѯv��ƹL�h
                                	}
                                	break;
                                case "3":	
                                	if(check==1) {
                                    	book_list.return_book(arrayOfStudents.get(counter));//�e�ǥ͸�ƹL�h
                                	}	
                                	if(check==2) {
                                    	book_list.return_book(arrayOfTeachers.get(counter));//�e�Ѯv��ƹL�h
                                	}
                                	break;
                                case "4":	
                                	if(check==1) {
                                        System.out.printf("�ӤH��ơG%s\n",arrayOfStudents.get(counter));
                                	}	
                                	if(check==2) {
                                        System.out.printf("�ӤH��ơG%s\n",arrayOfTeachers.get(counter));
                                	}
                                	break;
                                case "5":	
                                	check=0;
                                	break outerloop;		//�ibreak����w��loop�h��
                                default:
                                	System.out.println("��J1~5");
                                }
                            };//member�n�J�\�൲��     
                	 		break;
                	 	case "3" :
                	 		break;
                	 	default:
                	 		System.out.println("�п�J1~3");
                	 		continue;
                	 	}	
                  }while(!identity_mode.equals("3"));
        		break;
        		
        	case "4" :
        		System.out.println("�{������");
        		break;
        		
        	default:
        		System.out.println("�п�J1~4");
        		break;
        	
        	}
  
        }
        while(!function_mode.equals("4"));
           
        
	}
}//end


			

