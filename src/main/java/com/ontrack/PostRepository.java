package com.ontrack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT t FROM Post t WHERE t.thread = ?1")
    public List<Post> findPosts(int id);
}