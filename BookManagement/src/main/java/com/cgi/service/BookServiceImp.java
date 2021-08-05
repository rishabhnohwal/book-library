package com.cgi.service;

import java.util.List;

import com.cgi.BookBean.Book;
import com.cgi.dao.BookDAO;
import com.cgi.factory.DAOFactory;

public class BookServiceImp implements BookService {
	
	@Override
	public void insertBook(Book book) {
		BookDAO bookDAO = DAOFactory.getBookDAOObject();
		bookDAO.insertBookIntoDB(book);
	}

	@Override
	public Book getBook(int id) {
		BookDAO bookDAO = DAOFactory.getBookDAOObject();
		Book bookObject = bookDAO.selectBookFromDB(id);
		return bookObject;
	}

	@Override
	public List<Book> getAllBooks() {
		BookDAO bookDAO = DAOFactory.getBookDAOObject();
		List<Book> booksList = bookDAO.selectAllBooksFromDB();
		return booksList;
	}

	@Override
	public boolean updateBook(Book book) {
		BookDAO bookDAO = DAOFactory.getBookDAOObject();
		boolean updated = bookDAO.updateBookIntoDB(book);
		return updated;
	}

	@Override
	public boolean deleteBook(int id) {
		BookDAO bookDAO = DAOFactory.getBookDAOObject();
		boolean deleted = bookDAO.deleteBookFromDB(id);
		return deleted;
	}

}
