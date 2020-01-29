package com.hubberspot.mockito.test_doubles.spy;

public class BookRepositorySpy implements BookRepository {
	
	int saveCalled = 0;
	Book lastAddedBook = null;
	
	@Override
	public void save(Book book) {
		saveCalled++;
		lastAddedBook = book;
	}
	
	public int timesCalled(){
		return saveCalled;
	}
	
	public boolean calledWith(Book book){
		return lastAddedBook.equals(book);
	}
	
}
