package org.vermeg.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vermeg.bookstore.dao.BookDAO;
import org.vermeg.bookstore.dao.CommandLineDAO;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.CommandLine;

@Service("commandLineService")
public class CommandLineService  {

	@Autowired
	CommandLineDAO commandLineDao;
	
	@Transactional
	public List<CommandLine> getAllCommandLines() {
		return commandLineDao.getAllCommandLines();
	}

	@Transactional
	public CommandLine getCommandLine(long id) {
		return commandLineDao.getCommandLine(id);
	}

	@Transactional
	public void addCommandLine(CommandLine commandLine) {
		commandLineDao.addCommandLine(commandLine);
	}

	@Transactional
	public void updateCommandLine(CommandLine commandLine) {
		commandLineDao.updateCommandLine(commandLine);

	}

	@Transactional
	public void deleteCommandLine(long id) {
		commandLineDao.deleteCommandLine(id);
	}
}

