package com.codeup.teddyblog.controllers;

import com.codeup.teddyblog.Models.Post;
import com.codeup.teddyblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    PostService postService;

    public PostController (PostService postService) {
       this.postService = postService;
    }

    @GetMapping("/posts")
    public String index(Model model){

        model.addAttribute("posts", postService.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String idPost(@PathVariable long id, Model model){
       model.addAttribute("post", postService.getPost(id));
       return "/posts/show";

    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        idPost(id, model);
        return "/posts/edit";
    }



    @GetMapping("/posts/create")
    public String createPostForm (Model viewModel){
       viewModel.addAttribute("newPost", new Post());
       return "/posts/create";

    }



    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post newPost){
        postService.save(newPost);
        return "redirect:/posts";
    }


}
