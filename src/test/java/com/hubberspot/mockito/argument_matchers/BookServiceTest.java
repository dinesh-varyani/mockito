package com.hubberspot.mockito.argument_matchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@InjectMocks
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;
	
	@Test
	public void testUpdatePrice() {
		Book book1 = new Book("1234", "Mockito In Action", 600, LocalDate.now());
		Book book2 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		when(bookRepository.findBookById(any(String.class))).thenReturn(book1);
		bookService.updatePrice("1234", 500);
		verify(bookRepository).save(book2);
	}
	
	// Argument Matchers should be provided for all arguments
	// Argument Matchers cant be used outside stubbing/verification
	@Test
	public void testInvalidUseOfArgumentMatchers() {
		Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
		when(bookRepository.findBookByTitleAndPublishedDate(eq("Mockito In Action"), any())).thenReturn(book);
		Book actualBook = bookService.getBookByTitleAndPublishedDate(eq("Mockito In Action"), any());
		assertEquals("Mockito In Action", actualBook.getTitle());
	}
	
	@Test
	public void testSpecificTypeOfArgumentMatchers() {
		Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
		when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean())).thenReturn(book);
		Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("Mockito In Action", 600, true);
		assertEquals("Mockito In Action", actualBook.getTitle());
	}
	
	@Test
	public void testCollectionTypeArgumentMatchers() {
		List<Book> books = new ArrayList<>();
		Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
		books.add(book);
		bookService.addBooks(books);
		verify(bookRepository).saveAll(anyList()); // anySet, anyMap, anyCollection
	}
	
	@Test
	public void testStringTypeArgumentMatchers() {
		Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
		when(bookRepository.findBookByTitleAndPriceAndIsDigital(contains("Action"), anyInt(), anyBoolean())).thenReturn(book);
		Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("JUnit 5 In Action", 600, true);
		assertEquals("Mockito In Action", actualBook.getTitle());
	}
	
}
