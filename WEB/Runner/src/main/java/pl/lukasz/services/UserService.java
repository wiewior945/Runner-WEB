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
	 * zwraca true jeœli uzytkownik zosta³ stowrzony, false jeœli nazwa u¿ytkonika jest zajêta
	 * pewnie wypada³oby sprawdziæ czy u¿ytkownik zosta³ zapisany
	 */
	//TODO sprawdziæ czy user zosta³ zapisany
	public boolean saveNewUser(User user){
		if(getUserByName(user.getName())!=null){
			return false;
		}
		saveUser(user);
		return true;
	}
}
