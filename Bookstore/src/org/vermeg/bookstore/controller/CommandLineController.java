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
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.CommandLine;
import org.vermeg.bookstore.service.BookService;
import org.vermeg.bookstore.service.CommandLineService;

@RestController
@RequestMapping("/api/commandLine")

public class CommandLineController {
	
	@Autowired
	CommandLineService commandLineService;
	
	
	//Method that returns the command lines from the database

	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<CommandLine> getCommandLines() {
		
		List<CommandLine> listOfCommandLines = commandLineService.getAllCommandLines();
		
		return listOfCommandLines;
	}

	@RequestMapping(value = "/getCommandLine/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CommandLine getCommandLineById(@PathVariable long id) {
		return commandLineService.getCommandLine(id);
	}

	
	//Method to add a command line

	@RequestMapping(value = "/addCommandLine", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCommandLine(@RequestBody CommandLine commandLine) {	
		commandLineService.addCommandLine(commandLine);
		return "redirect:/getAll";
	}

	//Method to update a command line

	@RequestMapping(value = "/updateCommandLine/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateCommandLine(@PathVariable("id") long id,Model model) {
		 model.addAttribute("commandLine", this.commandLineService.getCommandLine(id));
	        model.addAttribute("listOfCommandLines", this.commandLineService.getAllCommandLines());
	        return "commandLineDetails";
	}
	
	//Method to delete a command line


	@RequestMapping(value = "/deleteCommandLine/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteCommandLine(@PathVariable("id") long id) {
		commandLineService.deleteCommandLine(id);
		 return "redirect:/getAllCommandLines";

	}	
}
