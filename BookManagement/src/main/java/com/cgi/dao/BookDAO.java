package com.cgi.dao;

import java.util.List;

import com.cgi.BookBean.Book;

public interface BookDAO {

	void insertBookIntoDB(Book book);
	Book selectBookFromDB(int id);
	List<Book> selectAllBooksFromDB();
	boolean updateBookIntoDB(Book book);
	boolean deleteBookFromDB(int id);
}
