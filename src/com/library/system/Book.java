package com.library.system;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private boolean isAvailable;
	@Override
	public String toString(){
		return "ID: " + id + " | Title: '" + title + "' | Author: " + author + " | Status:" +
		           (isAvailable ? " [Available]" : " [Checked Out]");
	}
	
	public String toFileString() {
	    
	    return id + ";" + title + ";" + author + ";" + isAvailable;
	}

	
	
 public Book (int id, String title, String author, boolean isAvailable) {
	 this.id = id;
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

