package com.library.system;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class LibraryMaganer {
	
	
	static ArrayList<Book> books = new ArrayList<>();
	
	
	
	public static String bookList() {
		if (books.isEmpty()) {
			return "library is empty";
		}
		return books.stream()
				.map(Book :: toString)
		        .collect(Collectors.joining("\n"));
	}
	
	
	
	
	public static String addBook (Scanner scanner) {
		System.out.println("Enter name of the book");
		String newBookName = scanner.nextLine();
		System.out.println("Enter Author of the book");
		String newBookAuthor = scanner.nextLine();
		Book newbook = new Book (1,newBookName,newBookAuthor,true);
		books.add(newbook);
		return "added new book " + newBookName + "\nauthor : " + newBookAuthor;
	}
	
	
	
	public static String findBook(Scanner scanner) {
		
		System.out.println("Enter name of the book");
		String findingBookName = scanner.nextLine();
		
		String res = books.stream()
					.filter(b->b.getTitle().equalsIgnoreCase(findingBookName))
					.map(Book::toString)
					.collect(Collectors.joining("\n"));
		return res.isEmpty() ? "no this book" : res;
				
	}
	
	
	
	
	
	
	public static String getBook(Scanner scanner ) {
		System.out.println ("enter name of the book");
		String givenBook = scanner.nextLine();
		for (Book a : books) {
			String BookName = a.getTitle();
			boolean valid = a.getIsAvailable();
			if (givenBook.equalsIgnoreCase(BookName) && valid==false) {
				a.setIsAvailable(true);
			}
			
		}
		return "change saved";
	}
	public static String giveBook(Scanner scanner) {
		System.out.println ("enter name of the book");
		String givenBook = scanner.nextLine();
		for (Book a : books) {
			String BookName = a.getTitle();
			if (givenBook.equalsIgnoreCase(BookName)) {
				a.setIsAvailable(false);
			}
			
		}
		
		return "change saved";
	}
	public static String removeBook(Scanner scanner) {
		System.out.println("enter name of the book");
		String delBook = scanner.nextLine();
		for(int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equalsIgnoreCase(delBook)) {
				books.remove(i);
			}
			
		}
		
		return "sucсessful remove";
	}



}
