package com.ontrack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface ThreadRepository extends JpaRepository<Thread, Long> {
    //@Query("SELECT u FROM User u WHERE u.email = ?1")

}