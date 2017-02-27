package com.atos.techstudio.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atos.techstudio.model.Login;
import com.atos.techstudio.service.LoginService;

 
@Controller
@RequestMapping(value = "/loginValidate/")
public class LoginController {
 
    @Autowired
    LoginService loginService;  
    
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Boolean> validateUser(@RequestBody Login login) {
		System.out.println("login controller");
		System.out.println("login username -- " + login.getUsername());
		System.out.println("login password -- " + login.getPassword());
		boolean result = loginService.validateUser(login);
		System.out.println(result);
		if (!result) {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
 
}