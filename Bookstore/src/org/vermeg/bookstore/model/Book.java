package org.vermeg.bookstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	
	@Column(name = "reference", unique=true)
	private int reference;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "releaseDate")
	private Date releaseDate;
	
	@Column(name = "unitPrice")
	private double unitPrice;
	
	
	


	public Book(int reference, String title, String author, Date releaseDate, double unitPrice) {
		
		this.reference = reference;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
		this.unitPrice = unitPrice;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getReference() {
		return reference;
	}


	public void setReference(int reference) {
		this.reference = reference;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Book() {
    }
	
	
	
}
