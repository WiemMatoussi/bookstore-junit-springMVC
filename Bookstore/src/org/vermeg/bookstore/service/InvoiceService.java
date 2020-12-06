package org.vermeg.bookstore.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vermeg.bookstore.dao.BookDAO;
import org.vermeg.bookstore.dao.InvoiceDAO;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.Invoice;




@Service("invoiceService")
public class InvoiceService{

	@Autowired
	InvoiceDAO invoiceDao;
	
	@Autowired
	BookDAO bookDao;
	
	
	@Transactional
	public Invoice getInvoice(int id) {
		return invoiceDao.getInvoice(id);
	}
	
	@Transactional
	public List<Invoice> getAllInvoices() {
		return invoiceDao.getAllInvoices();
	}


	@Transactional
	public void addInvoice(Invoice invoice) {
		invoiceDao.addInvoice(invoice);
	}

	@Transactional
	public void updateInvoice(Invoice invoice) {
		invoiceDao.updateInvoice(invoice);

	}

	@Transactional
	public void deleteInvoice(long id) {
		invoiceDao.deleteInvoice(id);
	}
	

	
	
}
