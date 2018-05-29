package com.codeup.teddyblog.Models;

import javax.persistence.*;

@Entity
@Table (name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    @@Column(nullable = false)
    private String body;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
