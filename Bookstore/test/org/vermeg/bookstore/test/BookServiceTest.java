package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.dao.BookDAO;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.service.BookService;

class BookServiceTest {
	
	BookDAO bookDao  = mock(BookDAO.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	void testGetAllBooks() {
		 List<Book> books= new ArrayList<Book>();
	   	 Book book=new Book(10, "title1", "author1", null, 10);
         Book book2 = new Book(11, "title2", "author2", null, 10);
			 books.add(book);
			 books.add(book2);
			 when(bookDao.getAllBooks()).thenReturn(books);
			 assertEquals(2,books.size());
			 assertEquals("title1",books.get(0).getTitle()," un livre différent");
			 assertEquals("title2",books.get(1).getTitle(), " un livre différent");
			 assertEquals(bookDao.getAllBooks() , books);
	}

	@Test
	void testGetBook() {
		Book  book1 = new Book(1, "title1", "author1", null, 10);
		 when(bookDao.getBook(1)).thenReturn(book1);
		 assertTrue(bookDao.getBook(1) == book1);
		}

	@Test
	void testAddBook() {
		
		List<Book> books= new ArrayList<Book>();
		Book book = new Book(1, "title1", "author1", null, 10);
		 int size=books.size();
		 books.add(book);
		 when(bookDao.addBook(book)).thenReturn(book);
		 assertEquals(bookDao.addBook(book),book);
		 assertTrue(books.size()== size+1);
		
	}
	
	 

	@Test
	void testUpdateBook() {
		Book book= new Book(1, "title1", "author1", null, 10);
				
		bookDao.updateBook(book);
		verify(bookDao,times(1)).updateBook(book);
		}

	@Test
	void testDeleteBook() {
		Book book = new Book(1, "title1", "author1", null, 10);
		 bookDao.deleteBook(1);
		verify(bookDao,times(1)).deleteBook(1);
		}
	}


