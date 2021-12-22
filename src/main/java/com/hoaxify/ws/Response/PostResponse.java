package com.hoaxify.ws.Response;

import java.util.List;

import com.hoaxify.ws.entities.Like;
import com.hoaxify.ws.entities.Post;

import lombok.Data;
@Data
public class PostResponse {
	

	Long id;
	Long userId;
	String userName;
	String title;
	String text;
	List<Like> postLikes;
	
	
	public PostResponse(Post entity,List<Like> likes) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.title = entity.getTitle();
		this.text = entity.getText();
		this.postLikes = likes;
		
		
	

}
	

	public List<Like> getPostLikes() {
		return postLikes;
	}


	public void setPostLikes(List<Like> postLikes) {
		this.postLikes = postLikes;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
}