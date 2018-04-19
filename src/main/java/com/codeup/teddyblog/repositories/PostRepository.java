package com.codeup.teddyblog.repositories;

import com.codeup.teddyblog.Models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    public Post findById(long id);

    public void delete(Post post);

}
