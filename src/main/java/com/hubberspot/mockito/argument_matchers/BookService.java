package com.hubberspot.mockito.argument_matchers;

import java.time.LocalDate;
import java.util.List;

public class BookService {
	
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void addBook(Book book) {
		if(book.getPrice() <= 500){
			return;
		}
		bookRepository.save(book);
	}
	
	public void addBook(BookRequest bookRequest) {
		if(bookRequest.getPrice() <= 500){
			return;
		}
		Book book = new Book();
		book.setTitle(bookRequest.getTitle());
		book.setPrice(bookRequest.getPrice());
		book.setPublishedDate(bookRequest.getPublishedDate());
		bookRepository.save(book);
	}
	
	public void updatePrice(String bookId, int updatedPrice){
		Book book = bookRepository.findBookById(bookId);
		book.setPrice(updatedPrice);
		bookRepository.save(book);
	}
	
	public Book getBookByTitleAndPublishedDate(String title, LocalDate localDate) {
		return bookRepository.findBookByTitleAndPublishedDate(title, localDate);
	}
	
	public Book getBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital) {
		return bookRepository.findBookByTitleAndPriceAndIsDigital(title, price, isDigital);
	}
	
	public void addBooks(List<Book> books) {
		bookRepository.saveAll(books);
	}
}
