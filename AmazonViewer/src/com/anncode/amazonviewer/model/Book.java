package com.anncode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.anncode.util.AmazonUtil;

public class Book extends Publication implements IVisualizable {
	private int id;
	private String isbn;
	private boolean read;
	private int timeRead;
	private ArrayList<Page> pages;
	
	
	
	public Book(String title, Date editionDate, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, editionDate, editorial);

		setAuthors(authors);
		this.pages = pages;
	}


	public int getId() {
		return id;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String isRead() {
		String read;
		if(this.read) {
			read = "Yes";
		}else {
			read = "No";
		}
		
		return read;
	}


	public void setRead(boolean read) {
		this.read = read;
	}
	
	public boolean getIsRead() {
		return read;
	}


	public int getTimeRead() {
		return timeRead;
	}


	public void setTimeRead(int timeRead) {
		this.timeRead = timeRead;
	}
	
	@Override
	public String toString() {

		String detailBook = "\n :: BOOK ::" + 
							"\n Title: " + getTitle() +
							"\n Editorial: " + getEditorial() + 
							"\n Edition Date: " + getEdititionDate() +
							"\n Authors: ";
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t" + getAuthors()[i] + " ";
		}
		return  detailBook;
	}


	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}


	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if (dateF.getTime() > dateI.getTime()) {
			setTimeRead((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeRead(0);
		}
	}
	
	public void view() {
		setRead(true);
		Date dateI = startToSee(new Date());
		
		
		int i = 0;
		do {
			System.out.println("..........");
			System.out.println("Page " + getPages().get(i).getNumber());
			System.out.println(getPages().get(i).getContent());
			System.out.println("..........");
			
			if (i != 0) {
				System.out.println("1. Return page");
			}
			
			System.out.println("2. Next page");
			System.out.println("0. Close book");
			System.out.println();
			
			int response  = AmazonUtil.validateUserResponseMenu(0, 2);
			
			if (response == 2) {
				i++;
			}else if(response == 1) {
				i--;
			}else if(response == 0) {
				break;
			}
			
		}while(i < getPages().size());
		
		
		//I finished watching
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("You read: " + this);
		System.out.println("For: " + getTimeRead() + " milliseconds");
	}
	
	public static ArrayList<Book> makeBookList() {
		ArrayList<Book> books = new ArrayList();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		
		ArrayList<Page> pages = new ArrayList();
		int page = 0;
		for (int i = 0; i < 3; i++) {
			page = i+1;
			pages.add(new Book.Page(page, "The content of the page " + page));
		}
		
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors, pages));
		}
		
		return books;
	}
	
	
	public ArrayList<Page> getPages() {
		return pages;
	}


	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}


	public static class Page {
		private int id;
		private int number;
		private String content;
	
		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
	
}












