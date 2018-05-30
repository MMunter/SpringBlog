package com.codeup.teddyblog.Models;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    //Create relationship to the users table
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="posts_categories",
    joinColumns ={@JoinColumn(name="post_id")},
    inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    private List<Categories> categories;


    public Post(){}

    public Post(long id, String title, String body, User user, List<Comment> comments){
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = comments;
    }

    public Post(String title, String body, User user, List<Comment> comments){
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
}
