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
	
	public void saveUser(User user){
		userDao.saveUser(user);
	}
	
	/*
	 * zwraca true je�li uzytkownik zosta� stowrzony, false je�li nazwa u�ytkonika jest zaj�ta
	 * pewnie wypada�oby sprawdzi� czy u�ytkownik zosta� zapisany
	 */
	//TODO sprawdzi� czy user zosta� zapisany
	public boolean saveNewUser(User user){
		if(getUserByName(user.getName())!=null){
			return false;
		}
		saveUser(user);
		return true;
	}
}
