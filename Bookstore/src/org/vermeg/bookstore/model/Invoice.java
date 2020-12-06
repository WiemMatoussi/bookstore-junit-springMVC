package org.vermeg.bookstore.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
	
	
	@Column(name = "dateinvoice")
	private Date dateInvoice;

	
	@OneToMany(mappedBy="invoice")
 	@Column(name="commandline", nullable = true) 
	 private List<CommandLine> commandline;

	
	


	public Invoice(Date dateInvoice, List<CommandLine> commandline) {
		
		this.dateInvoice = dateInvoice;
		this.commandline = commandline;
	}


	
	
	
	public List<CommandLine> getCommandline() {
		return commandline;
	}





	public void setCommandline(List<CommandLine> commandline) {
		this.commandline = commandline;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateInvoice() {
		return dateInvoice;
	}


	public void setDateInvoice(Date dateInvoice) {
		this.dateInvoice = dateInvoice;
	}
	
	
	public Invoice() {
    }
	
	
}
