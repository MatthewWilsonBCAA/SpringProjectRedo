package com.ontrack;

import javax.persistence.*;

@Entity
@Table(name = "allthreads")
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Column(nullable = false, unique = false, length = 45)
    private String title;

    @Column(nullable = false)
    private int author;
}