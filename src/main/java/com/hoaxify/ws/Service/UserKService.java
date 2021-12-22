package com.hoaxify.ws.Service;

import java.util.List;
import java.util.Optional;

import com.hoaxify.ws.Repository.UserKRepository;
import com.hoaxify.ws.entities.UserK;

public class UserKService {
	
	UserKRepository userRepository;

	public UserKService(UserKRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	public List<UserK> getallUserK() {
		return userRepository.findAll();
	}

	public UserK UserKsave(UserK newuser) {
		return userRepository.save(newuser);
	}

	public UserK UserKBul(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public void UserKDelete(Long userId) {
		userRepository.deleteById(userId);
		
	}

	public UserK UserKDuzenle(Long userId, UserK newuser) {
Optional<UserK> user= userRepository.findById(userId); //userı alıyorum 
		
		if(user.isPresent()) {  //obje varsa 
			UserK foundUser=user.get();  //objeyi aldım 
			foundUser.setUserName(newuser.getUserName());
			foundUser.setPassword(newuser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
			
		}
		else {
			return null;//***
		}
	}

	
	
	
	

	
	

}
