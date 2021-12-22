package com.hoaxify.ws.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.Service.CommentService;
import com.hoaxify.ws.entities.Comment;
import com.hoaxify.ws.request.CommentCreateRequest;
import com.hoaxify.ws.request.CommentUpdateRequest;
@Component
@RestController
@RequestMapping("/comment")
public class CommentController {
	



	@Autowired
	CommentService commentService;
	
	public CommentController(CommentService commentService) {
	
		this.commentService = commentService;
	} 
	
	//*************************************************************************
	@GetMapping  //userId ye veya postıd ye göre 
   public List<Comment> getCommnetAll (@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){
		return commentService.getCommentAll(userId,postId);
	}
	
	
	//********************************************************************
	
	@DeleteMapping("/{commentId}")
	public void deleteCommnet(@PathVariable Long commnetId) {
     commentService.deleteCommnet(commnetId);
	}
	
	//*****************************************************************************
	@GetMapping("/{commentId}") //comment ıd ye göre getir 
	
	public Comment getOneComment(@PathVariable Long commentId) {
		
		return commentService.getOneComment(commentId);
		
		
	}
	
	//****************************************************************************
	@PostMapping("/{userId}")
	public Comment createOneComment(@RequestBody CommentCreateRequest newcommnet) {
		return commentService.createOneComment(newcommnet);
	}
	
	
	//*************************************************************************
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest newupCommnet  ) {
		return  commentService.updateOneCommentById( commentId,newupCommnet );
	}
	
	
	
	

}
