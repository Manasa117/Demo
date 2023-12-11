package com.spring.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.user.entity.User;

import jakarta.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.userName LIKE %?1%")
	public List<User> findByName(String name);
	
	
	@Query("select u from User u where u.email LIKE %?1%")
	public Optional<User> findBymail(String mail);

	
	@Transactional
	@Modifying
	@Query("delete  from User u where u.email LIKE %?1%")
	public void deleteByMail(String mail);
	
	

}
