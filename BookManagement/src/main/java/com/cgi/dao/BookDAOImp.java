package com.cgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cgi.BookBean.Book;
import com.cgi.factory.ConnectionFactory;

public class BookDAOImp implements BookDAO {
	
	private static final String INSERT_BOOK_SQL = "INSERT INTO books" + "  (name, author, price) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_BOOK_BY_ID = "select id,name,author,price from books where id =?";
	private static final String SELECT_ALL_BOOKS = "select * from books";
	private static final String DELETE_BOOK_SQL = "delete from books where id = ?;";
	private static final String UPDATE_BOOK_SQL = "update books set name = ?,author= ?, price =? where id = ?;";
	
	
	public BookDAOImp() {
	}
	
	//Insert Book
	public void insertBookIntoDB(Book book) {
		System.out.println(INSERT_BOOK_SQL);
		try {
			Connection connection = ConnectionFactory.getConnectionObject();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2,book.getAuthor());
			preparedStatement.setFloat(3, book.getPrice());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Select Book by ID
	public Book selectBookFromDB(int id) {
		Book book=null;
		try {
			Connection connection = ConnectionFactory.getConnectionObject();
			PreparedStatement preparedStatement= connection.prepareStatement(SELECT_BOOK_BY_ID);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet res=preparedStatement.executeQuery();
			
			while(res.next()) {
				String name = res.getString("name");
				String author = res.getString("author");
				float price = res.getFloat("price");
				book = new Book(id,name,author,price);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//Select all books
	@Override
	public List<Book> selectAllBooksFromDB() {
		List<Book> books = new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getConnectionObject();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
			System.out.println(preparedStatement);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String author = res.getString("author");
				float price = res.getFloat("price");
				books.add(new Book(id,name,author,price));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	//Update book
	public boolean updateBookIntoDB(Book book) {
		boolean updated=false;
		try {
			Connection connection = ConnectionFactory.getConnectionObject();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL);
			System.out.println(preparedStatement);
			
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setFloat(3, book.getPrice());
			preparedStatement.setInt(4, book.getId());
			
			updated = preparedStatement.executeUpdate() > 0;
			System.out.println(updated);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return updated;
	}
	
	//delete book
	public boolean deleteBookFromDB(int id) {
		boolean deleted=false;
		try {
			Connection connection = ConnectionFactory.getConnectionObject();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL);
			preparedStatement.setInt(1, id);
			deleted = preparedStatement.executeUpdate() >0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

	
	
	
	
}
