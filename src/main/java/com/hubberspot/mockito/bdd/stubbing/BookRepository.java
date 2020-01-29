package com.hubberspot.mockito.bdd.stubbing;

import java.util.List;

public interface BookRepository {
	List<Book> findNewBooks(int days);
}
