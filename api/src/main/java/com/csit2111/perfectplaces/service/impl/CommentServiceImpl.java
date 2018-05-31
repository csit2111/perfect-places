package com.csit2111.perfectplaces.service.impl;

import com.csit2111.perfectplaces.model.Comment;
import com.csit2111.perfectplaces.model.Place;
import com.csit2111.perfectplaces.repository.CommentRepository;
import com.csit2111.perfectplaces.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Collection<Comment> getAll() {
        return commentRepository.findAll();
    }
}
