package com.hoaxify.ws.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.Repository.PostRepository;
import com.hoaxify.ws.Response.PostResponse;
import com.hoaxify.ws.Service.PostService;
import com.hoaxify.ws.entities.Post;
import com.hoaxify.ws.entities.UserK;
import com.hoaxify.ws.request.PostCreatRequest;
import com.hoaxify.ws.request.PostUpdateRequest;

@RestController
@RequestMapping("/posts")
public class PostControlller {
	
	
	
	PostService postService;
	
	
	public PostControlller(PostService postService) {
		
		this.postService = postService;
	}





	@GetMapping("/{userId}")  //ıd ye ait postlar 
	public List<PostResponse> getAllPost(@RequestParam Optional<Long> userId){ //null gelsede gelmesede
		
		return postService.getAllPost(userId);
	
	

}
	
	
	
	@GetMapping("/{postId}") //postıd ye ait post
	 public Post getOnePost(@PathVariable Long  postId) {
		
		return postService.getOnePostById(postId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreatRequest newpostrequest) {
		return postService.creatOnePost(newpostrequest);
	
		
	}
	
	@DeleteMapping
	public void deleteOnePost( Long  postId) {
		postService.deleteOnePost(postId);
	}
	
	@PutMapping("/{postId}")
	
	public Post updateOnePost(@PathVariable Long postId ,@RequestBody PostUpdateRequest newupdatepost) {
		return postService.updateOnePost(postId, newupdatepost);
	}
	
	
	
	
	
	
	

}
