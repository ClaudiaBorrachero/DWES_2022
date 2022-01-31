package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.UserDAO;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserServiceImpl (final Session session) {
		this.userDAO = new UserDAOImpl(session);
	}
	
	@Override
	public void insertNewUser(User user) {
		if (user != null && user.getId() == null) {
			userDAO.insert(user);
		}
	}

	@Override
	public void updateUser(User user) {
		if (user != null && user.getId() != null) {
			userDAO.update(user);
		}
	}

	@Override
	public void deleteUser(User user) {
		if (user != null && user.getId() != null) {
			userDAO.delete(user);
		}
	}

	@Override
	public User searchById(Long userId) {
		User users = null;
		if (userId != null) {
			users = userDAO.searchById(userId);
		}
		return users;
	}

	@Override
	public List<User> searchAll() {
		List<User> usersList = new ArrayList<User>();
		usersList = userDAO.searchAll();
		return usersList;
	}

	@Override
	public List<User> searchByEmail(String email, String name) {
		List<User> usersList = new ArrayList<User>();
		if (name!=null || email!=null) {
			usersList = userDAO.searchByEmail(email, name);
		}
		return usersList;
	}

}
