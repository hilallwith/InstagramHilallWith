package com.hoaxify.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;
@Data
@Entity
@Table(name="postk")//Tablo adı user olmaz
public class Post {
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)  //bir kullanıcının birden çok post u olabilir //hemen gelsi 
	@JoinColumn(name="user_id", nullable=false)   //null olmasım 
	@OnDelete(action = OnDeleteAction.CASCADE)   //bir user silindiğindepostlarını sil derim 
	UserK user;
	
	
	
	
	String title;
	@Lob
	@Column(columnDefinition="text")
	String text;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public UserK getUser() {
		return user;
	}
	public void setUser(UserK user) {
		this.user = user;
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
