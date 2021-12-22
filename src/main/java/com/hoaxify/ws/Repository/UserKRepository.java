package com.hoaxify.ws.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoaxify.ws.entities.UserK;

public interface UserKRepository extends JpaRepository<UserK, Long > {
	
	//repolar database query yani istek atmamıza yardımcı olur içinde barındırdıkarı  metodları query gibi düşünebiliriz  
	

}
