package com.hoaxify.ws.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hoaxify.ws.Repository.LikeRepository;
import com.hoaxify.ws.entities.Like;
import com.hoaxify.ws.entities.Post;
import com.hoaxify.ws.entities.UserK;
import com.hoaxify.ws.request.LikeCreateRequest;

@Service
public class LikeService {
	
	

	private LikeRepository likeRepository;
	private UserKService userService;
	private PostService postService;
	
	

	public LikeService(LikeRepository likeRepository, UserKService userService, PostService postService) {
		super();
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}



	public LikeService(LikeRepository likeRepository) {
		super();
		this.likeRepository = likeRepository;
	}
	
	//*************************************************************************




	public List<Like> getAllList(Optional<Long> userId, Optional<Long> postId) {
		
		
		if(userId.isPresent() && postId.isPresent()) {
			return likeRepository.findByuserIdAndPostId(userId.get(),postId.get());
		}
		else if(userId.isPresent() ) {
			return likeRepository.findByuserId(userId.get());
		}else if( postId.isPresent()) {
			return likeRepository.findBypostId(userId.get());
		}
		else {
		return likeRepository.findAll(); 
		
		
		}
		
		
		
		
		
	}



	public Like getOneLikeById(Long likeId) {
		
		return likeRepository.findById(likeId).orElse(null);
	}



	public void deleteOneLikeById(Long likeId) {
		
         likeRepository.deleteById(likeId);
	}


//ben bir kullanıcımıym ya da like yapabileceğim bir post varmı
	public Like createLike(LikeCreateRequest request) {
	  UserK user= userService.UserKBul(request.getUserId());
	  Post post=postService.getOnePostById(request.getPostId());
	  
	  if(user!=null && post!=null) {
		  Like likesave=new Like();
		  likesave.setId(request.getId());
		  likesave.setPost(post);
		  likesave.setUser(user);
		  return likeRepository.save(likesave);
		  
	  }else {
		  return null;
	  }
	      
		
	}

}
