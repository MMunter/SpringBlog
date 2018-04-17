package com.codeup.teddyblog.controllers;

import com.codeup.teddyblog.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String Index(){
        return "This is the posts index page.";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String IdPost(@PathVariable long id, Model model){
        return "This is the post page for ID#" + id + ".";

    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String CreatePostFrom (){
        return "This is the form for creating a post.";
//        Post post = new Post();
//        post.getTitle();
//        post.getBody();
//        return
    }

    //tyt
    //tyt

    @PostMapping("/posts/create")
    @ResponseBody
    public String CreatePost(){
        return "This creates the post.";
    }
}
