package org.vermeg.bookstore.test;
import static org.hamcrest.Matchers.* ;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.BDDMockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vermeg.bookstore.controller.BookController;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.service.BookService;


class BookControllerTest {

	@Mock 
	private BookService bookService ;
	
	@InjectMocks 
	private BookController bookController ;
	  
	private MockMvc mockMvc ;
	
	@BeforeEach
	 public void Setup() {
		 MockitoAnnotations.initMocks(this);	
		 mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	 } 
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetBookById() throws Exception{
		final int idbook=10;
		Book book=new Book(idbook, "title1", "author1", null, 10);
		when(bookService.getBook(idbook)).thenReturn(book);
		this.mockMvc.perform(get("/api/book/getBook/10"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.author", is(book.getAuthor())));
	}

	@Test
	void testAddBook() throws Exception {
		Book book=new Book(12, "title1", "author1", null, 10);

		bookService.addBook(book);
		
		verify(bookService, times(1)).addBook(book);
	}

	@Test
	void testUpdateBook() {
		Book book=new Book(10, "title1", "author1", null, 10);
		bookService.updateBook(book);
		verify(bookService, times(1)).updateBook(book);
		
		
	}

	@Test
	void testDeleteBook() {
		Book book=new Book(10, "title1", "author1", null, 10);
		bookService.deleteBook(10);
		verify(bookService, times(1)).deleteBook(10);
	}


	


	@Test
	void testGetBooks() throws Exception {
		List<Book> books = new ArrayList<>() ;
	
		books.add(new Book(10, "title1", "author1", null, 10));
		books.add(new Book(11, "title2", "author2", null, 14));
		when (bookService.getAllBooks()).thenReturn((List)books) ;
		mockMvc.perform(get("/api/book/getAll"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)))
		.andDo(MockMvcResultHandlers.print());
										
	}
	
	

	
}
