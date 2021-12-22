package com.hoaxify.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="commentk")//Tablo adı user olmaz
public class Comment {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="post_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Post post;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	UserK user;
	
	
	
	
	@Lob
	@Column(columnDefinition="text")
	String text;




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Post getPost() {
		return post;
	}




	public void setPost(Post post) {
		this.post = post;
	}




	public UserK getUser() {
		return user;
	}




	public void setUser(UserK user) {
		this.user = user;
	}




	public String getText() {
		return text;
	}




	public void setText(String text) {
		this.text = text;
	}
	
	
	
	

}
