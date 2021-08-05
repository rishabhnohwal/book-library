package com.cgi.service;

import java.util.List;

import com.cgi.BookBean.Book;

public interface BookService {
	
	void insertBook(Book book);
	Book getBook(int id);
	List<Book> getAllBooks();
	boolean updateBook(Book book);
	boolean deleteBook(int id);
	
}
