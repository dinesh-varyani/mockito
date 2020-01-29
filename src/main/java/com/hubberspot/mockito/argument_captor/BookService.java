package com.hubberspot.mockito.argument_captor;

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
//		if(bookRequest.getPrice() <= 500){
//			return;
//		}
		Book book = new Book();
		book.setTitle(bookRequest.getTitle());
		book.setPrice(bookRequest.getPrice());
		book.setPublishedDate(bookRequest.getPublishedDate());
		bookRepository.save(book);
	}
	
	public void updatePrice(String bookId, int updatedPrice){
		if(bookId == null) {
			return;
		}
		Book book = bookRepository.findBookById(bookId);
//		if(book.getPrice() == updatedPrice){
//			return;
//		}
		book.setPrice(updatedPrice);
		bookRepository.save(book);
	}
}
