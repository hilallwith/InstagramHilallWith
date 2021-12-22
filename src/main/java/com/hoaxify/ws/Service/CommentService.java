package com.hoaxify.ws.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoaxify.ws.Repository.CommentRepository;
import com.hoaxify.ws.entities.Comment;
import com.hoaxify.ws.entities.Post;
import com.hoaxify.ws.entities.UserK;
import com.hoaxify.ws.request.CommentCreateRequest;
import com.hoaxify.ws.request.CommentUpdateRequest;
@Service
public class CommentService {

	CommentRepository commentRepositroy;
	
	public CommentService(CommentRepository commentRepositroy) {
	
		this.commentRepositroy = commentRepositroy;
	}
	
	public CommentService() {
		
	
	}
	
	UserKService userService; 
	PostService postService;
	
	public CommentService(CommentRepository commentRepositroy, UserKService userService, PostService postService) {
	
		this.commentRepositroy = commentRepositroy;
		this.userService = userService;
		this.postService = postService;
	}

	
	
	



	//***************************************************************




	




	



	public void deleteCommnet(Long commnetId) {
		 commentRepositroy.deleteById(commnetId);
		
	}




	public List<Comment> getCommentAll(Optional<Long> userId, Optional<Long> postId) {
		
		if(userId.isPresent() && postId.isPresent()) {
			return commentRepositroy.findByUserIdAndPostoId(userId.get(),postId.get());
		}
		else if (userId.isPresent()) {
			return commentRepositroy.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			return commentRepositroy.findByPostId(postId.get());
		}
		else {
			return commentRepositroy.findAll();
		}
			
		
		
		
	}









	public Comment getOneComment(Long commentId) {
		
	 return commentRepositroy.findById(commentId).orElse(null);
	}









	public Comment createOneComment(CommentCreateRequest newcommnet) {
		
		UserK user = userService.UserKBul(newcommnet.getUserId());
		Post post=postService.getOnePostById(newcommnet.getPostId());
		
		if(user!=null && post!=null ) {
			Comment csave=new Comment();
			csave.setText(newcommnet.getText());
			csave.setId(newcommnet.getId());
			csave.setPost(post);
			csave.setUser(user);
			commentRepositroy.save(csave);
			return csave;
		}
		else {
			return null;
			}
	}







	







	public Comment updateOneCommentById(Long commentId, CommentUpdateRequest newupCommnet) {
		Optional<Comment> commnet=commentRepositroy.findById(commentId);
		
		if(commnet.isPresent()) {
			Comment com=commnet.get();
			com.setText(newupCommnet.getText());
		return 	commentRepositroy.save(com);
		}else {
			return null;
		}
		
		
		
		
		
	}







	


//***********************************************************************************
	




	
	
	
	

}
