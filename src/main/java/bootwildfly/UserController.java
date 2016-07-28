package bootwildfly;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	@RequestMapping(value = "user}", method = RequestMethod.POST)
	public String addUser(){
		return String.format("created");
	}
	
	@RequestMapping(value = "user/login}", method = RequestMethod.POST)
	public String login(){
		return String.format("Logado");
	}
	
	@RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
	public String getUser(@PathVariable Long userId){
		return String.format("Id user passado: %s", userId);
	}

	@RequestMapping(value = "user/{userId}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long userId){
		return String.format("Id user passado: %s", userId);
	}
	
	@RequestMapping(value = "user/{userId}", method = RequestMethod.PUT)
	public String setUser(@PathVariable Long userId){
		return String.format("Id userId passado: %s", userId);
	}

}
