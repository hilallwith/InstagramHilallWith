package com.hoaxify.ws.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoaxify.ws.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	List<Like> findByuserIdAndPostId(Long userId, Long postId);

	List<Like> findByuserId(Long userId);

	List<Like> findBypostId(Long postId);

	

}
