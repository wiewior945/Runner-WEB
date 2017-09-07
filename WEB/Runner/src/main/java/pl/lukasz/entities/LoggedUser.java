package pl.lukasz.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class LoggedUser{

	private User user;
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
}
