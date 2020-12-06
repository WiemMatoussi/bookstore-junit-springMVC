package org.vermeg.bookstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="commandline")
public class CommandLine {

	
	@Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "priceCommandLine")
	private double priceCommandLine;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book")
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_invoice")
	private Invoice invoice;
	
	
	CommandLine(){}

	

	public CommandLine(double quantity, Book book, Invoice invoice, double priceCommandLine) {
		
		this.quantity = quantity;
		this.book = book;
		this.invoice = invoice;
		this.priceCommandLine=book.getUnitPrice()*this.quantity;

	}



	
	public double getPriceCommandLine() {
		return priceCommandLine;
	}



	public void setPriceCommandLine(double priceCommandLine) {
		this.priceCommandLine = priceCommandLine;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public Invoice getInvoice() {
		return invoice;
	}



	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
}
