package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.vermeg.bookstore.model.CommandLine;


@Repository
public class CommandLineDAO  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	public List<CommandLine> getAllCommandLines() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CommandLine> commandLineList = session.createQuery("from CommandLine").list();
		
		for (CommandLine c:commandLineList) {
			System.out.println("Count "+c.getId());
		}
		
		return commandLineList;
	}
	
	
	public CommandLine getCommandLine(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		CommandLine commandLine = (CommandLine) session.get(CommandLine.class, new Long(id));
		return commandLine;
	}

	public CommandLine addCommandLine(CommandLine commandLine) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(commandLine);
		return commandLine;
	}

	public void updateCommandLine(CommandLine commandLine) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(commandLine);
	}

	public void deleteCommandLine(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		CommandLine c = (CommandLine) session.load(CommandLine.class, new Long(id));
		if (null != c) {
			session.delete(c);
		}
	}	

}
