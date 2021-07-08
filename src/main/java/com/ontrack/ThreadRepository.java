package com.ontrack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThreadRepository extends JpaRepository<Thread, Long> {
    @Query("SELECT t FROM Thread t WHERE t.author = ?1")
    public List<Thread> findThreads(int id);

    @Query("SELECT t FROM Thread t WHERE t.id = ?1")
    public Thread getSingularThread(Long id);
}