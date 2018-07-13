package com.codeup.teddyblog.controllers;

import com.codeup.teddyblog.Models.Post;
import com.codeup.teddyblog.Models.User;
import com.codeup.teddyblog.repositories.CommentRepository;
import com.codeup.teddyblog.repositories.PostRepository;
import com.codeup.teddyblog.repositories.UserRepository;
import com.codeup.teddyblog.services.PostService;
import com.codeup.teddyblog.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    PostService postService;
    UserService userService;
    PostRepository postDao;
    UserRepository userDao;
    CommentRepository commentDao;

    public PostController (PostService postService, UserService userService, PostRepository postDao, UserRepository userDao, CommentRepository commentDao) {
       this.postService = postService;
       this.userService = userService;
       this.postDao = postDao;
       this.userDao = userDao;
       this.commentDao = commentDao;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String idPost(@PathVariable long id, Model model){
        User user = userService.loggedInUser();
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentDao.findAllByPostId(id));
        model.addAttribute("isOwnedBy", userService.isOwnedBy(post.getUser()));
        model.addAttribute("isLoggedIn", userService.isLoggedIn());
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String handleEdit(@PathVariable long id, @ModelAttribute Post post){
        Post originalPost = postDao.findOne(id);
        originalPost.setTitle(post.getTitle());
        originalPost.setBody(post.getBody());
        postDao.save(originalPost);
        return "redirect:/posts";

    }

    @GetMapping("/posts/create")
    public String createPostForm (Model model){
        model.addAttribute("post", new Post());
        return "posts/create";

    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post post){
            User loggedInUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            post.setUser(loggedInUser);
            postDao.save(post);
            return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postDao.delete(post);
        return "redirect:/posts";
    }


}
