package org.vermeg.bookstore.dao;

import java.util.Collection;
import java.util.List;

import org.vermeg.bookstore.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	public List<Book> getAllBooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> bookList = session.createQuery("from Book").list();
		
		for (Book b:bookList) {
			System.out.println("Count  "+b.getTitle());
		}
		
		return bookList;
	}
	
	
	public Book getBook(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.get(Book.class, new Long(id));
		return book;
	}

	public Book addBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(book);
		return book;
	}

	public void updateBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(book);
	}

	public void deleteBook(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book b = (Book) session.load(Book.class, new Long(id));
		if (null != b) {
			session.delete(b);
		}
	}
	
}
