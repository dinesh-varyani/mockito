package com.hubberspot.mockito.spies;

public class BookService {
	
	public Book findBook(String bookId) {
		throw new RuntimeException("Method not implemented");
	}
	
	public int getAppliedDiscount(Book book, int discountRate) {
		int price = book.getPrice();
		int newPrice = price - (price * discountRate / 100);
		return newPrice;
	}
}
