package com.codeup.teddyblog.controllers;

import org.springframework.stereotype.Controller;
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
    public String IdPost(@PathVariable int id){
        return "This is the post page for ID#" + id + ".";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String CreatePost(){
        return "This is the form for creating a post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String PostCreate(){
        return "This creates the post.";
    }
}
