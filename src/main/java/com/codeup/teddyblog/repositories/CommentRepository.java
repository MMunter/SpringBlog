package com.codeup.teddyblog.repositories;

import com.codeup.teddyblog.Models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByPostId(long id);
}
