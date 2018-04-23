package com.codeup.teddyblog.Models;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String location;
}
