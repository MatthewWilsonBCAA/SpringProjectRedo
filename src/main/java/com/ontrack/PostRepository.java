package com.ontrack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface PostRepository extends JpaRepository<Post, Long> {
    //@Query("SELECT u FROM User u WHERE u.email = ?1")

}