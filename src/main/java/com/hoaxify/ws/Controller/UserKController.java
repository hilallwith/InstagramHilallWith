package com.hoaxify.ws.Controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hoaxify.ws.Service.UserKService;
import com.hoaxify.ws.entities.UserK;


@RestController
@RequestMapping("/users")
public class UserKController {
	
	/*private UserKRepository userRepository;
	
	public UserKController(UserKRepository userRepository) {  //Repo yu ınject ettik. /7ama tercih edilen 
		//birşey değil çünkü Controller da yapılan birsürü iş var böyle olmaması gerekiyor.
		//bize bu işe servis eden bir katmana ihtiyacımız var...
		this.userRepository=userRepository;
	}
	
	*/   
	//bu yüzden artık controller da repositorye değil service bağlanıcaz 
	
	private UserKService userService;
	
	
	public UserKController(UserKService userService) {
		
		this.userService = userService;
	}

	
	
	
	
	@GetMapping
	public List<UserK> getAllUserk(){   //kullanıcıları çekmek için getmapping ve findall
		return userService.getallUserK();
		
	}
	
	@PostMapping                                                            //istekteki RequestBody den gelen bilgileri userK ya maple ve ordan gelen bilgilerle save yapayım  
	public UserK CreateSave(@RequestBody  UserK newuser) {      // kullanıcı eklemek içiin post ve save metodu kullanılır
		 return userService.UserKsave(newuser);
		 
	}
	
	@GetMapping("/{userId}")
	
	public UserK KBul(@PathVariable Long userId) {
		//customException ekle
		return userService.UserKBul(userId);
	}
	
	@PutMapping ("/{userId}")  //duserıd ile post yapamayız çünkü ıd yi biz veririz put ile var olan ıd li veriyi değiştirebiliriz 
	public UserK UserUpdate(@PathVariable Long userId,@RequestBody  UserK newuser) {
		return userService.UserKDuzenle(userId, newuser);
		}
	
	
	@DeleteMapping  ("/{userId}") 
	public void DeleteUserK(@PathVariable Long UserId) {
		userService.UserKDelete(UserId);
	}
	
	
	
	
	

}
