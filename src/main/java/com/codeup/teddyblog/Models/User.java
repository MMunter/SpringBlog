package com.codeup.teddyblog.Models;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Post> posts;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;

    public User(String username, String email, String password, List<Post>posts, List<Comment> comments){
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.comments = comments;
    }

    public User(long id, String username, String email, String password, List<Post> posts, List<Comment> comments){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.comments = comments;
    }

    public User(User copy){
        this.id = copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
    }

    public User(){}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
