package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.model.Invoice;


@Repository
public class InvoiceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	public List<Invoice> getAllInvoices() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Invoice> invoiceList = session.createQuery("from Invoice").list();
		
		for (Invoice i: invoiceList) {
			System.out.println("Count "+i.getId());
		}
		
		return invoiceList;
	}
	
	
	public Invoice getInvoice(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Invoice invoice = (Invoice) session.get(Invoice.class, new Long(id));
		return invoice;
	}

	public Invoice addInvoice(Invoice invoice) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(invoice);
		return invoice;
	}

	public void updateInvoice(Invoice invoice) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(invoice);
	}

	public void deleteInvoice(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Invoice i = (Invoice) session.load(Invoice.class, new Long(id));
		if (null != i) {
			session.delete(i);
		}
	}
	
}
