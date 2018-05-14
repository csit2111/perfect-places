package com.csit2111.perfectplaces.service;

import com.csit2111.perfectplaces.model.Comment;

import java.util.Collection;

public interface CommentService {
    Comment addComment(Comment comment);
    Collection<Comment>getAll();
}
