package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.dao.BookDAO;
import org.vermeg.bookstore.dao.CommandLineDAO;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.CommandLine;
import org.vermeg.bookstore.model.Invoice;

class CommandLineServiceTest {

	CommandLineDAO commandLineDao  = mock(CommandLineDAO.class);

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
	void testTestGetCommandLines() {
		 List<CommandLine> commandlines= new ArrayList<CommandLine>();
		 Invoice invoice=new Invoice(null,null);
		 Book book=new Book(1, "title1", "author1", null, 10);
		 CommandLine commandLine=new CommandLine(10, book, invoice,  10);
		 CommandLine commandLine1=new CommandLine(11, book, invoice,  10);

		 commandlines.add(commandLine);
		 commandlines.add(commandLine1);
		 when(commandLineDao.getAllCommandLines()).thenReturn(commandlines);
		 assertEquals(2,commandlines.size());
		 assertEquals(10 ,commandlines.get(0).getQuantity(), "different command");
		 assertEquals(11 ,commandlines.get(1).getQuantity(), "different command");
		assertEquals(commandLineDao.getAllCommandLines() , commandlines);
	}

	@Test
	void testTestGetCommandLineById() {
		 Invoice invoice=new Invoice(null,null);
		 Book book=new Book(1, "title1", "author1", null, 10);
		 CommandLine commandLine=new CommandLine(10, book, invoice,  10);
		 when(commandLineDao.getCommandLine(10)).thenReturn(commandLine);
		 assertTrue(commandLineDao.getCommandLine(10) == commandLine);
	}

	
	@Test
	void testTestUpdateCommandLine() {
		 Invoice invoice=new Invoice(null,null);
		 Book book=new Book(1, "title1", "author1", null, 10);
		 CommandLine commandLine=new CommandLine(10, book, invoice,  10);		 
		
		 commandLineDao.updateCommandLine(commandLine);
		verify(commandLineDao,times(1)).updateCommandLine(commandLine);
	}

	@Test
	void testTestDeleteCommandLine() {
		 Invoice invoice=new Invoice(null,null);
		 Book book=new Book(1, "title1", "author1", null, 10);
		 CommandLine commandLine=new CommandLine(10, book, invoice,  10);		 
		
		 commandLineDao.deleteCommandLine(10);
		verify(commandLineDao,times(1)).deleteCommandLine(10);
	}

}
