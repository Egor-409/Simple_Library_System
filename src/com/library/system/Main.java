package com.library.system;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		LibraryManager.loadData();
		
		while(true){
		
	    int action = -1;
		System.out.println(" \n\n CHOOSE THE ACTION \n\n1. show the book list \n2. add book \n3. find book \n4. get book back to the library \n5. give book from the library \n6. remove book from system \n0. close the app \n\n PRESS A NUMBER OF ACTION TO CONTINUE" );
	    try {
		 action = scanner.nextInt();
		 scanner.nextLine();
		
	    }
	    catch(InputMismatchException e) {
	    	System.out.println("Error: Please enter a valid number, not text");
	         
	         scanner.nextLine();
	         continue;
	         
	    }
				
		switch(action) {
		case 1:
			System.out.println(LibraryManager.bookList());
			break;
		case 2:
			System.out.println(LibraryManager.addBook(scanner));
			break;
		case 3:
			System.out.println(LibraryManager.findBook(scanner));
			break;
		case 4:
			System.out.println(LibraryManager.getBook(scanner));
			break;
		case 5:
			System.out.println(LibraryManager.giveBook(scanner));
			break;
		case 6:
			System.out.println(LibraryManager.removeBook(scanner));
			break;
		case 0:
			System.out.println("Closing application");
			System.exit(0);
			break;
			
			
		}
	}


			
		
	
	}

}
