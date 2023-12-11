package com.spring.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.spring.user.entity.User;
import com.spring.user.exceptionhandling.UserNotFoundByIdException;
import com.spring.user.exceptionhandling.UserNotFoundByMailException;
import com.spring.user.exceptionhandling.UserNotFoundByNameException;
import com.spring.user.exceptionhandling.UsersNotFound;
import com.spring.user.repository.UserRepository;
import com.spring.user.utility.ErrorStructure;
import com.spring.user.utility.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserRepository ur;

	public ResponseEntity<ResponseStructure<String>> inserUser(User li) {
		
		
		ur.save(li);

		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage(" User data saved successfully");
		rs.setData(" 1 USER ADDED  SUCCESSFULLY");
		
	
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		ResponseStructure<User> rs ;
		Optional<User> id1= ur.findById(id);
		if (id1.isPresent()) {
			rs = new ResponseStructure<User>();
			User u = id1.get();
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setMessage(" User Fetched successfully");
			rs.setData(u);
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.FOUND);

		}
		else {
		throw new UserNotFoundByIdException("user not found ");
		}
		
		
	}

	public ResponseEntity<ResponseStructure<List<User>>> findUserByname(String name) throws UserNotFoundByNameException  {
		ResponseStructure<List<User>> 	rs = new ResponseStructure<List<User>>();
		
	        List<User> namelist = ur.findByName(name);
		if (!namelist.isEmpty()) {
		
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setMessage(" User Fetched successfully");
			rs.setData(namelist);
			return new ResponseEntity<ResponseStructure<List<User>>>(rs, HttpStatus.FOUND);

		}
		else throw new UserNotFoundByNameException("user not foud ");
	}

	public ResponseEntity<ResponseStructure<User>> findUserBymail(String mail) throws UserNotFoundByMailException {
		ResponseStructure<User> rs ;
		
		Optional<User> id1= ur.findBymail(mail);
		
		if (id1.isPresent()) {
			rs = new ResponseStructure<User>();
			User u = id1.get();
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setMessage(" User Fetched successfully");
			rs.setData(u);
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.FOUND);

		}
		else {
		throw new UserNotFoundByMailException("user not found ");
		}
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAll() throws UsersNotFound {
		
		ResponseStructure<List<User>> 	rs = new ResponseStructure<List<User>>();
		
        List<User> namelist = ur.findAll();
	if (!namelist.isEmpty()) {
	
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage(" All Users Fetched successfully");
		rs.setData(namelist);
		return new ResponseEntity<ResponseStructure<List<User>>>(rs, HttpStatus.FOUND);

	}
	else throw new UsersNotFound("users not foud ");
	
		
	}

	public ResponseEntity<ResponseStructure<String>> UpdateUserById(User li,int id) {
		     
	   Optional<User> id2 = ur.findById(id);
	   
	   if(id2.isPresent()) {

		   
		   ur.save(li);
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage(" User data saved successfully");
		rs.setData("  USER UPDATED SUCCESSFULLY");
		
	   
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.CREATED);
	   }
	   
	   else throw new UserNotFoundByIdException(" cannot updated user not found ");
	
	}

	public ResponseEntity<ResponseStructure<String>> UpdateUserByMail(User li, String mail) throws UserNotFoundByMailException {
		    Optional<User> id2 = ur.findBymail(mail);
		   
		   if(id2.isPresent()) {

			   
			   ur.save(li);
			ResponseStructure<String> rs = new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage(" User data saved successfully");
			rs.setData("  USER UPDATED SUCCESSFULLY");
			
		   
			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.CREATED);
		   }
		   
		   else throw new UserNotFoundByMailException(" cannot updated ,user not found ");
		
	}

	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id) {
		 Optional<User> id2 = ur.findById(id);
		 
		 
		if( id2.isPresent()) {
			
			 ur.deleteById(id);
			 
				ResponseStructure<String> rs = new ResponseStructure<>();
				rs.setStatusCode(HttpStatus.FOUND.value());
				rs.setMessage(" User data deleted successfully");
				rs.setData("  USER DELETED SUCCESSFULLY");
				
			   
				return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);
			   }
			   
			   else throw new UserNotFoundByIdException(" cannot delete, user not found ");
			
			
		}

	public ResponseEntity<ResponseStructure<String>> deleteUserByMail(String mail) throws UserNotFoundByMailException {
		 Optional<User> id2 = ur.findBymail(mail);
		 
		 
		if( id2.isPresent()) {
			
			 ur.deleteByMail(mail);
			 
				ResponseStructure<String> rs = new ResponseStructure<>();
				rs.setStatusCode(HttpStatus.FOUND.value());
				rs.setMessage(" User data deleted successfully");
				rs.setData("  USER DELETED SUCCESSFULLY");
				
			   
				return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);
			   }
			   
			   else throw new UserNotFoundByMailException("cannot delete, user not found");
			
	}
	
	
	
}
	
			
