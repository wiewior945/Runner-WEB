package pl.lukasz.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.lukasz.dao.UserDAO;
import pl.lukasz.entities.LoggedUser;
import pl.lukasz.entities.User;
import pl.lukasz.services.UserService;

@Controller
public class DashboardController {
	
	@Autowired private UserService userService;
	@Autowired private LoggedUser loggedUser;
	
	@RequestMapping("/getUserData")
	public String login(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    loggedUser.setUser(userService.getUserByName(username));
		return "dashboard";
	}

	@RequestMapping("/dashboard")
	public String dashboard(){
		return "dashboard";
	}
}
