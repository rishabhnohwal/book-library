package com.cgi.factory;

import com.cgi.service.BookService;
import com.cgi.service.BookServiceImp;

public class ServiceFactory {
	public static BookService getServiceObject() {
		BookService bookService = new BookServiceImp();
		return bookService;
	}
}
