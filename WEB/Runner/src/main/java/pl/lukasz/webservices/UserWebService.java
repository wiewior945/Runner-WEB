package pl.lukasz.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.lukasz.entities.User;
import pl.lukasz.services.UserService;



@RestController
public class UserWebService {

	@Autowired UserService userService;
	
	
	@RequestMapping("/webservice/login")
	@ResponseBody
	public User login(@RequestParam(value="name") String name, @RequestParam(value="password") String password){
		User tempUser = userService.getUserByName(name);
		if(tempUser!=null){
			if(tempUser.getPassword().equals(password)){
				return tempUser;
			}
		return null;
		}
		return null;
	}
	
	@RequestMapping("/webservice/register")
	public boolean register(@RequestParam(value="name") String name, @RequestParam(value="password") String password){
		User user = new User(name, password);
		return userService.saveNewUser(user);
	}
}
