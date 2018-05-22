package edu.usach.grupo2mingeso2s2017;

import java.security.Principal;

import edu.usach.grupo2mingeso2s2017.models.LogIn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRestController {
	@RequestMapping("/user")
	public Principal sayHello(Principal principal) {
		return principal;
	}

}
