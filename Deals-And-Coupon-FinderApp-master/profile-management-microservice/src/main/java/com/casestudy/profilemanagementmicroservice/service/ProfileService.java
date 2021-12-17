package com.casestudy.profilemanagementmicroservice.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.casestudy.profilemanagementmicroservice.model.User;

public interface ProfileService {
	
	public String joinGroup( User user);
	 public String giveAccessToUser( String userId, String userRole, Principal principal);
	 public List<User> loadUsers();
	

	 User getLoggedInUser(Principal principal);
	 public ResponseEntity<Object> deleteById(String id);
	
		

}
