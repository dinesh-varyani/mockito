package com.hubberspot.mockito.spies;


public class BookManager {
	
	private BookService bookService;
	
	public BookManager(BookService bookService) {
		this.bookService = bookService;
	}
	
	public int applyDiscountOnBook(String bookId, int discountRate) {
		Book book = bookService.findBook(bookId); // We need to Mock
		int discountedPrice = bookService.getAppliedDiscount(book, discountRate);
		return discountedPrice;
	}
}
