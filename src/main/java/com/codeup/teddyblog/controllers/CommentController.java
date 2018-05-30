package com.codeup.teddyblog.controllers;

import com.codeup.teddyblog.Models.Comment;
import com.codeup.teddyblog.Models.User;
import com.codeup.teddyblog.repositories.CommentRepository;
import com.codeup.teddyblog.repositories.PostRepository;
import com.codeup.teddyblog.repositories.UserRepository;
import com.codeup.teddyblog.services.PostService;
import com.codeup.teddyblog.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    PostService postDao;
    UserService userDao;
    PostRepository postRepo;
    UserRepository userRepo;
    CommentRepository commentRepo;

    public CommentController(PostService postDao, UserService userDao, PostRepository postRepo, UserRepository userRepo, CommentRepository commentRepo) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/posts/{id}/comments/{cid}")
    public String showComment(@PathVariable long id, @PathVariable long cid, Model model){
        model.addAttribute("post", postRepo.findOne(id));
        model.addAttribute("comment", commentRepo.findOne(cid));
        return "comments/show";
    }

    @GetMapping("posts/{id}/comments/create")
    public String createComment(@PathVariable long id, Model model){
        model.addAttribute("post", postRepo.findOne(id));
        model.addAttribute("comment", new Comment());
        return "comments/create";
    }

    @PostMapping("posts/{id}/comments/create")
    public String insertComment(@PathVariable long id, @ModelAttribute Comment comment){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setPost(postRepo.findById(id));
        comment.setUser(loggedInUser);
        commentRepo.save(comment);
        return "redirect:/posts/{id}";
    }

    @GetMapping("posts/{id}/comments/{cid}/edit")
    public String editComment(@PathVariable long id, @PathVariable long cid, Model model){
        model.addAttribute("post", postRepo.findOne(id));
        model.addAttribute("comment", commentRepo.findOne(cid));
        return "comments/edit";
    }

    @PostMapping("posts/{id}/comments/{cid}/edit")
    public String updateComment(@PathVariable long id, @PathVariable long cid, @ModelAttribute Comment comment, Model model){
        User user = userDao.loggedInUser();
        Comment origComment = commentRepo.findOne(cid);
        origComment.setId(cid);
        origComment.setBody(comment.getBody());
        origComment.setPost(postRepo.findById(id));
        origComment.setUser(user);
        commentRepo.save(origComment);
        model.addAttribute("post", postRepo.findOne(id));
        model.addAttribute("isOwnedBy", userDao.isOwnedBy(origComment.getUser()));
        model.addAttribute("isLoggedIn", userDao.isLoggedIn());
        return "redirect:/posts/{id}";
    }

    @PostMapping("posts/{id}/comments/delete")
    public String deleteComment(@PathVariable long id, @ModelAttribute Comment comment, Model model){
        commentRepo.delete(comment);
        model.addAttribute("post", postRepo.findOne(id));
        return "redirect:/posts/{id}";
    }






}
