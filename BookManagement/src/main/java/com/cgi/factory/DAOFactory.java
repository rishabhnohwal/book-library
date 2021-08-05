package com.cgi.factory;

import com.cgi.dao.BookDAO;
import com.cgi.dao.BookDAOImp;

public class DAOFactory {
	BookDAO bookDAO = null;
	public static BookDAO getBookDAOObject() {
		BookDAO bookDAO = new BookDAOImp();
		return bookDAO;
	}
}
