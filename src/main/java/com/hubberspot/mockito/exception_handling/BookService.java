package com.hubberspot.mockito.exception_handling;

import java.sql.SQLException;
import java.util.List;

public class BookService {
	
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public int getTotalPriceOfBooks() {
		List<Book> books = null;
		try {
			books = bookRepository.findAllBooks();
		} catch (SQLException e) {
			// log exception
			throw new DatabaseReadException("Unable to read from database due to - " + e.getMessage());
		}
		int totalPrice = 0;
		for(Book book : books){
			totalPrice = totalPrice + book.getPrice();
		}
		return totalPrice;
	}
	
	public void addBook(Book book){
		try {
			bookRepository.save(book);
		} catch (SQLException e) {
			// log exception
			throw new DatabaseWriteException("Unable to write in database due to - " + e.getMessage());
		}
	}
}
