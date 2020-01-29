package com.hubberspot.mockito.test_doubles.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRepository {
	
	int saveCalled = 0;
	Book lastAddedBook = null;
	
	@Override
	public void save(Book book) {
		saveCalled++;
		lastAddedBook = book;
	}
	
	public void verify(Book book, int times){
		assertEquals(times, saveCalled);
		assertEquals(book, lastAddedBook);
	}
	
}
