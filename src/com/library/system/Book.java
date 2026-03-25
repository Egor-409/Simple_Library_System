package com.library.system;

public class Book {
	private static int idCounter = 1;
	private int id;
	private String title;
	private String author;
	private boolean isAvailable;
	@Override
	public String toString(){
		return "ID: " + id + " | Title: '" + title + "' | Author: " + author + 
		           (isAvailable ? " [Available]" : " [Checked Out]");
	}

	
	
 public Book (int id, String title, String author, boolean isAvailable) {
	 this.id = idCounter++;
	 this.title = title;
	 this.author = author;
	 this.isAvailable = true;
	 
 }
 
public void setTitle(String title) {this.title = title;}
public void setId(int id) {this.id = id;}
public void setAuthor(String author) {this.author = author;}
public void setIsAvailable(boolean isAvailable) {this.isAvailable= isAvailable;}

public String getTitle() {return title;}
public int getId() {return id;}
public String getAuthor() {return author;}
public boolean getIsAvailable() {return isAvailable;}
}

