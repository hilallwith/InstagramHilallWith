package com.hoaxify.ws.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.Service.LikeService;
import com.hoaxify.ws.entities.Like;
import com.hoaxify.ws.request.LikeCreateRequest;

@RestController
@RequestMapping("/likes")
public class LikeController {
	
	private LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}
	
	//*******************************************
	
	
	@GetMapping()
	public List<Like> getAllList (@RequestParam Optional<Long> userId, 
			@RequestParam Optional<Long> postId){
		
		return likeService.getAllList(userId,postId);
		
	}
	
	@GetMapping("/{likeId}")
	public Like getOneLikeById(@PathVariable Long likeId) {
		
		return likeService.getOneLikeById(likeId);
		
	}
	
	@DeleteMapping("/{likeId}")
	public void deleteOneLikeById(@PathVariable Long likeId) {
		likeService.deleteOneLikeById(likeId);
	}
	
	@PostMapping
	
	public Like createLike(@RequestParam LikeCreateRequest request) {
		return likeService.createLike(request);
	}
	
	
	
	
	

}
