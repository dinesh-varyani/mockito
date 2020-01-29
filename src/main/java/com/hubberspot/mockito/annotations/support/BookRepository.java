package com.hubberspot.mockito.annotations.support;

import java.util.List;

public interface BookRepository {
	List<Book> findNewBooks(int days);
}
