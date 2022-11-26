package javaObjects;

import javaDAO.ApplicationDAO;

public class UserFactory {
	
	public User getUser(int type, String email) {
		User user;
		
		if(type == 1) {
			user = ApplicationDAO.getProfessor(email);
		}
		else  {
			user = ApplicationDAO.getStudent(email);
		}
		return user;
	}

}
