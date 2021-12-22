package com.hoaxify.ws.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hoaxify.ws.Repository.LikeRepository;
import com.hoaxify.ws.Repository.PostRepository;
import com.hoaxify.ws.Repository.UserKRepository;
import com.hoaxify.ws.Response.PostResponse;
import com.hoaxify.ws.entities.Like;
import com.hoaxify.ws.entities.Post;
import com.hoaxify.ws.entities.UserK;
import com.hoaxify.ws.request.PostCreatRequest;
import com.hoaxify.ws.request.PostUpdateRequest;

@Service
public class PostService {
	
    PostRepository postRepository;  
    LikeService likeService;
	
	private  PostService(PostRepository postRepository) {
		
		this.postRepository = postRepository;
	}
	
	
	UserKService userService;

	

	

	public PostService(PostRepository postRepository, UserKService userService) {
		
		this.postRepository = postRepository;
		this.userService = userService;
	}
	
	
	
	
	

	public List<PostResponse> getAllPost(Optional<Long> userId) {
		
		List<Post> list;
		
	if(userId.isPresent()) {
	list=postRepository.findByUserId(userId); //user varsa userın postlarının listesini atıyorum listeye 
	}
	else {
	list= postRepository.findAll(); //yoksa herkesin postlarını listeye atarım 
	}
	
	return list.stream().map(k->{ 
		
	List <Like> likes= likeService.getAllList(null,Optional.of(k.getId()));
		return new PostResponse(k,likes);
		
	
	
	}).collect(Collectors.toList()); 
	}
	
	//Post listesini dbden çektin map ile potresponseye çevirip dönerim 
	//return list.stream().map(k-> new PostResponse(k)).collect(Collectors.toList());
	//deneme
	
	
	
	
	
	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
		
	}

	

	public void deleteOnePost(Long postId) {
		postRepository.deleteById(postId);
		
	}

	public Post creatOnePost(PostCreatRequest newpostrequest) {
      UserK user=userService.UserKBul(newpostrequest.getUserId());
      
      if(user==null) {
    	  return null;
      }
      else {
    	  Post postsave=new Post();
    	  postsave.setId(newpostrequest.getId());
    	  postsave.setTitle(newpostrequest.getTitle());
    	  postsave.setText(newpostrequest.getText());
    	  postsave.setUser(user);
    	  
    	  
    	  
    	  
    	  return postRepository.save(postsave);
      }
		
		
		
		
		
		
	}

	public Post updateOnePost(Long postId, PostUpdateRequest newupdatepost) {
		
		Optional<Post> post=postRepository.findById(postId);
		
		if(post.isPresent()) {
			Post post1=post.get();
			post1.setText(newupdatepost.getText());
			post1.setTitle(newupdatepost.getTitle());
			postRepository.save(post1);
			return  post1;
		}
		else {
			return null;
		}
	}

	

	
	
	
	
	
	
}
