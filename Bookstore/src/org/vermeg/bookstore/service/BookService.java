package org.vermeg.bookstore.service;

import java.util.List;

import org.vermeg.bookstore.dao.BookDAO;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
public class BookService{

	@Autowired
	BookDAO bookDao;
	
	
	@Transactional
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Transactional
	public Book getBook(long id) {
		return bookDao.getBook(id);
	}

	@Transactional
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Transactional
	public void updateBook(Book book) {
		bookDao.updateBook(book);

	}

	@Transactional
	public void deleteBook(long id) {
		bookDao.deleteBook(id);
	}

	
	
	
	
}
