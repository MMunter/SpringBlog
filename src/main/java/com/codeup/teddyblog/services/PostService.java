package com.codeup.teddyblog.services;

import com.codeup.teddyblog.Models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post getPost(long id){
        return posts.get(((int)id) - 1);
    }

    public void createPosts() {
        posts.add(new Post("Title 1", "Test Post."));
        posts.add(new Post("Title 2", "Test Post 2."));
    }

    public void save(Post post) {
        this.posts.add(post);

    }

}
