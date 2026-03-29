package com.library.system;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class LibraryManager {
	
	private static LibraryManager instance;
	
	
	private ArrayList<Book> books = new ArrayList<>();
	
	private LibraryManager () {
		loadData();
	}
	
	public static LibraryManager getInstance() {
		if(instance == null) {instance = new LibraryManager();}
		return instance;
	}
	
	public  void saveToFile(){
		try (FileWriter saver2 = new FileWriter("BookList.txt", false)) {
		for (Book a : books) {saver2.write(a.toFileString() + "\n");}
	}
		catch(IOException e) {System.out.print(e.getMessage());}
		}
	
	
	
	
	public void loadData() {
		try(BufferedReader br = new BufferedReader(new FileReader ("BookList.txt"))) {
			String line;
			while(((line = br.readLine())!= null)) {
				String parts [] = line.split(";");
				int id = Integer.parseInt(parts[0]);
				String Title = parts[1];
				String Author = parts[2];
				Boolean isAvailable = Boolean.parseBoolean(parts[3]);
				books.add(new Book (id, Title, Author, isAvailable));	
			}
		} catch (IOException e) {System.out.print(e.getMessage());}
		
	}
	
	
	
	public  String bookList() {
		if (books.isEmpty()) {return "Empty library";}
			return books.stream()
			.map(Book :: toString)
	        .collect(Collectors.joining("\n"));
	}
		
		
		
	
	
	
	
	public  String addBook (Scanner scanner) {
		scanner.nextLine(); 
		int idCounter = books.size();
		System.out.println("Enter name of the book");
		String newBookName = scanner.nextLine();
		System.out.println("Enter Author of the book");
		String newBookAuthor = scanner.nextLine();
		Book newbook = new Book (idCounter + 1,newBookName,newBookAuthor,true);
		books.add(newbook);
		saveToFile();
		return "new book added";	
	}
	
	
	
	public  String findBook(Scanner scanner) {
		scanner.nextLine(); 
		System.out.println("Enter name of the book");
		String findingBookName = scanner.nextLine();
		String res = books.stream()
					.filter(b->b.getTitle().equalsIgnoreCase(findingBookName))
					.map(Book::toString)
					.collect(Collectors.joining("\n"));
		return res.isEmpty() ? "no this book" : res;
				
	}
	
	
	
	
	
	
	public  String getBook(Scanner scanner ) {
		scanner.nextLine(); 
		System.out.println ("Enter name of the book");
		String givenBook = scanner.nextLine();
		for (Book a : books) {
			String BookName = a.getTitle();
			boolean valid = a.getIsAvailable();
			if (givenBook.equalsIgnoreCase(BookName) && valid==false) {
				a.setIsAvailable(true);
			}
		}
		saveToFile();
		return "change marked - | available |";
	}
	
	
	
	public  String giveBook(Scanner scanner) {
		scanner.nextLine(); 
		System.out.println ("Enter name of the book");
		String givenBook = scanner.nextLine();
		for (Book a : books) {
			String BookName = a.getTitle();
			boolean valid = a.getIsAvailable();
			if (givenBook.equalsIgnoreCase(BookName) && valid==true) {
				a.setIsAvailable(false);
			}
		}
		saveToFile();
		return "book marked - | checked out |";
	}
	
	
	
	
	public  String removeBook(Scanner scanner) {
		scanner.nextLine(); 
		System.out.println("Enter name of the book");
		String delBook = scanner.nextLine();
		for(int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equalsIgnoreCase(delBook)) {
				books.remove(i);
			}	
		}
		saveToFile();
		return "sucсessful remove";
	}



}
