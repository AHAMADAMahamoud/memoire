package com.kmsoft.memoire;

import javax.websocket.server.PathParam;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiPassword {

	
	@GetMapping("/convert/{pwd}")
	public static String generatePassword(@PathVariable(value = "pwd") String password){
		BCryptPasswordEncoder bpw=new BCryptPasswordEncoder();
		return bpw.encode(password);
	}
}