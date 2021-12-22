package com.hoaxify.ws.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoaxify.ws.entities.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	

	List<Comment> findByUserIdAndPostoId(Long userId, Long postId);

	List<Comment> findByUserId(Long userId);

	List<Comment> findByPostId(Long postId);

}
