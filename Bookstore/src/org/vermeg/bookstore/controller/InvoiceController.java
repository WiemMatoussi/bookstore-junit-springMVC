package org.vermeg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.CommandLine;
import org.vermeg.bookstore.model.Invoice;
import org.vermeg.bookstore.service.InvoiceService;


@RestController
@RequestMapping("/api/invoice")

public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	//Method that returns the invoices from the database

	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Invoice> getInvoices() {
		
		List<Invoice> listOfInvoices = invoiceService.getAllInvoices();
		
		return listOfInvoices;
	}

	@RequestMapping(value = "/getInvoice/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Invoice getInvoiceById(@PathVariable int id) {
		return invoiceService.getInvoice(id);
	}
	
	//Method to add an invoice


	@RequestMapping(value = "/addInvoice", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addInvoice(@RequestBody Invoice invoice) {	
		invoiceService.addInvoice(invoice);
		return "redirect:/getAll";
	}

	//Method to update an invoice

	@RequestMapping(value = "/updateInvoice/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateInvoice(@PathVariable("id") int id,Model model) {
		 model.addAttribute("invoice", this.invoiceService.getInvoice(id));
	        model.addAttribute("listOfInvoices", this.invoiceService.getAllInvoices());
	        return "invoiceDetails";
	}

	//Method to delete an invoice

	@RequestMapping(value = "/deleteInvoice/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteInvoice(@PathVariable("id") long id) {
		invoiceService.deleteInvoice(id);
		 return "redirect:/getAllInvoice";

	}	
}
