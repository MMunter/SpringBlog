package com.codeup.teddyblog.controllers;

import com.codeup.teddyblog.Models.Post;
import com.codeup.teddyblog.Models.User;
import com.codeup.teddyblog.repositories.PostRepository;
import com.codeup.teddyblog.repositories.UserRepository;
import com.codeup.teddyblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    PostService postService;
    PostRepository postDao;
    UserRepository userDao;

    public PostController (PostService postService, PostRepository postDao, UserRepository userDao) {
       this.postService = postService;
       this.postDao = postDao;
       this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model){

        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String idPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String handleEdit(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";

    }

    @GetMapping("/posts/create")
    public String createPostForm (Model viewModel){
       viewModel.addAttribute("newPost", new Post());
       return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post newPost){
        User user = userDao.findOne(1L);
        newPost.setUser(user);
        postDao.save(newPost);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postDao.delete(post);
        return "redirect:/posts";
    }


}
