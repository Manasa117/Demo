package com.spring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.entity.User;
import com.spring.user.exceptionhandling.UserNotFoundByMailException;
import com.spring.user.exceptionhandling.UserNotFoundByNameException;
import com.spring.user.exceptionhandling.UsersNotFound;
import com.spring.user.service.UserService;
import com.spring.user.utility.ResponseStructure;

@RestController
public class UserController {
	
	@Autowired
	UserService us;

	
	
	
	@PostMapping("/addUser")  
	public ResponseEntity<ResponseStructure<String>> insertUser(@RequestBody User li)
	{
	
		 ResponseEntity<ResponseStructure<String>> user = us.inserUser(li);
		 
		
		 return user;
	}
	
	

	@GetMapping("/findid/{id}") 
		public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id)
	
	{
		
		return us.findUserById(id);
		
	}
	
	@GetMapping("/findname/{name}") 
	public ResponseEntity<ResponseStructure<List<User>>> findUserByname(@PathVariable String name) throws UserNotFoundByNameException

{
	
	return us.findUserByname(name);
	
}
	@GetMapping("/findemail/{mail}") 
	public ResponseEntity<ResponseStructure<User>> findUserBymail(@PathVariable String mail) throws UserNotFoundByMailException

{
	
	return us.findUserBymail(mail);
	
}
	  
	@GetMapping("/findall") 
	public ResponseEntity<ResponseStructure<List<User>>> findAll() throws UsersNotFound 

{
	
	return us.findAll();
	
}
	
	
	@PostMapping("/updateid/{id}") 
	public ResponseEntity<ResponseStructure<String>> findUserById(@RequestBody User li,@PathVariable int  id)

{
	
	return us.UpdateUserById(li,id);
	
}
	
	
	@PostMapping("/updateid/{mail}") 
	public ResponseEntity<ResponseStructure<String>> findUserBymail(@RequestBody User li,@PathVariable String mail) throws UserNotFoundByMailException

{
	
	return us.UpdateUserByMail(li,mail);
	
}
	
	
	@DeleteMapping("/deleteid/{id}") 
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int id)

{
	
	return us.deleteUserById(id);
	
}
	
	@DeleteMapping("/deletemail/{mail}") 
	public ResponseEntity<ResponseStructure<String>> deleteUserByMail(@PathVariable String mail) throws UserNotFoundByMailException

{
	
	return us.deleteUserByMail(mail);
	
}

}
