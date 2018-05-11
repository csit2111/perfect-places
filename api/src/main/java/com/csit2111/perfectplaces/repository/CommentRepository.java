package com.csit2111.perfectplaces.repository;

import com.csit2111.perfectplaces.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
