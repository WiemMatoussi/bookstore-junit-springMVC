package org.vermeg.bookstore.test;
import static org.hamcrest.Matchers.* ;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vermeg.bookstore.controller.BookController;
import org.vermeg.bookstore.controller.CommandLineController;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.CommandLine;
import org.vermeg.bookstore.model.Invoice;
import org.vermeg.bookstore.service.BookService;
import org.vermeg.bookstore.service.CommandLineService;


class CommandLineControllerTest {
	@Mock 
	private CommandLineService commandLineService ;
	
	@InjectMocks 
	private  CommandLineController commandLineController ;
	  
	private MockMvc mockMvc ;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);	
		 mockMvc = MockMvcBuilders.standaloneSetup(commandLineController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCommandLines() throws Exception {
		List<CommandLine> commandlines = new ArrayList<>() ;
		Invoice invoice=new Invoice(null,null);
		Book book=new Book(10, "title1", "author1", null, 10);
		commandlines.add(new CommandLine(10, book, invoice,  10));

		commandlines.add(new CommandLine(10, book, invoice,  10));
	 when (commandLineService.getAllCommandLines()).thenReturn((List)commandlines) ;
	 mockMvc.perform(get("/api/commandLine/getAll"))
     .andExpect(status().isOk())
     .andExpect(jsonPath("$", hasSize(2)))
     .andDo(MockMvcResultHandlers.print());
	}
	
	
	
//	@Test
//	void testGetCommandLineById() throws Exception {
//		final int idcommandline=10;
//		Invoice invoice=new Invoice(null,null);
//		Book book=new Book(10, "title1", "author1", null, 10);
//		
//		CommandLine commandLine=new CommandLine(10, book, invoice,  10);
//		when(commandLineService.getCommandLine(idcommandlinite)).thenReturn(commandLine);
//	
//		this.mockMvc.perform(get("/api/book/getCommandLine/idcommandline"))
//		.andExpect(status().isOk())
//		.andExpect(jsonPath("$.author", is(book.getAuthor())));
//	}

	@Test
	void testAddCommandLine() {
		final int idcommandline=10;
		Invoice invoice=new Invoice(null,null);
		Book book=new Book(10, "title1", "author1", null, 10);
		CommandLine commandLine=new CommandLine(10, book, invoice,  10);

		commandLineService.addCommandLine(commandLine);
		
		verify(commandLineService, times(1)).addCommandLine(commandLine);
	}

	@Test
	void testUpdateCommandLine() {
		final int idcommandline=10;
		Invoice invoice=new Invoice(null,null);
		Book book=new Book(10, "title1", "author1", null, 10);
		CommandLine commandLine=new CommandLine(10, book, invoice,  10);
		
		commandLineService.updateCommandLine(commandLine);
		verify(commandLineService, times(1)).updateCommandLine(commandLine);
		
	}

	@Test
	void testDeleteCommandLine() {
		final int idcommandline=10;
		Invoice invoice=new Invoice(null,null);
		Book book=new Book(10, "title1", "author1", null, 10);
		CommandLine commandLine=new CommandLine(1, book, invoice,  10);

		commandLineService.deleteCommandLine(10);
		verify(commandLineService, times(1)).deleteCommandLine(idcommandline);
	}
	
}
