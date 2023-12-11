package com.trojan.newsletter.repository;

import com.trojan.newsletter.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByNewsIdIn(List<Long> ids);
}
