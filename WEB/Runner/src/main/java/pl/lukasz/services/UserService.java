package pl.lukasz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lukasz.dao.UserDAO;
import pl.lukasz.entities.User;

@Service
public class UserService {

	@Autowired UserDAO userDao;
	
	public User getUserByName(String username){
		return userDao.getUserByName(username);
	}
}
